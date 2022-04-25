package chapter06.program01;

public class Client {
    public static void main(String[] args) {
        Person xc = new Person("小菜");

        System.out.println("\n第一种装扮: ");

        xc.wearTShirts();
        xc.wearBigTrouser();
        xc.wearSneakers();
        xc.show();

        System.out.println("\n第二种装扮: ");

        xc.wearSuit();
        xc.wearTie();
        xc.wearLeatherShoes();
        xc.show();
    }
}
