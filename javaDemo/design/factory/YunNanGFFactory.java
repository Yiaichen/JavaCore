package javaDemo.design.factory;

public class YunNanGFFactory implements IGFFactory {
    @Override
    public BaseGF createGF() {
        return new YunNanGF();
    }
}
