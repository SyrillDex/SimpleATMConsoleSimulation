import java.text.NumberFormat;
import java.util.Scanner;

public class CardInfo {

    NumberFormat format = NumberFormat.getCurrencyInstance();
    Scanner scan = new Scanner(System.in);

    private final int pin = 122820;
    private final String  accountName = "Syrill Dex Laguerta";
    double balance = 100000.00;

    public int getPin() {
        return pin;
    }

    public String getAccountName() {
        return accountName;
    }

    public boolean checkPin(String response) {

        int pinInputLimit = 3;

        while (pinInputLimit > 0){

            System.out.println("Please enter your PIN");
            response = scan.nextLine();
            int pinInput = Integer.parseInt(response);

            if (pinInput != pin){
                pinInputLimit--;
                System.out.println("Wrong pin you have " + pinInputLimit + " tries left");
            }
            else {
                return true;
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
}
