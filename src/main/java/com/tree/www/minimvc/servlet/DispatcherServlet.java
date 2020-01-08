package com.tree.www.minimvc.servlet;

import com.tree.www.minimvc.annotation.*;
import com.tree.www.minimvc.controller.UserController;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pysh on 2018/10/24.
 */
@WebServlet(name = "dispatcherServlet", urlPatterns = "/*", loadOnStartup = 1,
        initParams = {@WebInitParam(name = "base-package", value = "com.tree.www.minimvc")})
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 4407644518865042258L;
    // 包下面所有的带包路径权限定类名
    private List<String> packageNames = new ArrayList<>();
    // 注解实例化
    private Map<String, Object> instanceMap = new HashMap<>();
    // 注解上的名称
    private Map<String, String> nameMap = new HashMap<>();
    // url地址与方法的映射关系
    private Map<String, Method> urlMethodMap = new HashMap<>();
    // 方法与类名映射 通过method找到该方法的对象利用反射执行
    private Map<Method, String> methodPackageMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) {
        String basePackage = config.getInitParameter("base-package");

        try {
            scanBasePackage(basePackage);
            instance(packageNames);
            springIOC();
            handlerUrlMethodMap();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = uri.replaceAll(contextPath, "");

        Method method = urlMethodMap.get(path);
        if (method != null) {
            String packageName = methodPackageMap.get(method);
            String controllerName = nameMap.get(packageName);
            UserController userController = (UserController) instanceMap.get(controllerName);
            try {
                method.setAccessible(true);
                method.invoke(userController);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void handlerUrlMethodMap() throws ClassNotFoundException {
        if (packageNames.size() == 0) {
            return;
        }
        for (String packageName : packageNames) {
            Class c = Class.forName(packageName);
            if (c.isAnnotationPresent(Controller.class)) {
                Method[] methods = c.getMethods();

                StringBuilder baseUrl = new StringBuilder();
                if (c.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = (RequestMapping) c.getAnnotation(RequestMapping.class);
                    baseUrl.append(requestMapping.value());
                }
                for (Method method : methods) {
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        RequestMapping requestMapping = (RequestMapping) c.getAnnotation(RequestMapping.class);
                        baseUrl.append(requestMapping.value());

                        urlMethodMap.put(baseUrl.toString(), method);
                        methodPackageMap.put(method, packageName);
                    }
                }
            }
        }
    }

    private void springIOC() throws IllegalAccessException {
        for (Map.Entry<String, Object> entry : instanceMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Qualifier.class)) {
                    String name = field.getAnnotation(Qualifier.class).value();
                    field.setAccessible(true);
                    field.set(entry.getValue(), instanceMap.get(name));
                }
            }
        }
    }

    private void instance(List<String> packageNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (packageNames.size() == 0) {
            return;
        }
        for (String packageName : packageNames) {
            Class c = Class.forName(packageName);

            if (c.isAnnotationPresent(Controller.class)) {
                Controller controller = (Controller) c.getAnnotation(Controller.class);
                String controllerName = controller.value();

                instanceMap.put(controllerName, c.newInstance());
                nameMap.put(packageName, controllerName);
                System.out.println("Controller:" + packageName + ", value: " + controller.value());
            } else if (c.isAnnotationPresent(Service.class)) {
                Service service = (Service) c.getAnnotation(Service.class);
                String serviceName = service.value();

                instanceMap.put(serviceName, c.newInstance());
                nameMap.put(packageName, serviceName);
                System.out.println("Service:" + packageName + ", value: " + service.value());

            } else if (c.isAnnotationPresent(Repository.class)) {
                Repository repository = (Repository) c.getAnnotation(Repository.class);
                String repositoryName = repository.value();

                instanceMap.put(repositoryName, c.newInstance());
                nameMap.put(packageName, repositoryName);
                System.out.println("Repository:" + packageName + ", value: " + repository.value());

            }
        }
    }

    private void scanBasePackage(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource(basePackage.replaceAll("\\.", "/"));
        assert url != null;
        File basePackageFile = new File(url.getPath());
        System.out.println("scan:" + basePackage);
        File[] childFiles = basePackageFile.listFiles();
        assert childFiles != null;
        for (File file : childFiles) {
            if (file.isDirectory()) {
                scanBasePackage(basePackage + "." + file.getName());
            } else if (file.isFile()) {
                // 去掉.class
                packageNames.add(basePackage + "." + file.getName().split(".")[0]);
            }
        }
    }
}
