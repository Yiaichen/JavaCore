package design.state;

import design.state.domain.OrderAuditStep;
import design.state.step.IOrderStep;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 注册中心
 *
 * @author vayi
 * @version 1.0
 * @date 2020-03-15
 */
public class Register {
    static final String PACKAGE = "design.state.step";

    static void register() {
        // 反射获取注解标记类
        Enumeration<URL> urls = null;
        try {
            urls = Thread.currentThread().getContextClassLoader().getResources(PACKAGE.replace(".", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if ("file".equalsIgnoreCase(url.getProtocol())) {
                    File file = new File(url.getPath());
                    if (file.isDirectory()) {
                        File[] files = file.listFiles();
                        for (File fl : files) {
                            String className = fl.getName();
                            className = className.substring(0, className.lastIndexOf("."));
                            Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(PACKAGE + "." + className);
                            // 添加到缓存
                            OrderAuditStep annotation = clazz.getAnnotation(OrderAuditStep.class);
                            if (annotation != null) {
                                IOrderStep.AUDIT_STEP.put(annotation.state().getState(), (IOrderStep) clazz.newInstance());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
