package menu;

import model.Broker;
import model.User;
import model.UserBrokerPortfolioStock_ideas;
import persistence.RepositoryUser;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuUser {

    RepositoryUser repositoryUser = new RepositoryUser();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Save a new user");
        System.out.println("2: Update user information");
        System.out.println("3: List of all users");
        System.out.println("4: Delete an user");
        System.out.println("5: Total of user(s)");
        System.out.println("6: List of users data");
        System.out.println("7: List of users by typing the broker's name");
        System.out.println("8: Update the broker of a user");
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
                    menuSaveUser(input);
                    break;
                case 2:
                    menuUpdateUser(input);
                    break;
                case 3:
                    menuListOfUsers();
                    break;
                case 4:
                    menuDeleteUser(input);
                    break;
                case 5:
                    menuCountTotalOfUsers();
                    break;
                case 6:
                    menuUserBrokerPorfolioStock_ideas();
                    break;
                case 7:
                    menuListOfUserByBrokerName(input);
                    break;
                case 8:
                    menuUpdateBrokerOfUser(input);
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }
        } while (userChoice != 100);
    }

    private void menuSaveUser(Scanner input) {
        User user = new User();

        boolean nameIsValid = false;

        while (!nameIsValid){
            System.out.println("Type the user's name without any number or special character (only letters - minimum size 3 - maximum size 20)");
            String name = input.next();
            nameIsValid = validName(name);
            user.setName(name);
        }

        boolean usernameIsValid = false;

        while (!usernameIsValid){
            System.out.println("Type the user username (only letters - minimum size 3 - maximum size 15)");
            String username = input.next();
            usernameIsValid = validUsername(username);
            user.setUsername(username);
        }

        boolean passwordIsValid = false;

        while (!passwordIsValid){
            System.out.println("Type the user password (only letters, special character and at least 1 number - minimum size 6 - maximum size 10");
            String password = input.next();
            passwordIsValid = validPassword(password);
            user.setPassword(password);
        }


        System.out.println("Type the amount invested");
        Float amountInvested = input.nextFloat();
        user.setAmount_invested(amountInvested);

        repositoryUser.saveUser(user);

        System.out.println("New user added successfully !");

    }

    private boolean validName(String name) {
        String regex = "[a-zA-Z]{3,20}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(name).matches();
    }

    private boolean validUsername(String username) {
        String regex = "[a-zA-Z]{3,15}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(username).matches();
    }

    private boolean validPassword(String password) {
        String regex = "^(?=.*\\d+)(?=.*[a-zA-Z])[0-9a-zA-Z!$&+,:;=?@#|'<>.^*()%-]{6,10}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    private void menuDeleteUser(Scanner input){
        User user = new User();
        System.out.println("Type the ID of the user you want to delete");
        int id = input.nextInt();
        user.setUser_id(id);

        repositoryUser.deleteUser(user);
    }

    private void menuListOfUsers() {
        List<User> list = repositoryUser.listAllUsers();
        for (User user:list) {
            System.out.println(user.toString());
        }
    }

    private void menuUserBrokerPorfolioStock_ideas () {
        List<UserBrokerPortfolioStock_ideas> list = repositoryUser.listUsernameWithAmountStockWithBrokerWithStockIdeas();
        for (UserBrokerPortfolioStock_ideas user:list) {
            System.out.println(user.toString());
        }
    }

    private void menuUpdateUser(Scanner input) {
        User user = new User();
        System.out.println("Type the id of the user you want to update : ");
        int id = input.nextInt();
        user.setUser_id(id);

        System.out.println("Type the user name updated without any space : ");
        String name = input.next();
        user.setName(name);

        System.out.println("Type the user username updated : ");
        String username = input.next();
        user.setUsername(username);

        System.out.println("Type the user password updated : ");
        String password = input.next();
        user.setPassword(password);

        System.out.println("Type the amount invested updated : ");
        Float amountInvested = input.nextFloat();
        user.setAmount_invested(amountInvested);

        /*System.out.println("Type de id of the broker used : ");
        System.out.println("For Etoro, type number 1");
        System.out.println("For Interactive Brokers, type number 4");
        System.out.println("For Admiral Markets, type number 5");
        System.out.println("For IG, type number 6");
        System.out.println("For SaxoBank, type number 7");
        System.out.println("For TastyWorks, type number 8");

         */

        repositoryUser.updateUser(user);
    }

    private void menuCountTotalOfUsers() {

        System.out.println();
        System.out.println("There is " + repositoryUser.countTotalOfUser() + " users registered in the system. ");
    }

    private void menuListOfUserByBrokerName (Scanner input) {
        System.out.println("Type the name of the broker you want to know all user : ");
        input.nextLine();
        String brokerName = input.nextLine();

        List<User> list = repositoryUser.listOfUserRegisteredByBrokerChoice(brokerName);
        for (User user : list) {
            System.out.println(user.toString());
        }
        boolean ans = list.isEmpty();
        if (ans == true) {
            System.out.println();
            System.out.println("There is no registered user for " + brokerName + ".");
        }
    }

    private void menuUpdateBrokerOfUser (Scanner input) {
        User user = new User();
        System.out.println("Type the id of the user you want to update the broker : ");
        int userId = input.nextInt();

        Broker broker = new Broker();
        System.out.println("Type the id of the new broker of this user : ");
        int newBrokerId = input.nextInt();

        repositoryUser.updateUserBroker(userId,newBrokerId);

        System.out.println();
        System.out.println("Broker updated successfully");

    }
}
