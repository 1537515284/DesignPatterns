package chapter02.program04.cash;

/**
 * 上下文
 */
public class CashContent {
    private CashSuper cs;

    // 通过构造方法，传入具体的收费策略
    public CashContent(CashSuper cs) {
        this.cs = cs;
    }

    // 根据收费策略的不同，获得计算结果
    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
