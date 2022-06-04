package menu;

import model.Stock;
import model.Stock_ideas;
import persistence.RepositoryStock;
import persistence.RepositoryStock_ideas;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuStock_ideas {

    RepositoryStock_ideas repositoryStock_ideas = new RepositoryStock_ideas();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Save a new stock ideas");
        System.out.println("2: Delete a stock ideas");
        System.out.println("3: List of all stock ideas");
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
                    menuSaveStock_ideas(input);
                    break;
                case 2:
                    menuDeleteStock_ideas(input);
                    break;
                case 3:
                    menuListOfStocksIdeas();
                    break;
                case 4:
                    break;
                case 5:
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

    private void menuSaveStock_ideas(Scanner input) {
        Stock_ideas stock_ideas = new Stock_ideas();
        System.out.println("Type the name of the stock ideas you want to add : ");
        input.nextLine();
        String name = input.nextLine();
        stock_ideas.setName(name);

        System.out.println();
        System.out.println("Stock idea added successfully.");

        repositoryStock_ideas.saveStockIdeas(stock_ideas);

    }

    private void menuDeleteStock_ideas (Scanner input){
        Stock_ideas stock_ideas = new Stock_ideas();
        System.out.println("Type the ID of the stock ideas you want to delete : ");
        int id = input.nextInt();
        stock_ideas.setStock_ideas_list_id(id);

        repositoryStock_ideas.deleteStockIdeas(stock_ideas);
    }

    private void menuListOfStocksIdeas() {
        List<Stock_ideas> list = repositoryStock_ideas.listAllStockIdeas();
        for (Stock_ideas stock_ideas :list) {
            System.out.println(stock_ideas.toString());
        }
    }

}
