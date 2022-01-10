package design.bridge;

import java.math.BigDecimal;

public class ZfbPay extends Pay {

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        System.out.println("模拟支付宝渠道支付划账开始。uId：" + uId + " tradeId：" + tradeId + " amount：" + amount);
        boolean security = payMode.security(uId);
        System.out.println("模拟支付宝渠道支付风控校验。uId：" + uId + " tradeId：" + tradeId + " security：" + security);
        if (!security) {
            System.out.println("模拟支付宝渠道支付划账拦截。uId：" + uId + " tradeId：" + tradeId + " amount：" + amount);
            return "0001";
        }
        System.out.println("模拟支付宝渠道支付划账成功。uId：" + uId + " tradeId：" + tradeId + " amount：" + amount);
        return "0000";
    }

}
