import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        CardInfo info = new CardInfo();

        String response;

        System.out.println("Type \"insert\" to insert your card...");
        response = scan.nextLine().trim().toLowerCase();

        if (response.equals("insert")) {
            do {

                System.out.println("Please select transaction:");
                System.out.println("  1. Check balance");
                System.out.println("  2. Deposit money");
                System.out.println("  3. Withdraw money");
                System.out.println();
                System.out.println("Type \"cancel\" to cancel the transaction...");
                response = scan.nextLine().trim().toLowerCase();

                switch (response){
                    case "1":
                        if (info.checkPin(response)) {
                            info.showBalance();
                        }
                        else {
                            System.out.println("Your account is locked");
                            response = "cancel";
                        }
                        break;
                }

            }while (!response.equals("cancel"));
            System.out.println("Please get your card...Thank you!");
        }
        else {
            System.out.println("Please insert your card");
        }
    }
}