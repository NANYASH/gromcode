package core.lesson12;


public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        double totalAmount = amount + amount * user.getBank().getCommission(amount);

        if (user.getBank().getLimitOfWithdrawal() >= totalAmount && user.getBalance() >= totalAmount)
            user.setBalance(user.getBalance() - totalAmount);
        return;
    }

    @Override
    public void fund(User user, int amount) {
        if (user.getBank().getLimitOfFunding() > amount)
            user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        double totalAmount = amount + amount * fromUser.getBank().getCommission(amount);

        if (fromUser.getBank().getCurrency() == toUser.getBank().getCurrency() && fromUser.getBalance() >= totalAmount && fromUser.getBank/**/().getLimitOfWithdrawal() >= totalAmount) {
            if (toUser.getBank().getLimitOfFunding() >= amount) {
                fromUser.setBalance(fromUser.getBalance() - totalAmount);
                toUser.setBalance(toUser.getBalance() + amount);
            }
        }

    }

    @Override
    public void paySalary(User user) {
        if (user.getBank().getLimitOfFunding() >= user.getSalary()) {
            user.setBalance(user.getBalance() + user.getSalary());
        }

    }
}


