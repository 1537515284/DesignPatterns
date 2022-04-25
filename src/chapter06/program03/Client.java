package chapter06.program03;

/**
 * 装饰模式是利用 setComponent 来对对象进行包装的。
 * 这样每个装饰对象的实现就和如何使用这个对象分离开了，每个装饰对象只关心自己的功能，
 * 不需要关心如何被添加到对象链当中[DPE].
 */
public class Client {

    /**
     *  装饰的方法是：首先用 ConcreteComponent 实例化对象 c,
     *  然后用 ConcreteDecoratorA 的实例化对象 d1 来包装 c
     *  再用 ConcreteDecoratorB 的对象 d2 包装 d1
     *  最终执行 d2 的 operation()
     */
    public static void main(String[] args) {

        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
    }
}
