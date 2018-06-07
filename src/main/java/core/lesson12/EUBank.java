package core.lesson12;


public class EUBank extends Bank {


    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        if (getCurrency().equals(Currency.EUR)) return 2200;
        if (getCurrency().equals(Currency.USD)) return 2000;
        return 0;
    }

    @Override
    int getLimitOfFunding() {
        if (getCurrency().equals(Currency.EUR)) return 20000;
        if (getCurrency().equals(Currency.USD)) return 10000;
        return 0;
    }

    @Override
    double getMonthlyRate() {
        if (getCurrency().equals(Currency.EUR)) return 0.01;
        if (getCurrency().equals(Currency.USD)) return 0;
        return 0;
    }

    @Override
    double getCommission(int amount) {
        if (getCurrency().equals(Currency.EUR) && amount <= 1000) return 0.02;
        if (getCurrency().equals(Currency.EUR) && amount > 1000) return 0.04;
        if (getCurrency().equals(Currency.USD) && amount <= 1000) return 0.05;
        if (getCurrency().equals(Currency.USD) && amount > 1000) return 0.07;
        return 0;
    }


}
