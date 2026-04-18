import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name;
    int marks;

// Constructor
   Student(String name, int marks){
     this.name = name;
     this.marks = marks;
   }
   void display(){
    System.out.println("Name: " + name + ",  Marks: " + marks);
   }
}


public class Student_Record_System {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList to store students
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();

                    // Create object and add to ArrayList
                    students.add(new Student(name, marks));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No records found!");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}