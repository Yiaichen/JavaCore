package design.dutyLink;

/**
 * 库存分配
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public class InventoryAllocateHandler extends AuditHandler {

    public InventoryAllocateHandler() {
        super("30");
    }

    @Override
    void process(Order order) {
        order.status = "30";
        System.out.println("[" + order.code + "]库存分配结束: 订单当前状态 -> " + order.status);
    }
}
