import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args){
        DoAction[] obj = new DoAction[] {new PrintInstructions(),new PrintGroceryList(),new AddItem(), new ModifyItem(),new RemoveItem(), new SearchForItem() };
    boolean quit = false;
        int choice = 0;
//        printInstructions();
        while (!quit){
            System.out.println("Enter your choice: ");
            try{
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Quitting Shopping list.");
                break;
            }

            scanner.nextLine();
            System.out.flush();
            if(choice < obj.length){
                DoAction doAction = x(choice, obj);
                doAction.action(scanner, groceryList);
            }
            else{
                System.out.println("Quitting Shopping list.");
                break;
            }
        }
    }
    public static DoAction x(int i, DoAction[] obj){
        return obj[i];
    }
}

class DoAction{
    public void action(Scanner scanner, GroceryList groceryList){
        System.out.println("");
    }
}

class PrintInstructions extends DoAction{

    public void action(Scanner scanner, GroceryList groceryList){
        System.out.printf("\nPress \t 0 - To print choice options.\n\t 1 - To print the list of grocery items.\n\t 2 - To add an item to the list.\n\t 3 - To modify or add an item to the list.\n\t 4 - To remove an item from the list.\n\t 5 - To search for an item in the list.\n\t 6 - To quit the application.\n\n");
    }

}

class AddItem extends DoAction{

    public void action(Scanner scanner, GroceryList groceryList){
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

}

class PrintGroceryList extends DoAction{

    public void action(Scanner scanner, GroceryList groceryList){
        groceryList.printGroceryList();
    }
}

class ModifyItem extends DoAction{

    public void action(Scanner scanner, GroceryList groceryList){
        System.out.println("Please enter the grocery item: ");
        String itemNo = scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo,newItem);
    }
}

class RemoveItem extends DoAction{

    public void action(Scanner scanner, GroceryList groceryList){
        System.out.println("Please enter the grocery item: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }
}

class SearchForItem extends DoAction{

    public void action(Scanner scanner, GroceryList groceryList){
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


