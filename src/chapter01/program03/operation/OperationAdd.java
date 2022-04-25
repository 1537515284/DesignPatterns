package chapter01.program03.operation;

public class OperationAdd extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        result = get_numberA() + get_numberB();
        return result;
    }
}
