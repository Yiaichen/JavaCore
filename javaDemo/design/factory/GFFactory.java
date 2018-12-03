package javaDemo.design.factory;

public class GFFactory {
    public static BaseGF createGF(GFType gFType) {
        switch (gFType) {
            case SI_CHUAN:
                return new SiChuanGF();
            case SHAN_DONG:
                return new ShanDongGF();
            default:
            case HE_BEI:
                return new HeBeiGF();
        }
    }
}
