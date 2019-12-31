package design.dutyLink;

/**
 * 审单责任链中心
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public abstract class AuditHandler {

    // 下一个处理者
    AuditHandler nextHandler;

    // 状态
    String status;

    public AuditHandler(String status) {
        this.status = status;
    }

    void setNextHandler(AuditHandler handler) {
        this.nextHandler = handler;
    }

    void handlerMessage(Order order) {
        if (status.equalsIgnoreCase(order.status)) {
            this.process(order);
        } else {
            if (nextHandler != null) {
                nextHandler.handlerMessage(order);
            } else {
                System.out.println("[" + order.code + "]审单结束: 订单当前状态 -> " + order.status);
            }
        }
    }

    /**
     * 子类实现
     */
    abstract void process(Order order);

}
