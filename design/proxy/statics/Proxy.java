package design.proxy.statics;

/**
 * 代理对象（代购）
 */
public class Proxy implements Subject {

    @Override
    public void buySwitch() {
        //引用并创建真实对象实例
        RealSubject realSubject = new RealSubject();

        //调用真实对象的方法，进行代理购买Switch
        realSubject.buySwitch();

        //代购进行一些额外的操作
        this.buyGameCard();
    }

    @Override
    public void buyPS4() {
        //引用并创建真实对象实例
        RealSubject realSubject = new RealSubject();

        //调用真实对象的方法，进行代理购买PS4
        realSubject.buyPS4();

        //代购进行一些额外的操作
        this.buyGameCard();
    }

    /**
     * 顺便买一些游戏卡
     */
    private void buyGameCard() {
        System.out.println("再顺便买一些游戏卡");
    }

}
