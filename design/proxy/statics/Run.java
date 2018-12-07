package design.proxy.statics;

/**
 * 客户端调用
 */
public class Run {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.buySwitch();
        proxy.buyPS4();
    }
}
