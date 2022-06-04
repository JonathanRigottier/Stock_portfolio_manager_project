package menu;

import model.Portfolio;
import model.Stock_ideas;
import persistence.RepositoryPortfolio;
import persistence.RepositoryStock_ideas;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Scanner;

public class MenuPortfolio {

    RepositoryPortfolio repositoryPortfolio = new RepositoryPortfolio();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Save a new portfolio");
        System.out.println("2: Delete a portfolio");
        System.out.println("3: List of all portfolio(s)");
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
                    menuSavePortfolio(input);
                    break;
                case 2:
                    menuDeletePortfolio(input);
                    break;
                case 3:
                    menuListOfPortfolios();
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

    private void menuSavePortfolio(Scanner input) {
        Portfolio portfolio = new Portfolio();
        System.out.println("Type the amount of stock purchased : ");
        int amount = input.nextInt();
        portfolio.setAmount_of_stock_purchased(amount);

        System.out.println("Type the single stock purchased price : ");
        float price = input.nextFloat();
        portfolio.setSingle_stock_purchased_price(price);

        repositoryPortfolio.savePortfolio(portfolio);

    }

    private void menuDeletePortfolio (Scanner input){
        Portfolio portfolio = new Portfolio();
        System.out.println("Type the ID of the portfolio you want to delete : ");
        int id = input.nextInt();
        portfolio.setPortfolio_id(id);

        repositoryPortfolio.deletePortfolio(portfolio);
    }

    private void menuListOfPortfolios() {
        List<Portfolio> list = repositoryPortfolio.listAllPortfolios();
        for (Portfolio portfolio :list) {
            System.out.println(portfolio.toString());
        }
    }
}
