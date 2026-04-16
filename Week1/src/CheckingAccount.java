public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(){
        super();
        interestRate = 0.3;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Overdraft fee method
    public void processWithdrawal(double amount){
        double currentBalance = getBalance();
        super.withdrawal(amount);
        System.out.println("Your balance is $" + currentBalance + " and you are withdrawing $" + amount);

        if (getBalance() < 0){
            System.out.println("You have a negative balance of $" + getBalance());
            System.out.println("There will be a fee of $30 subtracted from your balance.");
            super.withdrawal(30.00);
            System.out.println("Your new balance after fee is $" + getBalance());
        }
        if(getBalance() >= 0){
            System.out.println("Your new balance is $" + getBalance());
        }
    }

    // Display Checking account
    public void displayAccount(){
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
