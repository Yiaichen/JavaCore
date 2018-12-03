package design.singleton;

/**
 * 单例模式 (懒汉式)
 */
public final class LazySingleton {

    /**
     * 杜绝外面直接new 只有一种获取方式
     */
    private LazySingleton() {}

    /**
     * 实例化
     */
    private static volatile LazySingleton INSTANCE;

    /**
     * 获取实例（双重检查）
     */
    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

}
