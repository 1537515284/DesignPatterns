package chapter02.program04;

import chapter02.program04.strategy.ConcreteStrategyA;
import chapter02.program04.strategy.ConcreteStrategyB;
import chapter02.program04.strategy.ConcreteStrategyC;
import chapter02.program04.strategy.Context;

/**
 * 策略模式 (Strategy)
 * 策略模式：它定义了算法家族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化,
 * 不会影响到使用算法的客户。
 */
public class StrategyDemo {
    public static void main(String[] args) {
        // 用于实例化不同的策略，所以最终在调用context.ContextInterface()时，所获得的结果就不尽相同
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.ContextInterface();

        context = new Context(new ConcreteStrategyB());
        context.ContextInterface();

        context = new Context(new ConcreteStrategyC());
        context.ContextInterface();
    }
}
