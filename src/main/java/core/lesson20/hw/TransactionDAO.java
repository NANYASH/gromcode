package core.lesson20.hw;

import core.lesson20.hw.exceptions.BadRequestException;
import core.lesson20.hw.exceptions.InternalServerException;
import core.lesson20.hw.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {

        validateAll(transaction);
        int index = findFreeSpace();
        transactions[index] = transaction;
        return transactions[index];
    }

    public Transaction[] transactionList() {
        Transaction[] transactions1 = new Transaction[getNumberOfTransactions()];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                transactions1[index] = transaction;
                index++;
            }

        }
        return transactions1;
    }

    public Transaction[] transactionList(String city) {
        Transaction[] transactions1 = new Transaction[getNumberOfTransactions(city)];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                transactions1[index] = transaction;
                index++;
            }
        }
        return transactions1;
    }

    public Transaction[] transactionList(int amount) {
        Transaction[] transactions1 = new Transaction[getNumberOfTransactions(amount)];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                transactions1[index] = transaction;
                index++;
            }
        }
        return transactions1;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    public int findFreeSpace() throws InternalServerException {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                return i;
            }
        }
        throw new InternalServerException("Unexpected error.");
    }

    private int getNumberOfTransactions() {
        int counter = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
                counter++;
        }
        return counter;
    }

    private int getNumberOfTransactions(String city) {
        int counter = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city))
                counter++;
        }
        return counter;
    }

    private int getNumberOfTransactions(int amount) {
        int counter = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount)
                counter++;
        }
        return counter;
    }

    public void validateAll(Transaction transaction) throws BadRequestException, InternalServerException {
        validateTransaction(transaction);
        validateSpace(transactions, transaction);
        validateLimitTransactionsPerDayAmount(transaction);
        validateLimitTransactionsPerDayCount(transaction);
        validateLimitSimpleTransactionAmount(transaction);
        validateCity(transaction);
    }

    public void validateLimitTransactionsPerDayAmount(Transaction transaction) throws LimitExceeded {
        int totalAmount = 0;
        for (Transaction transaction1 : getTransactionsPerDay(transaction.getDateCreated())) {
            totalAmount += transaction1.getAmount();
        }
        if (totalAmount + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Amount of transactions per day exceeded. Transaction cannot be processed:" + transaction.getId());
    }

    public void validateLimitTransactionsPerDayCount(Transaction transaction) throws LimitExceeded {
        if (getTransactionsPerDay(transaction.getDateCreated()).length + 1 > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Count of transactions per day exceeded.Transaction cannot be processed:" + transaction.getId());
    }

    public void validateLimitSimpleTransactionAmount(Transaction transaction) throws LimitExceeded {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Limit of simple transaction exceeded.Transaction cannot be processed:" + transaction.getId());
    }

    public void validateCity(Transaction transaction) throws BadRequestException {
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity()))
                return;
        }
        throw new BadRequestException("Incorrect transaction city.Transaction cannot be processed:" + transaction.getId());
    }

    public void validateSpace(Transaction[] transactions, Transaction transaction) throws InternalServerException {
        for (Transaction transaction1 : transactions) {
            if (transaction1 == null)
                return;
        }
        throw new InternalServerException("Not enough place.Transaction cannot be processed:" + transaction.getId());

    }

    public void validateTransaction(Transaction transaction) throws BadRequestException {
        if (transaction == null)
            throw new BadRequestException("Null cannot be saved.Transaction cannot be processed:" + transaction.getId());
        for (Transaction transaction1 : transactions) {
            if (transaction1 != null && transaction1.equals(transaction))
                throw new BadRequestException("Such transaction already has been processed:" + transaction.getId());
        }
    }

}


