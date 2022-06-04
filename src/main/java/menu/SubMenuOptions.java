package menu;

import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuPortfolio menuPortfolio;
    private MenuBroker menuBroker;
    private MenuUser menuUser;
    private MenuStock menuStock;
    private MenuStock_ideas menuStock_ideas;

    public SubMenuOptions() {
        this.menuPortfolio = new MenuPortfolio();
        this.menuBroker = new MenuBroker();
        this.menuUser = new MenuUser();
        this.menuStock = new MenuStock();
        this.menuStock_ideas = new MenuStock_ideas();

    }


    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Portfolio");
        System.out.println("2: Sub Menu - User");
        System.out.println("3: Sub Menu - Broker");
        System.out.println("4: Sub Menu - Stock");
        System.out.println("5: Sub Menu - Stock Ideas");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void menuChoice(Scanner input) {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuPortfolio.menuChoice(input);
                    break;
                case 2:
                    this.menuUser.menuChoice(input);
                    break;
                case 3:
                    this.menuBroker.menuChoice(input);
                    break;
                case 4:
                    this.menuStock.menuChoice(input);
                    break;
                case 5:
                    this.menuStock_ideas.menuChoice(input);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:
                    exit = true;
                    System.out.println("System closed");
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuChoice(input);
            }
        }
    }
}
