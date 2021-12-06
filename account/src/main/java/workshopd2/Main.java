package workshopd2;

public class Main {
  public static void main(String[] args) {
    BankAccount salary = new BankAccount("Monty Python");
    System.out.printf("Account belongs to: %20s \n", salary.getName());
    System.out.printf("Account number: %20s \n", salary.getAccNum());
    System.out.printf("Account balance: %20f \n", salary.getBalance());
    salary.deposit(100.00F);

    System.out.println(salary.getTransactions());
    salary.withdraw(10.5F);
    System.out.println(salary.getTransactions());

    salary.closeAccount();
    System.out.println(salary.getTransactions());
    System.out.println(salary.getClosingDate());

    // FixedDepositAccount savings = new FixedDepositAccount("Jimmy chin", 1000.00F,
    // 4.0F, 10);
    // savings.getName();
    // savings.setInterest(10.5F);
    // savings.setInterest(8.5F);
    // savings.getBalance();
  }
}
