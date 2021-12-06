package workshopd2;

import java.util.Random;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class BankAccount {
    // All members are private
    protected final String name;
    protected final String accountNumber;
    protected float balance;
    protected ArrayList<String> transactions = new ArrayList<String>();
    protected boolean accountActive = true;
    protected String openingDate;
    protected String closingDate = null;

    // constructors
    public BankAccount(String name) {
        this.name = name;
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
        this.openingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        // this.transactions;

    }

    public BankAccount(String name, float initDeposit) {
        this.name = name;
        this.accountNumber = generateAccountNumber();
        this.balance = initDeposit;
        this.openingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public String getAccNum() {
        return this.accountNumber;
    }

    public float getBalance() {
        return this.balance;
    }

    public ArrayList getTransactions() {
        return this.transactions;
    }

    public boolean getAccountActive() {
        return this.accountActive;
    }

    // setter method to close account
    public boolean closeAccount() {
        this.accountActive = false;
        this.closingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        this.transactions.add("Closure of account on " + this.closingDate);
        return this.accountActive;
    }

    public String getOpeningDate() {
        return this.openingDate;
    }

    public String getClosingDate() {
        return this.closingDate;
    }

    // deposit
    public void deposit(float depositAmount) {
        // update balance, print balance for user experience
        // add transaction to transaction array
        if (depositAmount < 0) {
            throw new IllegalArgumentException("Withdraw amount exceeds available balance.");
        } else {
            this.balance += depositAmount;
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println("Deposited $" + depositAmount + " at " + timeStamp);
            this.printBalance();
            this.transactions.add("Deposited $" + depositAmount + " at " + timeStamp);
        }
    }

    // withdraw
    public void withdraw(float withdrawAmount) {

        // update balance, print balance for user experience
        // add transaction to transaction array
        if (this.balance < withdrawAmount || withdrawAmount < 0) {
            throw new IllegalArgumentException("Withdraw amount exceeds available balance.");
        } else if (this.balance > withdrawAmount) {
            this.balance -= withdrawAmount;
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println("Withdrawed $" + withdrawAmount + " at " + timeStamp);
            this.printBalance();
            this.transactions.add("Withdrawed $" + withdrawAmount + " at " + timeStamp);
        }
    }

    // print balance helper function to be used in deposit and withdraw function
    public void printBalance() {
        System.out.println("Your current balance: " + this.balance);
    }

    // generate account number helper function to be used in constructors
    public String generateAccountNumber() {
        String num = "";
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            num += rand.nextInt(9);
        }
        return num;
    }

    public static void main(String[] args) {
        BankAccount salary = new BankAccount("Monty Python");
        System.out.printf("Account belongs to: %20s \n", salary.name);
        System.out.printf("Account number: %20s \n", salary.accountNumber);
        System.out.printf("Account balance: %20f \n", salary.balance);
        salary.deposit(-100.00F);

        System.out.println(salary.transactions);
        salary.withdraw(10.5F);
        System.out.println(salary.getTransactions());

        salary.closeAccount();
        System.out.println(salary.getTransactions());
        System.out.println(salary.closingDate);

    }
}
