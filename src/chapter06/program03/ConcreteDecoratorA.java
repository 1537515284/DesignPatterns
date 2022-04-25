package chapter06.program03;

/**
 * 具体的装饰对象，起到给Component添加职责的功能
 */
public class ConcreteDecoratorA extends Decorator{

    /**
     * 本类独有的属性
     */
    private String addedState;

    /**
     * 首先运行原 Component 的 operation(),再执行本类的功能，
     * 如 addedState，相当于对原 Component 进行了装饰
     */
    @Override
    public void operation() {
        super.operation();
        addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }

    public String getAddedState() {
        return addedState;
    }
}
