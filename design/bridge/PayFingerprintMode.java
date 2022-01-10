package design.bridge;

public class PayFingerprintMode implements IPayMode{

    public boolean security(String uId) {
        System.out.println("指纹支付，风控校验指纹信息");
        return true;
    }

}
