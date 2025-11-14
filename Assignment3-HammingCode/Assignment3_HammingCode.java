import java.util.Arrays;
import java.util.Scanner;

// Marks positions at powers of 2 as parity bits (h1, h2...) and rest as data bits (d)
class Assignment3_HammingCode {

    public static String[] markParityBits(String[] bitArray) {
        int parityCount = 1;
        int exp = 0;

        while (true) {
            int pos = (int) Math.pow(2, exp);
            if (pos > bitArray.length) break;
            bitArray[pos - 1] = "h" + parityCount;
            exp++;
            parityCount++;
        }
        return bitArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N (number of bits): ");
        int n = sc.nextInt();

        String[] bits = new String[n];
        Arrays.fill(bits, "d");

        System.out.println("Result: " + Arrays.toString(markParityBits(bits)));

        sc.close();
    }
}
