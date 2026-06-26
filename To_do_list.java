// TEST123
import java.util.ArrayList;
import java.util.Scanner;
public class To_do_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<String>();
        boolean b = true;
        do{
            System.out.println("Enter your Choice = Add\n  Show\n Delete\n");
            String ch = sc.next();
            switch(ch) {
                case "Add":
                  System.out.println("enter name");
                  String name = sc.next();
                  al.add(name);
                  System.out.println(name + " added");
                  break;
            
            case "Delete":
                 System.out.println("Enter No. which you want to delete:");
                 int t = sc.nextInt();
                 if (t > 0 && t <= al.size()){
                     String deleted= al.remove(t-1);
                     System.out.println(deleted+"Deleted Succesfully");

                 }
                 else{
                    System.out.println("Element not found");
                 }
            break;
            
            case "Show":
               System.out.println("all names are:-");
               for(String i: al){
                System.out.println(i);
               }
            break;
          
        }
        System.out.println("enter true for continue");
        b = sc.nextBoolean();
        }while(b);
    
}
}
