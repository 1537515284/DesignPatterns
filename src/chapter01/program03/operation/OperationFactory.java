package chapter01.program03.operation;

/**
 * 简单工厂模式，通过输入的运算符号，工厂就实例化出合适的对象，通过多态，返回父类的方式实现了计算器效果
 */
public class OperationFactory {
    public static Operation createOperate(String operate){
        Operation oper = null;
        switch (operate){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }
}
