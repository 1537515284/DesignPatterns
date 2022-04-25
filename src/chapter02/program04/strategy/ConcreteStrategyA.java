package chapter02.program04.strategy;

/**
 * 具体算法A
 */
public class ConcreteStrategyA extends Strategy{
    @Override
    public void AlgorithmInterface() {
        System.out.println("算法 A 实现");
    }
}
