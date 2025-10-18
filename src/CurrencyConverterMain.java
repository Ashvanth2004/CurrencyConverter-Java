import java.util.Scanner;

public class CurrencyConverterMain {

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Currency Converter =====");
            System.out.print("Enter source currency (e.g., USD): ");
            String fromCurrency = scan.next().toUpperCase();

            System.out.print("Enter target currency (e.g., INR): ");
            String toCurrency = scan.next().toUpperCase();

            System.out.print("Enter the amount to convert: ");
            double amount = scan.nextDouble();

            try {
                double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                System.out.printf("Converted amount: %.2f %s%n", convertedAmount, toCurrency);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to perform another conversion? (yes/no): ");
            String choice = scan.next();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Exiting...");
                break;
            }
        }

        scan.close();
    }
}
