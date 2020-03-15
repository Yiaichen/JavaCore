package design.state.domain;

/**
 * 状态
 *
 * @author vayi
 * @version 1.0
 * @date 2019/11/05
 */
public enum State {
    LOCK(100, "锁定"),
    SOURCING(200, "匹仓"),
    ALLOCATE(300, "库存分配"),
    RELEASE(900, "释放");

    private int state;
    private String name;

    public int getState() {
        return this.state;
    }

    public String getName() {
        return this.name;
    }

    State(int state, String name) {
        this.state = state;
        this.name = name;
    }
}
