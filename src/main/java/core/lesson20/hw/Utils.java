package core.lesson20.hw;


public class Utils {
    private int limitTransactionsPerDayCount = 6;
    private int limitTransactionsPerDayAmount = 10000;
    private int limitSimpleTransactionAmount = 2000;
    private String[] cities = new String[]{"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
