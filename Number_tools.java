import java.util.*;
public class Number_tools {
       public static void main (String[] args){
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Palindrome");
            System.out.println("2. Prime");
            System.out.println("3. Factorial");
            System.out.println("4. Reverse");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            System.out.println("Enter a number: ");
            int num = sc.nextInt();

            switch(choice){
                  case 1:
                    int revNum = 0;
                    int temp1 = num;

                      while(temp1 != 0){
                        int digit = temp1 % 10;
                        revNum = revNum * 10 + digit;
                        temp1 = temp1 /10;
                      }
                      if(num == revNum){
                        System.out.println("Palindrome Number");
                      }
                      else{
                        System.out.println("Not a Palindrome");
                      }
                      break;

                  case 2:
                    int count = 0;

                     for(int i = 1; i<= num; i++){
                        if(num % i == 0){
                            count++;
                        }
                     }
                     if (count == 2){
                        System.out.println("Prime Number");

                     }
                     else{
                        System.out.println("Not a prime Number");
                     }
                
                    break;

                  case 3:
                    int fact = 1;
                    for(int i =1; i<= num; i++){
                        fact = fact *i;
                    }
                    System.out.println("Factorial: " + fact);
                    break;

                  case 4:
                    int rev = 0;
                    int temp = num;
                     
                      while(temp!=0){
                         int digit = temp % 10;
                         rev = rev *10 + digit;
                         temp = temp/10;
                      }
                    System.out.println("Reversed number: " + rev );
                    break;

                 default:
                    System.out.println("Invalid choice");
            }  
       }
}
