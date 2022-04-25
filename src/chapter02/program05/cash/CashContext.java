package chapter02.program05.cash;

public class CashContext {
    private CashSuper cs;

    // 通过构造方法，传入收费类型，根据收费类型，实例化不同的策略
    public CashContext(String type) {
        switch (type){
            case "正常收费":
                CashNormal cs0 = new CashNormal();
                cs = cs0;
                break;
            case "满300返100":
                CashRetrun cr1 = new CashRetrun(300,100);
                cs = cr1;
                break;
            case "打8折":
                CashRebate cr2 = new CashRebate(0.8);
                cs = cr2;
                break;
        }
    }

    // 根据收费策略的不同，获得计算结果
    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
