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

        if (response.equals("cancel")) {
          System.out.println("Transaction canceled. Please retrieve your card.");
          break;
        }
        if (info.checkPin(response)) {
          switch (response) {
            case "1":
              info.showBalance();
              break;
            case "2":
              info.depositCash(response);
              break;
            case "3":
              info.withdrawCash(response);
              break;
          }
        }  else {
          System.out.println("Your account is locked.");
          response = "cancel";
        }

      }while (!response.equals("cancel"));
    }
    else {
      System.out.println("Please insert your card");
    }
    scan.close();
  }
}