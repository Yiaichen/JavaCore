package javaDemo.design.factory;

/**
 * 女朋友抽象类
 * 有两个功能  吃饭、购物
 * 不同的女朋友口味可能不同 但是都喜欢购物
 */
public abstract class BaseGF {
    public abstract void eatFood();
    public void shopping() {
        System.out.println("Go shopping every day...");
    };
}
