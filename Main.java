import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args){
boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.flush();
            switch(choice){
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
                case 5:
                    searchForItem();
                    break;
                default:
                quit = true;
            }

        }
    }

    public static void printInstructions(){
        System.out.printf("\nPress \t 0 - To print choice options.\n\t 1 - To print the list of grocery items.\n\t 2 - To add an item to the list.\n\t 3 - To modify or add an item to the list.\n\t 4 - To remove an item from the list.\n\t 5 - To search for an item in the list.\n\t 6 - To quit the application.");
        }

    public static void addItem(){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
       
    }

    public static void modifyItem(){
        System.out.println("Please enter the grocery item: ");
        String itemNo = scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo,newItem);
       
    }

    public static void removeItem(){
        System.out.println("Please enter the grocery item: ");
        String itemNo = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
       
    }

    private static void searchForItem(){
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.printf("Found %s in the grocery list.\n",searchItem);
        }
        else{
            System.out.printf("%s is not in the list.",searchItem);
        }
       
    }

}
