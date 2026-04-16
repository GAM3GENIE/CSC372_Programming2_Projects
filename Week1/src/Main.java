public class Main {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        System.out.println("Bank Account 1");
        account1.setFirstName("David");
        account1.setLastName("Bernardino");
        account1.setAccountID(31182);
        account1.deposit(5000.00);
        account1.withdrawal(1000.00);
        account1.accountSummary();

        BankAccount account2 = new BankAccount();
        System.out.println("\nBank Account 2");
        account2.setFirstName("David");
        account2.setLastName("Bernardino");
        account2.setAccountID(31182);
        account2.deposit(3000.00);
        account2.withdrawal(2000.00);
        account2.accountSummary();

        CheckingAccount account3 = new CheckingAccount();
        System.out.println("\nChecking Account 3");
        account3.setFirstName("David");
        account3.setLastName("Bernardino");
        account3.setAccountID(31182);
        account3.deposit(400.00);
        account3.processWithdrawal(550.00);
        account3.displayAccount();

        CheckingAccount account4 = new CheckingAccount();
        System.out.println("\nChecking Account 4");
        account4.setFirstName("David");
        account4.setLastName("Bernardino");
        account4.setAccountID(31182);
        account4.deposit(2000.00);
        account4.processWithdrawal(750.00);
        account4.displayAccount();
    }
}
