package design.dutyLink;

/**
 * 运行类
 *
 * @author vayi
 * @version 1.0
 * @date
 */
public class Run {

    public static void main(String[] args) {
        Order order = new Order("LT-00001", "辣条", "30", "1", "1.2");
        AuditHandler lock = new LockOrderHandler();
        AuditHandler bomSplitHandler = new BomSplitHandler();
        lock.setNextHandler(bomSplitHandler);
        lock.handlerMessage(order);
    }

}
