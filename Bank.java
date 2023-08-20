import java.util.*;

class ATM1 {
    private double balance;

    public  ATM1(double initial_balance) {
        this.balance = initial_balance;
    }

    public void getBalance() {
        System.out.println("Balance is"+balance);

    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited successfully");
    }


    public void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Amount Withdrawn Successfully");
        } else {
            System.out.println("Insufficient Balance.");

        }
    }

}

class Bank {
    private ATM1 bank_account;
    Scanner obj=new Scanner(System.in);
    public Bank(ATM1 account) {
        bank_account=account;
    }


    public static void main(String[] args) {
        ATM1 o=new ATM1(1000);
        int choice;
        Scanner obj=new Scanner(System.in);
        boolean isRunning=true;
        while(isRunning) {
            System.out.println("\t\t"+"Welcome to ATM");
            System.out.println("\t\t"+"How may I Help You ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.println("Enter the choice:");
            choice=obj.nextInt();
            switch(choice)
            {
                case 1:
                    int With_draw_amount;
                    System.out.println("Withdraw Amount:");
                    With_draw_amount=obj.nextInt();
                    o.withdraw(With_draw_amount);


                    break;
                case 2:
                    System.out.println("Enter the Amount to be deposited:");
                    int deposited=obj.nextInt();
                    o.deposit(deposited);
                    break;
                case 3:
                    o.getBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM");
                    break;
                default:
                    System.out.println("Invalid choice. Please Try Again");
            }
        }

    }
}