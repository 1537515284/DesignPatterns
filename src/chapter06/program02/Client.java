package chapter06.program02;

import chapter06.program02.finery.*;

/**
 * '服装'类 与 '人'类 分离
 */
public class Client {

    public static void main(String[] args) {
        Person xc = new Person("小菜");

        System.out.println("\n第一种装扮: ");
        Finery dtx = new TShirts();
        Finery kk = new BigTrouser();
        Finery pqx = new Sneakers();

        dtx.show();
        kk.show();
        pqx.show();
        xc.show();

        System.out.println("\n第二种装扮: ");
        Finery xz = new Suit();
        Finery ld = new Tie();
        Finery px = new LeatherShoes();

        xz.show();
        ld.show();
        px.show();
        xc.show();
    }
}
