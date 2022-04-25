package chapter01.program03.operation;

public class OperationDiv extends Operation{
    @Override
    public double GetResult() {
        double result = 0;
        if(get_numberB() == 0)
            try {
                throw new Exception("除数不能为0.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        result = get_numberA() / get_numberB();
        return  result;
    }
}
