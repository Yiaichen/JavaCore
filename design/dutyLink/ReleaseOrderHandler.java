package design.dutyLink;

/**
 * 订单释放
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public class ReleaseOrderHandler extends AuditHandler {

    public ReleaseOrderHandler() {
        super("90");
    }

    @Override
    void process(Order order) {
        order.status = "90";
        System.out.println("[" + order.code + "]订单释放结束: 订单当前状态 -> " + order.status);
    }
}
