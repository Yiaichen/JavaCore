package JavaCore.design.factory;

public class Run {
    public static void main(String[] args) {
        // 简单工厂
        BaseGF siChuanGirl = GFFactory.createGF(GFType.SI_CHUAN);
        siChuanGirl.eatFood();
        siChuanGirl.shopping();

        // 工厂方法
        IGFFactory ig = new YunNanGFFactory();
        BaseGF yun = ig.createGF();
        yun.eatFood();
        yun.shopping();

        IGFFactory ig2 = new SiChuanGFFactory();
        BaseGF si = ig2.createGF();
        si.eatFood();
        si.shopping();


    }
}
