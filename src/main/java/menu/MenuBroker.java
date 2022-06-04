package menu;

import model.Broker;
import persistence.RepositoryBroker;

import java.util.List;
import java.util.Scanner;

public class MenuBroker {
    RepositoryBroker repositoryBroker = new RepositoryBroker();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Save a new broker");
        System.out.println("2: Update broker information");
        System.out.println("3: List of all brokers");
        System.out.println("4: Delete a broker");
        System.out.println("5: List the number of user per broker");
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
                    menuSaveBroker(input);
                    break;
                case 2:
                    menuUpdateBroker(input);
                    break;
                case 3:
                    menuListOfBrokers();
                    break;
                case 4:
                    menuDeleteBroker(input);
                    break;
                case 5:
                    menuListOfUsersByBroker();
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

    private void menuSaveBroker(Scanner input) {
        Broker broker = new Broker();
        System.out.println("Type the broker name : ");
        input.nextLine();
        String name = input.nextLine();
        broker.setName(name);

        System.out.println("Type the country of the broker : ");
        String country = input.nextLine();
        broker.setCountry(country);

        repositoryBroker.saveBroker(broker);

    }

    private void menuDeleteBroker(Scanner input){
        Broker broker = new Broker();
        System.out.println("Type the ID of the broker you want to delete");
        int id = input.nextInt();
        broker.setBroker_id(id);

        repositoryBroker.deleteBroker(broker);
    }

    private void menuListOfBrokers() {
        List<Broker> list = repositoryBroker.listAllBrokers();
        for (Broker broker:list) {
            System.out.println(broker.toString());
        }
    }

    private void menuUpdateBroker(Scanner input) {
        Broker broker = new Broker();
        System.out.println("Type the id of the broker you want to update : ");
        int id = input.nextInt();
        broker.setBroker_id(id);
        System.out.println("Type the broker name : ");
        input.nextLine();
        String name = input.nextLine();
        broker.setName(name);

        System.out.println("Type the country of the broker : ");
        String country = input.nextLine();
        broker.setCountry(country);

        System.out.println("Broker information successfully updated");
        repositoryBroker.updateBroker(broker);
    }

    private void menuListOfUsersByBroker () {
        List<Broker> list = repositoryBroker.listOfUsersByBroker();
        for (Broker broker : list) {
            System.out.println(broker.toString());
        }
    }
}
