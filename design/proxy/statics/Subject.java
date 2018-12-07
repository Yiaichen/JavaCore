package design.proxy.statics;

/**
 * 抽象对象接口
 */
public interface Subject {

    /**
     * 声明需要被代理的方法
     * 让代理对象来帮我们买一台Switch
     */
    public void buySwitch();

    /**
     * 再买一台PS4
     */
    public void buyPS4();

}