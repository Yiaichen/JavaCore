package javaDemo.design.singleton;

public class Run {

    public static void main(String[] args) {

        HungerSingleton hs1 = HungerSingleton.getInstance();
        HungerSingleton hs2 = HungerSingleton.getInstance();
        System.out.println(hs1 == hs2);

        LazySingleton ls1 = LazySingleton.getInstance();
        LazySingleton ls2 = LazySingleton.getInstance();
        System.out.println(ls1 == ls2);

        EnumSingleton es1 = EnumSingleton.INSTANCE;
        EnumSingleton es2 = EnumSingleton.INSTANCE;
        System.out.println(es1 == es2);

    }

}
