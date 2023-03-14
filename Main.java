/* DEVELOPER: ANGELA TACKETT
        DATE: 06MAR2023

This Java program allows a user to manage customer data by providing a menu of options. 
The user can add a single or multiple customers, display all customers, retrieve data for
a specific customer, or retrieve a list of customers based on a sales range. The program 
uses a CustomerData class to store and manipulate the customer data. The program uses a 
scanner to obtain user input and a switch statement to route the user's selection to the 
appropriate method. */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	private static CustomerData customerData = new CustomerData();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// DISPLAYS user menu options | prompts user for selection
		boolean exit = false;
	    while (!exit) {
	    	System.out.println();
	        System.out.println("             MENU\n");
	        System.out.println("1: Add multiple new customers");
	        System.out.println("2: Add single new customer");
	        System.out.println("3: Display all customers");
	        System.out.println("4: Retrieve specific customer’s data");
	        System.out.println("5: Retrieve customers with total sales based on the range");
	        System.out.println("9: Exit program");
	
			System.out.print("\nEnter your selection: ");
			int choice = 0;
			while (true) { // ensures selection is integer
				try {
					choice = in.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter an integer.");
					in.nextLine();
				}
			}
			in.nextLine();
	        
	        // ASSIGNS options to proper method()
	        switch (choice) {
	            case 1:
	                addMultipleCustomers();
	                break;
	            case 2:
	                addSingleCustomer();
	                break;
	            case 3:
	                displayAllCustomers();
	                break;
	            case 4:
	                retrieveSpecificCustomerData();
	                break;
	            case 5:
	                retrieveCustomersBySalesRange();
	                break;
	            case 9:
	                System.out.println("Exiting program...");
	                exit = true;
	                break;
	            default:
	                System.out.println("Invalid selection. Please try again.");
	        }
	    }
	}
	
	// METHODS() - SELF EXPLANATORY TITLES
	
	private static void addSingleCustomer() {
	    customerData.addCustomer();
	}
	
	private static void addMultipleCustomers() {
		int numCustomers = 0;
		boolean validInput = false;
		while (!validInput) {
			try {  // ensures integer type input
				System.out.print("Enter the number of customers to be loaded: ");
				numCustomers = Integer.parseInt(in.nextLine());
				validInput = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter an integer.");
			}
		}
	
		for (int i = 0; i < numCustomers; i++) { // loops to satisfy numCustomer
			System.out.println("Enter customer " + (i+1) + " data:");
			customerData.addCustomer();
		}
	}
	
	private static void displayAllCustomers() {
	    customerData.displayAllCustomers();
	}
	
	private static void retrieveSpecificCustomerData() {
	    System.out.print("Enter customer ID: ");
	    int customerId = in.nextInt();
	    in.nextLine();
	    customerData.retrieveSpecificCustomerData(customerId);
	}
	
	private static void retrieveCustomersBySalesRange() {
	    System.out.print("Enter the lowest total sales amount: ");
	    double minSales = in.nextDouble();
	    in.nextLine();
	    System.out.print("Enter the highest total sales amount: ");
	    double maxSales = in.nextDouble();
	    in.nextLine();
	    customerData.retrieveCustomersBySalesRange(minSales, maxSales);
	}
}
