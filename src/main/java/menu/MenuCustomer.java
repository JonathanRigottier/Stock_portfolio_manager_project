package menu;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Broker;
import model.Customer;
import persistence.RepositoryCustomer;

public class MenuCustomer {
    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: List all customers");
        System.out.println("2: Register new customer");
        System.out.println("3: List total active customers");
        System.out.println("4: List total active and not active customers");
        System.out.println("5: Update customers phone number by customer id");
        System.out.println("6: Update account status");
        System.out.println("7: Delete a customer");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuListAllCustomers(input);
                    break;
                case 2:
                    menuSaveCustomer(input);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    menuDeleteCustomer(input);
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }



    private void menuListAllCustomers(Scanner input) {
        List<Customer> listCustomer = repositoryCustomer.listAllCustomers();

        if (listCustomer.size() > 0) {
            System.out.println("\nList of Customers:");
            for (Customer cust : listCustomer) {
                System.out.println(cust.toString());
            }
        } else {
            System.out.println("\nNo customers registered\n");
            menuOptions(input);
        }
    }

    private void menuSaveCustomer(Scanner input) {
        Customer customer = new Customer();
        System.out.println("Type the customer name");
        String name = input.next();
        customer.setFirstName(name);
        boolean emailIsValid = false;


        while (!emailIsValid) {
            System.out.println("Type the customer email");
            String email = input.next();
            emailIsValid = validEmail(email);
            customer.setEmail(email);
        }
        System.out.println("Type the customer phone number");
        String phoneNumber = input.next();
        customer.setPhoneNumber(phoneNumber);

        repositoryCustomer.saveCustomer(customer);

    }

    private boolean validEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches(); //if valid returns true, if not returns false
    }

    private void menuDeleteCustomer(Scanner input){
        Customer customer = new Customer();
        System.out.println("Type the ID of the customer you want to delete");
        int id = input.nextInt();
        customer.setCustomerId(id);

        repositoryCustomer.deleteCustomer(customer);
    }

}
