package design.proxy.statics;

/**
 * 真实对象
 */
public class RealSubject implements Subject {

    /**
     * 我只想买一台Switch
     */
    @Override
    public void buySwitch() {
        System.out.println("我只想买一台Switch");
    }

    @Override
    public void buyPS4() {
        System.out.println("我想再买一台PS4");
    }

}
