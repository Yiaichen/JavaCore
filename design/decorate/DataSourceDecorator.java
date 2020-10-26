package design.decorate;

/**
 * 抽象基础装饰
 *
 * @author vayi
 * @version 1.0
 * @date 2020/10/26
 */
public class DataSourceDecorator implements DataSource {
    private DataSource wrapper;

    DataSourceDecorator(DataSource source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }
}
