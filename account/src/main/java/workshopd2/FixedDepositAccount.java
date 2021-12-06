package workshopd2;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class FixedDepositAccount {
  private String name;
  private String accountNumber;
  private float balance;
  private ArrayList<String> transactions = new ArrayList<String>();
  private boolean accountActive = true;
  private String openingDate;
  private String closingDate = null;

  // not sure if using final is the right way to go
  // private final float interest;
  // private final int duration;

  private float interest;
  private int duration;
  // possibly another method to prevent setting interest/duration more than once
  private boolean changedInterest = false;
  private boolean changedDuration = false;

  public FixedDepositAccount(String name, float initDeposit) {
    this.name = name;
    this.accountNumber = generateAccountNumber();
    this.balance = initDeposit;
    this.interest = 3F;
    this.duration = 6;
    this.openingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }

  public FixedDepositAccount(String name, float initDeposit, float interest) {
    this.name = name;
    this.accountNumber = generateAccountNumber();
    this.balance = initDeposit;
    this.interest = interest;
    this.duration = 6;
    this.openingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }

  public FixedDepositAccount(String name, float initDeposit, float interest, int duration) {
    this.name = name;
    this.accountNumber = generateAccountNumber();
    this.balance = initDeposit;
    this.interest = interest;
    this.duration = duration;
    this.openingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  }

  public String getName() {
    return this.name;
  }

  public String getAccNum() {
    return this.accountNumber;
  }

  public float getBalance() {
    System.out.println("Account balance: " + (this.balance + this.interest));
    return this.balance + this.interest;
  }

  public void printBalance() {
    System.out.println("Your balance: " + this.balance);
  }

  public void setInterest(float newInterest) {
    try {
      if (!this.changedInterest) {
        this.changedInterest = true;
        this.interest = newInterest;
        System.out.println("Interest updated to: " + newInterest);
      }

    } catch (IllegalArgumentException e) {
      // TODO: handle exception
      System.out.println("Error! You have already set your interest once. It cannot be changed.");
    }

  }

  public String generateAccountNumber() {
    String num = "";
    Random rand = new Random();
    for (int i = 0; i < 7; i++) {
      num += rand.nextInt(9);
    }
    return num;
  }

  public static void main(String[] args) {
    FixedDepositAccount savings = new FixedDepositAccount("Jimmy chin", 1000.00F, 4.0F, 10);
    savings.getName();
    savings.setInterest(10.5F);
    savings.setInterest(8.5F);
    savings.getBalance();

  }
}
