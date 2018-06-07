package core.lesson20.hw;


import core.lesson20.hw.exceptions.BadRequestException;
import core.lesson20.hw.exceptions.InternalServerException;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws InternalServerException, BadRequestException {
        Controller controller = new Controller();
        Transaction transaction = null;
        controller.save(new Transaction(1, "Kiev", 100, "Test", TransactionType.INCOME, new Date()));
        controller.save(new Transaction(2, "Lvov", 100, "Test", TransactionType.INCOME, new Date()));
        controller.save(new Transaction(3, "Kiev", 100, "Test", TransactionType.INCOME, new Date()));
        controller.save(new Transaction(4, "Kiev", 100, "Test", TransactionType.INCOME, new Date()));
        //controller.save(transaction);
        //controller.save(new Transaction(5,"Kiev",100,"Test",TransactionType.INCOME,new Date()));
        //controller.save(new Transaction(6,"Kiev",100,"Test",TransactionType.INCOME,new Date()));
        //controller.save(new Transaction(7,"Kiev",100,"Test",TransactionType.INCOME,new Date()));
        //controller.save(new Transaction(8,"Kiev",100,"Test",TransactionType.INCOME,new Date()));
        //controller.save(new Transaction(9,"Kiev",100,"Test",TransactionType.INCOME,new Date()));
        //controller.save(new Transaction(10,"Kiev",10,"Test",TransactionType.INCOME,new Date()));
        //controller.save(new Transaction(11,"Kiev",100,"Test",TransactionType.INCOME,new Date()));


    }
}
