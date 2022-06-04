package menu;

import model.Broker;
import model.Stock;
import persistence.RepositoryStock;
import persistence.RepositoryUser;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuStock {

    RepositoryStock repositoryStock = new RepositoryStock();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Save a new stock");
        System.out.println("2: Delete a stock");
        System.out.println("3: List of all stocks");
        System.out.println("4: Update stock price by entering id");
        System.out.println("5: Average stock price");
        System.out.println("6: Total user(s) for each broker");
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
                    menuSaveStock(input);
                    break;
                case 2:
                    menuDeleteStock(input);
                    break;
                case 3:
                    menuListOfStocks();
                    break;
                case 4:
                    menuUpdateStockPriceById(input);
                    break;
                case 5:
                    menuAverageStockPrice();
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

    private void menuSaveStock(Scanner input) {
        Stock stock = new Stock();
        System.out.println("Type the name of the stock you want to add");
        String name = input.next();
        stock.setName(name);

        boolean tickerIsValid = false;
        while(!tickerIsValid){
            System.out.println("Type the ticker of the stock you want to add");
            String ticker = input.next();
            tickerIsValid = validTicker(ticker);
            stock.setTicker(ticker);
        }


        System.out.println("Type the current price of the stock you want to add");
        Float currentPrice = input.nextFloat();
        stock.setCurrent_price(currentPrice);

        System.out.println("Type the latest news of the stock you want to add");
        input.nextLine();
        String news = input.nextLine();
        stock.setNews_of_the_company(news);

        System.out.println("Type the country of the stock you want to add");
        String country = input.next();
        stock.setCountry(country);

        System.out.println("Stock added successfully");

        repositoryStock.saveStock(stock);

    }

    private boolean validTicker (String ticker) {
        String regex = "[A-Z]{1,5}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(ticker).matches();
    }

    private void menuDeleteStock(Scanner input){
        Stock stock = new Stock();
        System.out.println("Type the ID of the stock you want to delete");
        int id = input.nextInt();
        stock.setStock_id(id);

        repositoryStock.deleteStock(stock);
    }

    private void menuListOfStocks() {
        List<Stock> list = repositoryStock.listAllStocks();
        for (Stock stock:list) {
            System.out.println(stock.toString());
        }
    }

    private void menuUpdateStockPriceById(Scanner input) {
        System.out.println("Type the id of the stock you want to update the price");
        int id = input.nextInt();
        float newPrice = 0;
        if(repositoryStock.searchById(id) != null) {
            System.out.println("Type the price of the stock you want to update");
            newPrice = input.nextFloat();
            repositoryStock.updateStockPriceById(id, newPrice);
            System.out.println("Stock price updated successfully.");
        } else {
            System.out.println("Stock with id " + id + " not found in the system.");
        }

    }

    private void menuAverageStockPrice() {

        System.out.println();
        System.out.println("The average stock price is " + repositoryStock.averageStockPrice() + ". ");
    }



}
