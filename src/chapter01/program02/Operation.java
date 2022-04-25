package chapter01.program02;

/**
 * 运算类
 */
public class Operation {
    /**
     * 接收两个double类型参数，根据operate运算符进行运算并返回结果
     */
    public static double GetResult(double numberA,double numberB,String operate) throws Exception {
        double result = 0d;
        switch (operate){
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "*":
                result = numberA * numberB;
                break;
            case "/":
                if(numberB == 0)
                    throw new Exception("除数不能为0");
                result = numberA / numberB;
                break;
            default:
                throw new Exception("符号有误!");
        }
        return result;
    }
}
