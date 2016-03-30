import java.util.Scanner;

public class SavingCalculator {
	
	static Scanner scanner = new Scanner(System.in);
	private static double initialAmount;
	private static double interestRate;
	private static int termInYears;
	private static double monthlyPayments;
	private static String name;
	private static double monthlyInterest;
	private static double savingsExtraPerMonth;
	private static double yearlyBalance = 0;
	private static int monthsInYear = 12;
	private static double monthlyBalance;
	

	public static void main(String[] args) {
		welcomeUser();
		requestSavingInfo();
		calculateAndDisplay();
		requestToContinue();
		
		
	}

	private static void farewell() {
		
		System.out.println("\n***Thank you for visiting the Savings Calculator.");
		System.out.println("***Have a nice day "+ name);
		
	}
	
	private static void requestToContinue(){
        while (true) {
            System.out.print("\nWould you like to calculate another mortgage?");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")) {
                requestSavingInfo();
                calculateAndDisplay();
            } else if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N")) {
                farewell();
                break;
            } else {
                System.out.println("Invalid option (" + input + "), please use Yes/Y or No/N.");
            }
        }
    }


	private static void calculateAndDisplay() {
		
		System.out.println("Based on your input values, you will have the following in your savings account over the next 10 years: ");
		System.out.println("-------------------------------------------------------------------------------------------------------\n");
		int year = 1;
		for(int i=0;i<termInYears;i++){
			for (int j=0; j < monthsInYear; j++){
				monthlyInterest = (interestRate/100) / 12;
				savingsExtraPerMonth =  (initialAmount * monthlyInterest) + monthlyPayments;
				monthlyBalance = initialAmount + savingsExtraPerMonth;
				initialAmount =+ monthlyBalance;
			}
			yearlyBalance =+ monthlyBalance;
			yearlyBalance = Math.floor(yearlyBalance * 100)/100;
			
			System.out.println("Year" +year + ": " + "$" + yearlyBalance);
			year++;
		}
				
	}

	private static void requestSavingInfo() {
		System.out.println("Please enter the initial amount in your savings account: ");
		String initialAmountInput = scanner.nextLine();
		initialAmount = Double.parseDouble(initialAmountInput);
		
		System.out.println("What are your monthly set payment? ");
		String paymentsInput = scanner.nextLine();
		monthlyPayments = Double.parseDouble(paymentsInput);
		
		System.out.println("Please enter the annual interest rate: ");
		String rateInput = scanner.nextLine();
		interestRate = Double.parseDouble(rateInput);
		
		System.out.println("Please enter number of years to calculate: ");
		String termInput = scanner.nextLine();
		termInYears = Integer.parseInt(termInput);
		

	}

	private static void welcomeUser() {
		System.out.println("***Savings Calculator***\n");
		System.out.println("Welcome the Savings Calculator Application.");
		System.out.println("This application will calculate the monthly payments and provide year ending balance for the length of the term");
		System.out.println("\nCan I please get your name? ");
		name = scanner.nextLine();
				
	}

}


