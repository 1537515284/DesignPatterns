package chapter07.program01;

public class Client {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("李娇娇");

        Pursuit zhuojiayi = new Pursuit(jiaojiao);

        zhuojiayi.giveDolls();
        zhuojiayi.giveFlowers();
        zhuojiayi.giveChocolate();
    }
}
