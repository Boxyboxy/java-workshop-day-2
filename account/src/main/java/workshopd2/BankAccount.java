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
    private final String name;
    private final String accountNumber;
    private float balance;
    private ArrayList<String> transactions = new ArrayList<String>();
    private boolean accountActive = true;
    private String openingDate;
    private String closingDate = null;

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
        try {
            // update balance, print balance for user experience
            // add transaction to transaction array
            this.balance += depositAmount;
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println("Deposited $" + depositAmount + " at " + timeStamp);
            this.printBalance();
            this.transactions.add("Deposited $" + depositAmount + " at " + timeStamp);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Deposit function only accepts positive amounts.");
        } finally {
            System.out.println("Deposited function completed, please try again if an error message was printed.");
        }
    }

    // withdraw
    public void withdraw(float withdrawAmount) {
        try {
            // update balance, print balance for user experience
            // add transaction to transaction array
            if (this.balance < withdrawAmount) {
                return;
            } else if (this.balance > withdrawAmount) {
                this.balance -= withdrawAmount;

                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                System.out.println("Withdrawed $" + withdrawAmount + " at " + timeStamp);
                this.printBalance();
                this.transactions.add("Withdrawed $" + withdrawAmount + " at " + timeStamp);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error! Withdraw function only accepts positive amounts.");
        } finally {
            System.out.println("withdraw function completed, please try again if an error message was printed.");
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
        salary.deposit(100.00F);

        System.out.println(salary.transactions);
        salary.withdraw(10.5F);
        System.out.println(salary.getTransactions());

        salary.closeAccount();
        System.out.println(salary.getTransactions());
        System.out.println(salary.closingDate);

    }
}
