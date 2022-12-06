import java.util.Scanner;

// ArrayList - capacity grows automatically vs statically sized arrays

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5 :
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\t 0 - To print choice menu.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To to add an item to the list.");
        System.out.println("\t 3 - To modify an item.");
        System.out.println("\t 4 - To remove an item.");
        System.out.println("\t 5 - To search for an item.");
        System.out.println("\t 6 - To quit the application.");

    }

    public static void addItem() {
        System.out.print("Enter an item to add: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter current item name: ");
        String itemNO = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNO, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNO = scanner.nextLine();
        groceryList.removeGroceryItem(itemNO);
    }

    public static void searchForItem(){
        System.out.println("Enter item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in the grocery list");
        } else {
            System.out.println(searchItem + " is not in the grocery list.");
        }
    }
}
