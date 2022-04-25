package chapter01.program03;

import chapter01.program03.operation.Operation;
import chapter01.program03.operation.OperationFactory;

/**
 * 通过简单工厂模式，减少程序的耦合性，让程序更容易扩展
 * 将业务逻辑抽出为一个运算类(封装)
 * 把加、减、乘、除等功能分离(继承)，修改其中一个不影响另外几个,增加功能也不影响其他代码
 * 使用时，通过工厂实例化需要的对象(多态)
 */
public class Program03 {
    public static void main(String[] args) {
        Operation oper;
        oper = OperationFactory.createOperate("+");
        oper.set_numberA(1);
        oper.set_numberB(2);
        double result = oper.GetResult();
        System.out.println("结果是："+result);
    }
}
