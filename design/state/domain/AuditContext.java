package design.state.domain;

import design.state.domain.State;

import java.util.ArrayList;
import java.util.List;

/**
 * 审单上下文
 *
 * @author vayi
 * @version 1.0
 * @date 2020-03-15
 */
public class AuditContext {
    public List<Integer> orders = new ArrayList<>();
    public State state = null;
}
