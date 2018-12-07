package design.proxy.dynamic.aop;

import design.proxy.statics.RealSubject;
import design.proxy.statics.Subject;

/**
 * 客户端调用
 */
public class Run {
    public static void main(String[] args) throws Exception {
        DynamicHandler dynamicHandler = new DynamicHandler();
        Subject subject = (Subject) dynamicHandler.createProxy(new RealSubject());
        dynamicHandler.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("听说任天堂出了一款不错的游戏，所以。。。");
            }
        });
        dynamicHandler.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("再买点游戏卡");
            }
        });
        subject.buySwitch();
    }
}
