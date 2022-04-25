package chapter01.program01;

import java.util.Objects;
import java.util.Scanner;

/**
 * 请用C++,java,c#或vb.net任意一种面向对象语言设计一个计算器控制程序，
 * 要求输入两个数和运算符号,得到结果
 */
public class Program01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字A:");
        String strNumberA = scanner.next();
        System.out.print("请选择运算符号(+、-、*、/):");
        String operator = scanner.next();
        System.out.print("请输入数字B:");
        String strNumberB = scanner.next();

        String strResult = "";
        try {
            switch (operator) {
                case "+":
                    strResult = Double.parseDouble(strNumberA) + Double.parseDouble(strNumberB) + "";
                    break;
                case "-":
                    strResult = Double.parseDouble(strNumberA) - Double.parseDouble(strNumberB) + "";
                    break;
                case "*":
                    strResult = Double.parseDouble(strNumberA) * Double.parseDouble(strNumberB) + "";
                    break;
                case "/":
                    if (!Objects.equals(strNumberB, "0"))
                        strResult = Double.parseDouble(strNumberA) / Double.parseDouble(strNumberB) + "";
                    else
                        strResult = "除数不能为0";
                    break;
                default:
                    throw new Exception("符号输入有误");
            }
            System.out.println("结果是：" + strResult);
        } catch (Exception ex){
            System.out.println("您的输入有错:"+ex.getMessage());
        }
    }
}
