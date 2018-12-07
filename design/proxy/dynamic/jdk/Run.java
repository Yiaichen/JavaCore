package design.proxy.dynamic.jdk;

import design.proxy.statics.RealSubject;
import design.proxy.statics.Subject;

/**
 * 客户端调用
 */
public class Run {
    public static void main(String[] args) throws Exception {
        DynamicHandler dynamicHandler = new DynamicHandler();
        Subject subject = (Subject) dynamicHandler.createProxy(new RealSubject());
        /*
         * 其实这个时候生成的对象已经就是代理对象了
         * 不要因为调用了buySwitch就觉得是原来的对象了
         */
        subject.buySwitch();
        subject.buyPS4();
    }
}
