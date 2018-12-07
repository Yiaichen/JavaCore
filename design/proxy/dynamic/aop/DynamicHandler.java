package design.proxy.dynamic.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class DynamicHandler implements InvocationHandler {
    // 真实对象
    private Object targetObject;
    //前值增强
    private BeforeAdvice beforeAdvice;
    //后置增强
    private AfterAdvice afterAdvice;

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

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
        if (beforeAdvice != null) {
            beforeAdvice.before();
        }
        result = method.invoke(this.targetObject, args);//通过反射执行某个类的某方法
        if (afterAdvice != null) {
            afterAdvice.after();
        }
        return result;
    }

}
