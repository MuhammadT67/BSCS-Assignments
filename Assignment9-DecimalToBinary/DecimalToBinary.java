import java.util.Scanner;

// Converts decimal to binary manually using repeated division
class DecimalToBinary {

    public static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, n % 2);
            n /= 2;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            System.out.println("Binary: " + toBinary(num));
        }

        sc.close();
    }
}
