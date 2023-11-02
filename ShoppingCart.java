package day1;
/*//Print Opening remarks as "Welcome to your shopping cart"//
Enter a loop:
Prompt user for a command
    Either
        add followed  by a comma-separated list of fruit add each fruit to the cart
        delete folowed by a number - delete the selected fruit
        list - print the contents of the cart
        stop - end the loop
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private static List<String> fruits = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
        System.out.println("Welcome to your shopping cart");
        System.out.println("enter : list, add, delete");

        String command = scanner.nextLine().toLowerCase(); // user to enter command but converted in lowercase
        
        switch (command) {
            case "list":
                viewCart();
                break;

            case "add":
                addFruit(scanner);
                break;

            case "delete":
                deleteFruit(scanner);
                break;
            default:
                System.out.println("Incorrect command, pleaser enter: list, add, delete");
                break;
        }
        }
}
    private static void viewCart() {
        if (fruits.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            System.out.println("list:" );
            for(int i =0; i <fruits.size(); i++) {
                System.out.println(i + 1 +". " + fruits.get(i));
            }
        }
    }

    private static void addFruit(Scanner scanner) {
        System.out.println("fruits to add:");
        String fruitName = scanner.nextLine(); //allow user to type what fruit to add
        fruits.add(fruitName);
        System.out.println(fruitName + " added to cart");
    } 
    
    private static void deleteFruit(Scanner scanner) {
        if (fruits.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        } 

        System.out.println("list:");
        for(int i =0; i < fruits.size(); i++) {
                System.out.println(i + 1 +". " + fruits.get(i));
            }
        System.out.println("fruits to delete:");
        int choice  = scanner.nextInt(); //allow user to type the number of the fruit listed
        scanner.nextLine();

        if(choice>0 && choice <=fruits.size()) {
            String removedfruit = fruits.remove(choice-1);
            System.out.println(removedfruit + " removed from cart");
        } else {
            System.out.println("Invalid choice");
        }
    }
}