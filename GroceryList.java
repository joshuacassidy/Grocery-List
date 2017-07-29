import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void  addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.printf("You have %d items in your grocery list.\n",groceryList.size());
        for(int i = 0; i < groceryList.size(); i++){
            System.out.printf("%d. %s\n",(i+1),groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String currentItem,String newItem) {
        int positon = findItem(currentItem);
        if(positon >= 0) {
            modifyGroceryItem(currentItem,positon,newItem);
        }
    }

    private void modifyGroceryItem(String currentItem,int position, String newItem){
        groceryList.set(position,newItem);
        System.out.printf("%s has been modified to be %s.\n",currentItem,newItem);
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        System.out.printf(position >= 0 ? "Removed %s from the grocery list\n" : "%s not in list and could not be removed\n",item);
        if(position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    public int findItem(String searchItem){
            return groceryList.indexOf(searchItem);
        }

    public boolean onFile(String searchItem){
        int postion = findItem(searchItem);
        return postion >= 0 ? true : false;
    }

}


