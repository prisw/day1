package day1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserWordInput {
    private static List<String> fruits = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a fruit");
            System.out.println("2. Delete a fruit");
            System.out.println("3. View cart");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addFruit(scanner);
                    break;
                case 2:
                    deleteFruit(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addFruit(Scanner scanner) {
        System.out.print("Enter the name of the fruit to add: ");
        String fruitName = scanner.nextLine();
        fruits.add(fruitName);
        System.out.println(fruitName + " has been added to your shopping cart.");
    }

    private static void deleteFruit(Scanner scanner) {
        if (fruits.isEmpty()) {
            System.out.println("Your shopping cart is already empty.");
            return;
        }

        System.out.println("Fruits in your shopping cart:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(i + 1 + ". " + fruits.get(i));
        }

        System.out.print("Enter the number of the fruit to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice > 0 && choice <= fruits.size()) {
            String removedFruit = fruits.remove(choice - 1);
            System.out.println(removedFruit + " has been removed from your shopping cart.");
        } else {
            System.out.println("Invalid selection. Please choose a valid number.");
        }
    }

    private static void viewCart() {
        if (fruits.isEmpty()) {
            System.out.println("Your shopping cart is empty");
        } else {
            System.out.println("Fruits in your shopping cart:");
            for (int i = 0; i < fruits.size(); i++) {
                System.out.println(i + 1 + ". " + fruits.get(i));
            }
        }
    }
}
