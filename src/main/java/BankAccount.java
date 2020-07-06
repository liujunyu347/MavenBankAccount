import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Account a1 = new Account("deep");
//        System.out.println("Balance: " + a1.getBalance());
        a1.setEmail("deep@flexon.com");
        a1.setPhone("123456789");
//        a1.deposit(1000.00);
        a1.printInfo();
//        a1.withdraw(10000);
//        a1.withdraw(500);
        System.out.println("Menu:");
        System.out.println("exit: exit the program");
        System.out.println("balance: show name and balance");
        System.out.println("show: show account information");
        System.out.println("deposit ###: deposit the funds, funds need to > than 0");
        System.out.println("withdraw ###: withdraw the funds, balance cannot < than 0");
        System.out.println();
        Scanner input = new Scanner(System.in);
        String[] command = new String[]{"", ""};
        while (!command[0].equals("exit")){
            System.out.print("Enter command: ");
            command = input.nextLine().trim().split(" ", 2);
            switch (command[0]){
                case "balance":
                    a1.getNameBalance();
                    continue;
                case "deposit":
                    a1.deposit(Integer.parseInt(command[1]));
                    break;
                case "withdraw":
                    a1.withdraw(Integer.parseInt(command[1]));
                    break;
                case "info":
                    a1.printInfo();
                    continue;
                case "exit":
                    break;
                default :
                    System.out.println("Invalid command");
            }
        }
    }
}

class Account{
    private final String accountNumber;
    private int balance;
    private String name;
    private String email;
    private String phone;

    public Account(String name){
        this.name = name;
        this.balance = 0;
        Random r = new Random();
        this.accountNumber = String.valueOf(10000 + r.nextInt(89999));
    }

    public boolean deposit(int funds){
        if (funds > 0){
            this.balance += funds;
            System.out.println("deposit succeed");
            System.out.println("Balance: " + this.balance);
            return true;
        }else{
            System.out.println("Invalid funds");
            return false;
        }


    }

    public boolean withdraw(int funds){
        if (this.balance - funds < 0){
            System.out.println("Not enough balance");
            System.out.println("Balance: " + this.balance);
            return false;
        }else{
            this.balance -= funds;
            System.out.println("withdraw succeed");
            System.out.println("Balance: " + this.balance);
            return true;
        }

    }

    public void getNameBalance(){
        System.out.println("Name: " + this.name);
        System.out.println("Balance: " + this.balance);
    }

    public void printInfo(){
        System.out.println("Customer Info:");
        System.out.println("Name: " + this.name);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
        System.out.println("Email: " + this.email);
        System.out.println("Phone Number : " + this.phone);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}