package Ch5;

public class RuleBuilder {

    private Condition condition;
    private Action action;

    private RuleBuilder(Condition condition) {
        this.condition = condition;
    }

    public RuleBuilder when(Condition condition) {
        return new RuleBuilder(condition);
    }

    public Rule then(Action action) {
        return new DefaultRule(condition, action);
    }
}
