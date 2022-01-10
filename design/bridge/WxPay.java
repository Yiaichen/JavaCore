package design.bridge;

import java.math.BigDecimal;

public class WxPay extends Pay {

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        System.out.println("模拟微信渠道支付划账开始。uId：" + uId + " tradeId：" + tradeId + " amount：" + amount);
        boolean security = payMode.security(uId);
        System.out.println("模拟微信渠道支付风控校验。uId：" + uId + " tradeId：" + tradeId + " security：" + security);
        if (!security) {
            System.out.println("模拟微信渠道支付划账拦截。uId：" + uId + " tradeId：" + tradeId + " amount：" + amount);
            return "0001";
        }
        System.out.println("模拟微信渠道支付划账成功。uId：" + uId + " tradeId：" + tradeId + " amount：" + amount);
        return "0000";
    }

}
