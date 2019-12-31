package design.dutyLink;

/**
 * 订单类
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public class Order {
    String code;
    String name;
    String status;
    String qty;
    String price;

    public Order(String code, String name, String status, String qty, String price) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.qty = qty;
        this.price = price;
    }
}
