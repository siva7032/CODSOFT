import java.util.Scanner;

class currency{
    // make function
    static void currencyConvert(int value) {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter how much dollor you have..");
        int dollorValue = sc2.nextInt();
        switch (value) {
            case 1:
                System.out.println("Euro(EUR) value of " + dollorValue + "dollor is " + (dollorValue * 0.99));
                break;
            case 2:
                System.out.println("Pound sterling (GBP) value of " + dollorValue + "dollor is " + (dollorValue * 0.86));
                break;
            case 3:
                System.out.println("Australian dollar (AUD) value of " + dollorValue + "dollor is "
                        + (dollorValue * 1.53));
                break;
            case 4:
                System.out.println("Canadian dollar (CAD) value of " + dollorValue + "dollor is "
                        + (dollorValue * 1.34));
                break;
            case 5:
                System.out.println("Swiss franc (CHF) value of " + dollorValue + "dollor is " + (dollorValue * 0.98));
                break;
            case 6:
                System.out.println(
                        "Indian Rupee (INR) value of " + dollorValue + "dollor is " + (dollorValue * 81.31));
                break;

            default:
                System.out.println("Enter valid input...");
                break;
        }
    }

    public static void main(String arg[]) {
        System.out.println("Currency Convertor......");
        Scanner sc = new Scanner(System.in);
        System.out.println("Select option.....");
        System.out.println("1.Dollor to Euro (EUR)");
        System.out.println("2.Dollor to Pound sterling (GBP)");
        System.out.println("3.Dollor to Australian dollar (AUD)");
        System.out.println("4.Dollor to Canadian dollar (CAD) ");
        System.out.println("5.Dollor to Swiss franc (CHF)");
        System.out.println("6.Dollor to Indian Rupee (INR)");
        int userInput = sc.nextInt();
        System.out.println("");
        currencyConvert(userInput);
        System.out.println("");
        System.out.println("Thanks........");
    }
}