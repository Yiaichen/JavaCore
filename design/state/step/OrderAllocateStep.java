package design.state.step;

import design.state.domain.AuditContext;
import design.state.domain.OrderAuditStep;
import design.state.domain.State;

/**
 * 匹仓的单子处理
 *
 * @author vayi
 * @version 1.0
 * @date 2020-03-15
 */
@OrderAuditStep(state = State.ALLOCATE)
public class OrderAllocateStep extends IOrderStep {
    @Override
    public void process(AuditContext context) {

    }
}
