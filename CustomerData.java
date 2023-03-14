import java.util.Scanner;
import java.util.InputMismatchException;

public class CustomerData {
	
	// Initialize customer object array | no. of customers | Scanner
    private Customer[] customers = new Customer[100]; // limit of 100 indices
    private int numCustomers = 0; // counter for added customers
    private Scanner in = new Scanner(System.in);

    // ADD CUSTOMER method() to customers array by user input
    public void addCustomer() {

    	// name prompt - ensures input from user
        String name = "";
        while (name.trim().isEmpty()) {
            System.out.print("Enter customer name: ");
            name = in.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            }
        }
        
        // city prompt - ensures input from user
        String city = "";
        while (city.trim().isEmpty()) {
            System.out.print("Enter customer city: ");
            city = in.nextLine().trim();
            if (city.isEmpty()) {
                System.out.println("City cannot be empty. Please try again.");
            }
        }
        
        // Prompting and validating 5-digit input
        System.out.print("Enter customer ID (5-digit number): ");
        int customerId = 0;
        while (true) {
            if (in.hasNextInt()) {
                customerId = in.nextInt();
                if (customerId >= 10000 && customerId <= 99999) {
                    break;
                } else {
                    System.out.print("Please enter a 5-digit number: ");
                }
            } else {
                System.out.print("Please enter a number: ");
                in.next();
            }
        }
        in.nextLine();
        
        // total sales prompt w. implemented try-catch block to ensure numerical input
        double totalSales = 0.0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter total sales: ");
                totalSales = in.nextDouble();
                in.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical value.");
                in.nextLine();
            }
        }

        // CREATE customer object | declare args | increment counter
        Customer customer = new Customer(name, city, customerId, totalSales);
        customers[numCustomers++] = customer;

        System.out.println();
        System.out.println("Customer add successful!");
        System.out.println();
    }
    
    // DISPLAY method() successfully added customers
    public void displayAllCustomers() {
        for (int i = 0; i < numCustomers; i++) {
            System.out.println(customers[i]);
        }
    }

    // RETRIEVE method() specific data
    public void retrieveSpecificCustomerData(int customerId) {
        System.out.print("Enter customer ID (5-digit number): ");
        while (true) {
            if (in.hasNextInt()) { 
                customerId = in.nextInt();
                if (customerId >= 10000 && customerId <= 99999) {
                    break;
                } else {
                    System.out.print("Please enter a 5-digit number: ");
                }
            } else {
                System.out.print("Please enter a number: ");
                in.next();
            }
        }
        in.nextLine();
        // RETRIEVE customer info and prompt for total sales update
        for (int i = 0; i < numCustomers; i++) {
            if (customers[i].getCustomerId() == customerId) {
                System.out.println(customers[i]);
                System.out.print("Do you want to modify the total sales value? (Y/N): ");
                String answer = in.nextLine();
                if (answer.equalsIgnoreCase("Y")) { //ignore case sensitivity
                    System.out.print("Enter the new total sales value: "); 
                    double newTotalSales = in.nextDouble();
                    in.nextLine();
                    customers[i].setTotalSales(newTotalSales); // set original value to new input
                    System.out.println("Total sales updated successfully!");
                }
                return;
            }
        }
        System.out.println("Customer not found!");        
    }

    public void retrieveCustomersBySalesRange(double minSales, double maxSales) {
        boolean found = false;
        for (int i = 0; i < numCustomers; i++) {
            double totalSales = customers[i].getTotalSales();
            if (totalSales >= minSales && totalSales <= maxSales) {
                System.out.println(customers[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No customers found within queried sales range.");
        }
	}
    
    
}