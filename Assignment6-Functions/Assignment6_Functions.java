import java.util.Arrays;
import java.util.Scanner;

// Assignment 6 - Functions with parameters and arguments
// Tasks: Sum/Average, Student Result, Matrix Addition, Factorial, Prime Check, Hamming Code
class Assignment6_Functions {

    // --- Task 1: Sum and Average ---
    public static void sumAndAverage(int count) {
        Scanner sc = new Scanner(System.in);
        double total = 0;
        System.out.println("Enter " + count + " numbers:");
        for (int i = 0; i < count; i++)
            total += sc.nextDouble();
        System.out.println("Sum = " + total + "  |  Average = " + (total / count));
    }

    // --- Task 2: Student Result ---
    public static int calcTotal(int pf, int maths, int phy, int eng, int ict, int isl) {
        return pf + maths + phy + eng + ict + isl;
    }

    public static double calcPercentage(int total) {
        return (total / 600.0) * 100;
    }

    public static String calcGrade(double pct) {
        if (pct >= 80) return "A+";
        if (pct >= 70) return "A";
        if (pct >= 60) return "B";
        if (pct >= 50) return "C";
        if (pct >= 40) return "D";
        return "Fail";
    }

    public static double calcCGPA(double pct) {
        if (pct >= 80) return 4.0;
        if (pct >= 70) return 3.5;
        if (pct >= 60) return 3.0;
        if (pct >= 50) return 2.5;
        if (pct >= 40) return 2.0;
        return 0.0;
    }

    public static void printResult(String name, int total, double pct, double cgpa, String grade) {
        System.out.println("\n--- STUDENT RESULT ---");
        System.out.println("Name       : " + name);
        System.out.println("Total      : " + total + " / 600");
        System.out.println("Percentage : " + pct + "%");
        System.out.println("CGPA       : " + cgpa);
        System.out.println("Grade      : " + grade);
    }

    // --- Task 3: Matrix Addition ---
    public static int[][] addMatrices(int n, Scanner sc) {
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        System.out.println("Matrix A:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();
        System.out.println("Matrix B:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = sc.nextInt();
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = A[i][j] + B[i][j];
        return res;
    }

    // --- Task 4: Factorial ---
    public static long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    // --- Task 5: Prime Check ---
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    // --- Task 6: Hamming Code Positions ---
    public static String[] hammingPositions(String[] arr) {
        int count = 1, exp = 0;
        while (true) {
            int idx = (int) Math.pow(2, exp);
            if (idx > arr.length) break;
            arr[idx - 1] = "h" + count;
            exp++;
            count++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers to add? ");
        sumAndAverage(sc.nextInt());

        System.out.print("\nStudent name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter marks (PF, Maths, Physics, English, ICT, Islamiat): ");
        int pf = sc.nextInt(), maths = sc.nextInt(), phy = sc.nextInt(),
            eng = sc.nextInt(), ict = sc.nextInt(), isl = sc.nextInt();
        int total = calcTotal(pf, maths, phy, eng, ict, isl);
        double pct = calcPercentage(total);
        printResult(name, total, pct, calcCGPA(pct), calcGrade(pct));

        System.out.print("\nMatrix size N: ");
        int n = sc.nextInt();
        int[][] mat = addMatrices(n, sc);
        System.out.println("Addition Result:");
        for (int[] row : mat) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }

        System.out.print("\nFactorial of: ");
        int num = sc.nextInt();
        System.out.println(num + "! = " + factorial(num));

        System.out.print("\nCheck if prime: ");
        int chk = sc.nextInt();
        System.out.println(chk + (isPrime(chk) ? " is prime." : " is not prime."));

        System.out.print("\nHamming array size: ");
        int hs = sc.nextInt();
        String[] bits = new String[hs];
        Arrays.fill(bits, "d");
        System.out.println("Hamming: " + Arrays.toString(hammingPositions(bits)));

        sc.close();
    }
}
