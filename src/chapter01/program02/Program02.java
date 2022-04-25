package chapter01.program02;

import java.util.Scanner;

/**
 * 封装业务，将业务逻辑与界面逻辑分离开来，降低程序的耦合度
 */
public class Program02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字A:");
        String strNumberA = scanner.next();
        System.out.print("请选择运算符号(+、-、*、/):");
        String operator = scanner.next();
        System.out.print("请输入数字B:");
        String strNumberB = scanner.next();

        try {
            String strResult = "";
            strResult = Operation.GetResult(Double.parseDouble(strNumberA), Double.parseDouble(strNumberB), operator) + "";
            System.out.println("结果是：" + strResult);
        } catch (Exception ex){
            System.out.println("您输入的有错："+ex.getMessage());
        }
    }
}
