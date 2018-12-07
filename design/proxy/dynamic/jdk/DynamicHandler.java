package design.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * JDK动态代理
 */
public class DynamicHandler implements InvocationHandler {
    // 真实对象
    private Object targetObject;

    // 创建代理对象 这段也可以不在此类，也可以放在客户端里面
    public Object createProxy(Object targetOjbect) {
        this.targetObject = targetOjbect;
        /*
         * 创建代理对象
         * Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
         * loader：代理类的类加载器
         * interfaces：指定代理类所实现的接口
         * h：动态代理对象在调用方法的时候，关联的InvocationHandler对象
         */
        /*byte[] bts = ProxyGenerator.generateProxyClass("$Proxy0", targetOjbect.getClass().getInterfaces());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("E:/$Proxy0.class"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(bts);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return Proxy.newProxyInstance(targetOjbect.getClass().getClassLoader(),
                targetOjbect.getClass().getInterfaces(), this);
    }

    /**
     * InvocationHandler接口所定义的唯一的一个方法，该方法负责集中处理动态代理类上的所有方法的调用。
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上执行
     *
     * @param proxy  代理类的实例
     * @param method 代理类被调用的方法
     * @param args   调用方法的参数
     * @return Object
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //触发真实对象之前或者之后可以做一些额外操作
        Object result = null;
        System.out.println("method:" + method.getName() + " proxy:" + proxy.getClass().getName());
        result = method.invoke(this.targetObject, args);//通过反射执行某个类的某方法
        this.buyGameCard();
        return result;
    }

    /**
     * 顺便买一些游戏卡
     */
    private void buyGameCard() {
        System.out.println("再顺便买一些游戏卡");
    }

}
