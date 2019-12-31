package design.dutyLink;

/**
 * 锁单
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public class LockOrderHandler extends AuditHandler {

    public LockOrderHandler() {
        super("0");
    }

    @Override
    void process(Order order) {
        order.status = "0";
        System.out.println("[" + order.code + "]锁单结束: 订单当前状态 -> " + order.status);
    }
}
