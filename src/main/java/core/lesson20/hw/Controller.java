package core.lesson20.hw;


import core.lesson20.hw.exceptions.BadRequestException;
import core.lesson20.hw.exceptions.InternalServerException;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList() {
        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) {
        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) {
        return transactionDAO.transactionList(amount);
    }


}
