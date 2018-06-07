package core.lesson12;


public abstract class Bank {
    private long id;
    private String bankCountry;
    private Currency currency;
    private int numberOfEmployees;
    private double avrSalaryOfEmployee;
    private long rating;
    private long totalCapital;

    public Bank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avSalaryOfEmployee, long rating, long totalCapital) {
        this.id = id;
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.numberOfEmployees = numberOfEmployees;
        this.avrSalaryOfEmployee = avSalaryOfEmployee;
        this.rating = rating;
        this.totalCapital = totalCapital;
    }

    abstract int getLimitOfWithdrawal();

    abstract int getLimitOfFunding();

    abstract double getMonthlyRate();

    abstract double getCommission(int amount);

    double moneyPaidMonthlyForSalary() {
        return numberOfEmployees * avrSalaryOfEmployee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getAvrSalaryOfEmployee() {
        return avrSalaryOfEmployee;
    }

    public void setAvrSalaryOfEmployee(double avSalaryOfEmployee) {
        this.avrSalaryOfEmployee = avSalaryOfEmployee;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", bankCountry='" + bankCountry + '\'' +
                ", currency=" + currency +
                ", numberOfEmployees=" + numberOfEmployees +
                ", avSalaryOfEmployee=" + avrSalaryOfEmployee +
                ", rating=" + rating +
                ", totalCapital=" + totalCapital +
                '}';
    }
}
