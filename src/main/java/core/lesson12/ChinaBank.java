package core.lesson12;


public class ChinaBank extends Bank {


    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        if (getCurrency().equals(Currency.EUR)) return 150;
        if (getCurrency().equals(Currency.USD)) return 100;
        return 0;
    }

    @Override
    int getLimitOfFunding() {
        if (getCurrency().equals(Currency.EUR)) return 5000;
        if (getCurrency().equals(Currency.USD)) return 10000;
        return 0;
    }

    @Override
    double getMonthlyRate() {
        if (getCurrency().equals(Currency.EUR)) return 0;
        if (getCurrency().equals(Currency.USD)) return 0.01;
        return 0;
    }

    @Override
    double getCommission(int amount) {
        if (getCurrency().equals(Currency.EUR) && amount <= 1000) return 0.1;
        if (getCurrency().equals(Currency.EUR) && amount > 1000) return 0.11;
        if (getCurrency().equals(Currency.USD) && amount <= 1000) return 0.03;
        if (getCurrency().equals(Currency.USD) && amount > 1000) return 0.05;
        return 0;
    }


}
