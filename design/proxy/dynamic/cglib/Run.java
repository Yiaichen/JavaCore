package design.proxy.dynamic.cglib;

import design.proxy.statics.RealSubject;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * 客户端调用
 */
public class Run {
    public static void main(String[] args) throws Exception {
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\class");
        DynamicHandler handler = new DynamicHandler();
        RealSubject subject = (RealSubject) handler.getInstance(new RealSubject());
        subject.buySwitch();
        subject.buyPS4();
    }
}
