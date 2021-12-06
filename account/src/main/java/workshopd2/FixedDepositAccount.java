package workshopd2;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class FixedDepositAccount extends BankAccount {

  // not sure if using final is the right way to go
  // private final float interest;
  // private final int duration;
  private float interest;
  private int duration;

  private boolean changedInterest = false;
  private boolean changedDuration = false;

  public FixedDepositAccount(String name, float initDeposit) {
    super(name, initDeposit);
    this.interest = 0.03F;
    this.duration = 6;
  }

  public FixedDepositAccount(String name, float initDeposit, float interest) {
    super(name, initDeposit);
    this.interest = interest;
    this.duration = 6;
  }

  public FixedDepositAccount(String name, float initDeposit, float interest, int duration) {
    super(name, initDeposit);
    this.interest = interest;
    this.duration = duration;
  }

  @Override
  public float getBalance() {
    float newBalance = (1 + this.interest) * this.balance;
    return newBalance;
  }

  public void setInterest(float newInterest) {
    if (!this.changedInterest) {
      this.changedInterest = true;
      this.interest = newInterest;
      System.out.println("Interest updated to: " + newInterest);
    } else if (this.changedInterest) {
      throw new IllegalArgumentException("You have already changed your interest once.");
    }
  }

  public void setDuration(int newDuration) {
    if (!this.changedDuration) {
      this.changedDuration = true;
      this.duration = newDuration;
      System.out.println("Duration updated to: " + newDuration);
    } else if (this.changedDuration) {
      throw new IllegalArgumentException("You have already changed your duration once.");
    }
  }

  @Override
  public void deposit(float depositAmount) {
    // update balance, print balance for user experience
    // add transaction to transaction array
    System.out.println("Fixed deposit account does not have this deposit operation.");
  }

  @Override
  public void withdraw(float withdrawAmount) {
    // update balance, print balance for user experience
    // add transaction to transaction array
    System.out.println("Fixed deposit account does not have this withdraw operation.");
  }

  public static void main(String[] args) {
    FixedDepositAccount savings = new FixedDepositAccount("Jimmy chin", 1000.00F, 0.045F, 10);
    savings.getName();
    savings.setInterest(0.05F);
    System.out.println(savings.getBalance());
    savings.deposit(300F);

  }
}
