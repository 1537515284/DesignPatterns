package chapter02.program05.cash;

/**
 * 现金收费工厂类
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type){
        CashSuper cs = null;
        switch (type){
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                CashRetrun cr1 = new CashRetrun(300,100);
                cs = cr1;
                break;
            case "打8折":
                CashRebate cr2 = new CashRebate(0.8);
                break;
        }
        return cs;
    }
}
