package design.factory;

public class SiChuanGFFactory implements IGFFactory {
    @Override
    public BaseGF createGF() {
        return new SiChuanGF();
    }
}
