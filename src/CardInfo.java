import java.text.NumberFormat;
import java.util.Scanner;

public class CardInfo {

    NumberFormat format = NumberFormat.getCurrencyInstance();
    Scanner scan = new Scanner(System.in);

    private final int pin = 122820;
    private final String  accountName = "Syrill Dex Laguerta";
    double balance = 100000.00;

    public boolean checkPin(String response) {

        int pinInputLimit = 3;

        while (pinInputLimit > 0){

            try {
                System.out.println("Please enter your PIN");
                response = scan.nextLine();
                int pinInput = Integer.parseInt(response);

                if (pinInput != pin){
                    pinInputLimit--;
                    System.out.println("Wrong pin you have " + pinInputLimit + " tries left");
                    System.out.println();
                }
                else {
                    return true;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid pin");
                pinInputLimit--;
                System.out.println("Wrong pin you have " + pinInputLimit + " tries left");
                System.out.println();
            }

        }
        return false;
    }

    public void showBalance() {
        System.out.println("Account name: " + accountName);
        System.out.println();
        System.out.println("Current balance: " + format.format(balance));
        System.out.println();
        System.out.println("Press Enter to make another transaction");
        scan.nextLine();
    }

    public void depositCash(String response){
        System.out.println("Please enter the amount you want to deposit");
        try {
            response = scan.nextLine();
            int amount = Integer.parseInt(response);

            if (amount >= 100) {
                balance += amount;
                System.out.println();
                System.out.println("Your new balance is " + format.format(balance));
            }
            else {
                System.out.println("The minimum deposit amount is 100.00");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount");
        }
    }

    public void withdrawCash(String response) {
        System.out.println("Please enter the amount you want to withdraw");
        try {
            response = scan.nextLine();
            int amount = Integer.parseInt(response);

            if (amount < 100) {
                System.out.println("The amount limit is 100.00");
            }
            else if (amount % 100 != 0) {
                System.out.println("The amount must be divisible by 100");
            }
            else if (amount > balance) {
                System.out.println("Not enough balance");
            }
            else {
                balance -= amount;
                System.out.println();
                System.out.println("Your new balance is " + format.format(balance));
                System.out.println("Please get your cash, card, and receipt");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount");
        }
    }
}
