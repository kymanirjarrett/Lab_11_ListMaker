import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    static ArrayList<String> menuArrayList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exitProgram = false;
        while (!exitProgram) {
            displayMenu();
            String choice = SafeInput.getRegExString(in, "Please enter your menu selection (A, D, P, Q): ", "[AaDdPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    exitProgram = confirmExit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the array/list");
        System.out.println("D - Delete an item from the array/list");
        System.out.println("P - Print out the array/list");
        System.out.println("Q - Quit/Exit the program");
    }

    private static void addItem() {
        menuArrayList.add("Skittle");
        menuArrayList.add("Sour Patch Kids");
        menuArrayList.add("KitKat");
        menuArrayList.add("M&M");
        menuArrayList.add("Swedish Fish");
        menuArrayList.add("Snickers");
        menuArrayList.add("Twix");

        System.out.println("Candy brands added to the list.");
    }

    private static void deleteItem() {
        if (menuArrayList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Current list:");
        displayNumberedItems();
        int index = SafeInput.getRangedInt(in, "Enter the number of the item to delete: ", 1, menuArrayList.size());
        String item = menuArrayList.remove(index - 1);
        System.out.println("Item deleted: " + item);
    }

    private static void printList() {
        System.out.println("Current list/array:");
        displayNumberedItems();
    }

    private static boolean confirmExit() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N): ");
    }

    private static void displayNumberedItems() {
        if (menuArrayList.isEmpty()) {
            System.out.println("The list/array is empty.");
        } else {
            for (int i = 0; i < menuArrayList.size(); i++) {
                System.out.println((i + 1) + ". " + menuArrayList.get(i));
            }
        }
    }
}