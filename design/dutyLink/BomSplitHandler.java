package design.dutyLink;

/**
 * Bom拆分
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public class BomSplitHandler extends AuditHandler {

    public BomSplitHandler() {
        super("10");
    }

    @Override
    void process(Order order) {
        order.status = "10";
        System.out.println("[" + order.code + "]Bom拆分结束: 订单当前状态 -> " + order.status);
    }
}
