package com.tree.www.annotation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;

// 根据注解生成xml文件
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({ "Persistent", "Id", "Property" })
public class HibernateAnnotationProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

		PrintStream ps = null;

		try {
			// 遍历被 @Persistent 修饰的类
			for (Element t : roundEnv.getElementsAnnotatedWith(Persistent.class)) {
				// 获取正在处理的类名
				Name clazzName = t.getSimpleName();

				// 获取类定义前的@Persistent Annotation
				Persistent per = t.getAnnotation(Persistent.class);

				// 创建文件输出流
				ps = new PrintStream(new FileOutputStream(new File(clazzName + ".hbm.xml")));

				ps.println("<?xml version=\"1.0\"?>");
				ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
				ps.println("	\"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
				ps.println("<hibernate-mapping>");
				ps.print("	<class name=\"" + t);
				ps.println("\" table=\"" + per.table() + "\">");
				for (Element f : t.getEnclosedElements()) {
					// 只处理成员变量上的Annotation
					if (f.getKind() == ElementKind.FIELD) {
						Id id = f.getAnnotation(Id.class);
						if (id != null) {
							ps.println("	<id name = \"" + f.getSimpleName() + "\" column = \"" + id.column()
									+ "\" type = \"" + id.type() + "\">");
							ps.println("	<generator=\"" + id.generator() + "\"></id>");
						}

						Property property = f.getAnnotation(Property.class);

						if (property != null) {
							ps.println("	<property name = \"" + f.getSimpleName() + "\" column = \""
									+ property.column() + "\" type = \"" + property.type() + "\"></id>");
						}

						ps.println("	</class>");
						ps.println("</hibernate-mapping>");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

}
