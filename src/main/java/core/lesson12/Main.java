package core.lesson12;


public class Main {
    public static void main(String[] args) {

        Bank bank1 = new EUBank(1, "Test1", Currency.EUR, 5, 500, 1, 10000000);
        Bank bank2 = new EUBank(2, "Test1", Currency.EUR, 5, 500, 1, 10000000);
        Bank bank3 = new USBank(3, "Test1", Currency.USD, 5, 700, 2, 20000000);
        Bank bank4 = new USBank(4, "Test1", Currency.USD, 5, 700, 2, 20000000);
        Bank bank5 = new ChinaBank(5, "Test1", Currency.USD, 5, 800, 3, 30000000);
        Bank bank6 = new ChinaBank(6, "Test1", Currency.USD, 5, 800, 3, 30000000);

        User user1 = new User(11, "Anna", 1000, 5, "Test1", 1500, bank1);
        User user2 = new User(22, "Ella", 2000, 10, "Test1", 1300, bank2);
        User user3 = new User(33, "Katya", 3000, 15, "Test1", 2000, bank3);
        User user4 = new User(44, "Roma", 4000, 20, "Test1", 1600, bank4);
        User user5 = new User(55, "Vova", 5000, 25, "Test1", 900, bank5);
        User user6 = new User(66, "Lina", 6000, 30, "Test1", 750, bank6);

        BankSystem bankSystem = new UkrainianBankSystem();

        bankSystem.withdraw(user1, 500);
        System.out.println(user1.toString());

        bankSystem.fund(user2, 900);
        System.out.println(user2.toString());

        bankSystem.paySalary(user3);
        System.out.println(user3.toString());

        bankSystem.transferMoney(user4, user5, 300);
        System.out.println(user4.toString());
        System.out.println(user5.toString());

    }

}
