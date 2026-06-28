import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        loadExpenses(expenses);
        
        


        // Expense expense1 = new Expense();

        // expense1.title = "Pizza";
        // expense1.amount = 350;
        // expense1.category = "Food";

        // expenses.add(expense1);

        // Expense expense2 = new Expense();
        
        // expense2.title = "Petrol";
        // expense2.amount = 1000;
        // expense2.category = "Travel";

        // expenses.add(expense2);

        // Expense expense3 = new Expense();
        
        // expense3.title = "coeffe ";
        // expense3.amount = 100;
        // expense3.category = "Food";



        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");  
            System.out.println("4. Search by Category"); 
            System.out.println("5. Delete Expense");           
            System.out.println("6. Edit Expense");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                {
                
                Expense expense = new Expense();
                sc.nextLine();
                  
                System.out.println("Enter Title: ");
                expense.title = sc.nextLine();

                System.out.println("Enter Amount");
                expense.amount = sc.nextDouble();

                sc.nextLine();

                System.out.println("Enter Category: ");
                expense.category = sc.nextLine();

                expenses.add(expense);
                    System.out.println("Expense Added Succesfully!");
                    break;}
                

                case 2: {
                    System.out.println("\n======All Expenses=====");

                    for (Expense expense : expenses){

                        System.out.println("Title:" + expense.title);
                        System.out.println("Amount:" + expense.amount);
                        System.out.println("Category: " + expense.category);
                        System.out.println("-----------------------");
                    }

                   // System.out.println("View Expenses Selected");
                    break;}

                case 3:

                double total = 0;

                for(Expense expense: expenses){
                  
                    total = total + expense.amount;}

                    System.out.println("Total Expense = " + total);

                    break;

                case 4:
                      sc.nextLine();
                      System.out.println("Enter Category: ");
                      String searchCategory = sc.nextLine();

                      boolean found = false;

                      System.out.println("\n===== Search Result =====");

                      for(Expense expense: expenses){
                        if(expense.category.equalsIgnoreCase(searchCategory)){
                            System.out.println("Title:" + expense.title);
                            System.out.println("Amount:" + expense.amount);
                            System.out.println("Category:" + expense.category);
                            System.out.println("------------------------");

                            found = true;
                        }
                      }

                      if(!found){
                        System.out.println("No expenses found in this category");
                      }
                      break;

                    
                    case 5:

    if (expenses.isEmpty()) {
        System.out.println("No expenses found.");
        break;
    }

    System.out.println("\n===== Expenses =====");

    for (int i = 0; i < expenses.size(); i++) {

        System.out.println((i + 1) + ". " + expenses.get(i).title);

    }

   System.out.print("Enter expense number to delete: ");
int choiceDelete = sc.nextInt();

if (choiceDelete >= 1 && choiceDelete <= expenses.size()) {

    expenses.remove(choiceDelete - 1);
    System.out.println("Expense Deleted Successfully!");

} else {

    System.out.println("Invalid expense number.");

}

    break;


    case 6:

    if (expenses.isEmpty()) {
        System.out.println("No expenses found.");
        break;
    }

    System.out.println("\n===== Expenses =====");

    for (int i = 0; i < expenses.size(); i++) {
        System.out.println((i + 1) + ". " + expenses.get(i).title);
    }

    System.out.print("Enter expense number to edit: ");
    int editChoice = sc.nextInt();

    if (editChoice >= 1 && editChoice <= expenses.size()) {

        Expense exp = expenses.get(editChoice - 1);

        sc.nextLine();

        System.out.print("Enter New Title: ");
        exp.title = sc.nextLine();

        System.out.print("Enter New Amount: ");
        exp.amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter New Category: ");
        exp.category = sc.nextLine();

        System.out.println("Expense Updated Successfully!");

    } else {

        System.out.println("Invalid expense number.");

    }

    break;

             case 7: 
                saveExpenses(expenses);
                System.out.println("Thank You!");
                sc.close();
                return;

                default:
                    System.out.println("Invalid Choice");
            }

            

            }

        }

    

    public static void saveExpenses(ArrayList<Expense> expenses){
                       
                try{
                    FileWriter fw = new FileWriter("expenses.txt");
                    PrintWriter pw = new PrintWriter(fw);

                    for(Expense expense: expenses){
                        pw.println(expense.title + "," + expense.amount + "," + expense.category);

                    }

                    pw.close();
                    System.out.println("Expenses Saved Succesfully!");


                }

                catch(Exception e){
                    System.out.println("Error Saving File!");
                }

}
    

public static void loadExpenses(ArrayList<Expense> expenses) {

    try {

        File file = new File("expenses.txt");

        if (!file.exists()) {
            return;
        }

        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            String[] data = line.split(",");

            Expense expense = new Expense();

            expense.title = data[0];
            expense.amount = Double.parseDouble(data[1]);
            expense.category = data[2];

            expenses.add(expense);
        }

        fileScanner.close();

    } catch (Exception e) {

        System.out.println("Error loading expenses!");

    }
}
}