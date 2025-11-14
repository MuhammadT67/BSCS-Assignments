import java.util.Scanner;

// Fast modular exponentiation using binary representation of exponent
// Used in RSA encryption: computes (base^exp) mod n efficiently
class Assignment5_ModularExp {

    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        String binExp = Long.toBinaryString(exp);

        for (int i = 0; i < binExp.length(); i++) {
            result = (result * result) % mod;
            if (binExp.charAt(i) == '1')
                result = (result * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Base: ");
        long base = sc.nextLong();
        System.out.print("Exponent: ");
        long exp = sc.nextLong();
        System.out.print("Modulus: ");
        long mod = sc.nextLong();

        System.out.println(base + "^" + exp + " mod " + mod + " = " + modPow(base, exp, mod));

        sc.close();
    }
}
