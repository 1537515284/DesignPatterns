package chapter06.program03;

/**
 * 具体的装饰对象，起到给Component添加职责的功能
 */
public class ConcreteDecoratorB extends Decorator{

    /**
     * 首先运行原 Component 的 operation(),再执行本类的功能，
     * 如 addedBehavior()，相当于对原 Component 进行了装饰
     */
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    /**
     * 本类独有的方法
     */
    private void addedBehavior(){

    }
}
