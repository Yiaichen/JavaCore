package design.state;

import design.singleton.EnumSingleton;
import design.singleton.HungerSingleton;
import design.singleton.LazySingleton;
import design.state.domain.AuditContext;
import design.state.domain.OrderAuditStep;
import design.state.step.IOrderStep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 状态模式
 */
public class Run {

    static {
        Register.register();
    }

    public static void main(String[] args) {
        List<Integer> list = Stream.of(100, 200, 300, 900).collect(Collectors.toList());
        list.forEach(s -> {
            IOrderStep orderStep = IOrderStep.AUDIT_STEP.get(s);
            orderStep.audit();
        });
    }
}
