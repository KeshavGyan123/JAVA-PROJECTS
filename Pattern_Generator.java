import java.util.Scanner;
public class Pattern_Generator {
    

    // Right Triangle
    static void rightTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Inverted Triangle
    static void invertedTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pyramid
    static void pyramid(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // Diamond
    static void diamond(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
            System.out.println();
        }
    }

    // Hollow Square
    static void hollowSquare(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == 1 || i == n || j == 1 || j == n)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Pattern Generator =====");
            System.out.println("1. Right Triangle");
            System.out.println("2. Inverted Triangle");
            System.out.println("3. Pyramid");
            System.out.println("4. Diamond");
            System.out.println("5. Hollow Square");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 6) break;

            System.out.print("Enter number of rows: ");
            int n = sc.nextInt();

            switch (choice) {
                case 1 -> rightTriangle(n);
                case 2 -> invertedTriangle(n);
                case 3 -> pyramid(n);
                case 4 -> diamond(n);
                case 5 -> hollowSquare(n);
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

