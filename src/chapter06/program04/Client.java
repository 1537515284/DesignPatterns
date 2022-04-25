package chapter06.program04;

import chapter06.program04.finery.*;

/**
 *  装饰模式是为已有功能动态地添加更多功能的一种方式。
 *  在起初的设计中，当系统需要新功能的时候，是向旧的类中添加新的代码。
 *  这些新加的代码通常装饰了原有类的核心职责或主要行为，比如用西服或嘻哈服来装饰小菜，
 *  但这种做法的问题在于，它们在主类中加入了新的字段，新的方法和新的逻辑，从而增加了主类的复杂度，就像起初的 '人'类
 *  而这些新加入的东西仅仅是为了满足一些只在某种特定情况下才会执行的特殊行为的需要。
 *  -----------------------------------------------------------------------------------------
 *  '装饰者模式'就提供了一个非常好的解决方案，它把每个要装饰的功能放在单独的类中，并让这个类包装它所需要装饰的对象，
 *  因此，当需要执行特殊行为时，客户代码就可以在运行时根据需要有选择地、按顺序地使用装饰功能包装对象了[DP]。
 *  -----------------------------------------------------------------------------------------
 *  优点：把类中的装饰功能从类中搬移去除，可以有效简化原有的类。
 *  有效地把类的核心职责和装饰功能区分开了。而且可以去除相关类中重复的装饰逻辑。
 *  -----------------------------------------------------------------------------------------
 *  需要注意装饰的顺序，比如加密数据和过滤敏感词
 */
public class Client {

    public static void main(String[] args) {
        Person xc = new Person("小菜");

        System.out.println("\n第一种装扮: ");

        Sneakers pqx = new Sneakers();
        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();

        // 装饰过程
        pqx.decorate(xc);
        kk.decorate(pqx);
        dtx.decorate(kk);
        dtx.show();

        System.out.println("\n第二种装扮: ");

        LeatherShoes px = new LeatherShoes();
        Tie ld = new Tie();
        Suit xz = new Suit();

        // 装饰过程
        px.decorate(xc);
        ld.decorate(px);
        xz.decorate(ld);
        xz.show();

        System.out.println("\n第三种装扮: ");

        Sneakers pqx2 = new Sneakers();
        LeatherShoes px2 = new LeatherShoes();
        BigTrouser kk2 = new BigTrouser();
        Tie ld2 = new Tie();
        // 装饰过程
        pqx2.decorate(xc);
        px2.decorate(pqx2);
        kk2.decorate(px2);
        ld2.decorate(kk2);

        ld2.show();
    }
}
