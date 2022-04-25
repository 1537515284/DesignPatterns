package chapter02.program05.cash;

public class CashRetrun extends CashSuper {

    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    public CashRetrun(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money >= moneyCondition)
            result = money - Math.floor(money/moneyCondition)*moneyReturn;
        return  result;
    }
}
