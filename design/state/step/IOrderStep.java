package design.state.step;

import design.state.domain.AuditContext;
import design.state.domain.OrderAuditStep;

import java.util.HashMap;
import java.util.Map;

public abstract class IOrderStep {
    public static Map<Integer, IOrderStep> AUDIT_STEP = new HashMap<>();

    /**
     * 审单上下文
     */
    public AuditContext context = new AuditContext();

    public void audit() {
        processBegin(this.context);
        this.process(this.context);
        processAfter(this.context);
    }

    protected void processBegin(AuditContext context) {
        context.state = this.getClass().getAnnotation(OrderAuditStep.class).state();
        System.out.println("当前审单节点【" + context.state.getName() + "】 状态为【" + context.state.getState() + "】");
    }

    protected void processAfter(AuditContext context) {
        System.out.println("当前审单节点【" + context.state.getName() + "】 完成");
    }

    abstract void process(AuditContext context);

}
