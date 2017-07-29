import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args){
        Actions[] listOfActions = new Actions[] {new PrintInstructions(),new PrintGroceryList(),new AddItem(), new ModifyItem(),new RemoveItem(), new SearchForItem()};
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int choice = 0;
        Actions start = selectAction(listOfActions,0);
        start.Action(scanner, groceryList);
        while (!quit){
            System.out.println("\nPress 0 to get the list of options.\nSelect an option: ");
            try{
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.flush();
                Actions doAction = selectAction(listOfActions,choice);
                doAction.Action(scanner, groceryList);
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e){
                System.out.println(choice != 6 ? "\nError invalid input quitting Shopping list." : "\nQuitting Shopping list.");
                quit = true;
            }
        }
    }
    public static Actions selectAction(Actions[] action,int selectedAction){
        return action[selectedAction];
    }
}

     interface Actions {
        void Action(Scanner scanner, GroceryList groceryList);
}

class PrintInstructions implements Actions {

    public void Action(Scanner scanner, GroceryList groceryList){
        System.out.printf("Press \n\t 0 - To print choice options.\n\t 1 - To print the list of grocery items.\n\t 2 - To add an item to the list.\n\t 3 - To modify or add an item to the list.\n\t 4 - To remove an item from the list.\n\t 5 - To search for an item in the list.\n\t 6 - To quit the application.\n\n");
    }

}

class AddItem implements Actions {

    public void Action(Scanner scanner, GroceryList groceryList){
        System.out.println("Please enter the grocery item you wish to add: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

}

class PrintGroceryList implements Actions {

    public void Action(Scanner scanner, GroceryList groceryList){
        groceryList.printGroceryList();
    }
}

class ModifyItem implements Actions {

    public void Action(Scanner scanner, GroceryList groceryList){
        System.out.println("What is the item that you would like to modify?");
        String itemNo = scanner.nextLine();
        System.out.printf("What should %s be replaced with? ",itemNo);
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo,newItem);
    }
}

class RemoveItem implements Actions {

    public void Action(Scanner scanner, GroceryList groceryList){
        System.out.println("What is the item that you would like to remove?");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }
}

class SearchForItem implements Actions {
    public void Action(Scanner scanner, GroceryList groceryList){
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        System.out.printf(groceryList.onFile(searchItem) ? "Found %s in the grocery list.\n" : "%s is not in the list.\n",searchItem);
    }
}

