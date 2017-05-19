package com.tree.www.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

// 重写类加载器
public class CompileClassLoader extends ClassLoader {

	private byte[] getBytes(String fileName) throws IOException {
		File file = new File(fileName);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		try (FileInputStream fin = new FileInputStream(file)) {
			int r = fin.read(raw);
			if (r != len) {
				throw new IOException("无法读取全部文件：" + r + " !=" + len);
			}
			return raw;
		}
	}

	private boolean compile(String javaFile) throws IOException{
		System.out.println("CompileClassLoader:正在编译 " + javaFile + "...");
		
		Process p = Runtime.getRuntime().exec("javac " + javaFile);
		try{
			p.waitFor();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		return p.exitValue() == 0;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class clazz = null;
		String fileSub = name.replace(".", "/");
		String javaFileName = fileSub + ".java";
		String classFileName = fileSub + ".class";
		File javaFile = new File(javaFileName);
		File classFile = new File(classFileName);

		if (javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()) {
			try {
				if (!compile(javaFileName) || !classFile.exists()) {
					throw new ClassNotFoundException("ClassNotFoundException:" + javaFileName);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		if (classFile.exists()) {
			try {
				byte[] raw = getBytes(classFileName);

				clazz = defineClass(name, raw, 0, raw.length);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		if (clazz == null) {
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			System.out.println("缺少目标类，按如下格式运行Java源文件");
			System.out.println("java CompileClassLoader ClassName");
		}

		String progClass = args[0];

		String[] progArgs = new String[args.length - 1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		
		CompileClassLoader ccl = new CompileClassLoader();
		Class<?> clazz = ccl.loadClass(progClass);
		Method main = clazz.getMethod("main", new String[0].getClass());
		
		main.invoke(null, progArgs);
	}
}
