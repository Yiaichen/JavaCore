package design.decorate;

/**
 * 定义了读取和写入操作的通用数据接口
 */
public interface DataSource {

    void writeData(String data);

    String readData();

}
