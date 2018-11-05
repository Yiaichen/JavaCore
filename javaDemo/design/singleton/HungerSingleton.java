package javaDemo.design.singleton;

/**
 * 单例模式 (饿汉式)
 */
public final class HungerSingleton {

    /**
     * 杜绝外面直接new 只有一种获取方式
     */
    private HungerSingleton() {}

    /**
     * 实例化
     */
    private static final HungerSingleton INSTANCE = new HungerSingleton();

    /**
     * 获取实例
     */
    public static HungerSingleton getInstance() {
        return INSTANCE;
    }

}
