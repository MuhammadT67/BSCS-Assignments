import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Sales report - product-wise total using arrays
class Assignment8_1 {

    public static void main(String[] args) {
        File file = new File("SalesEVESession.txt");

        String[] products = new String[200];
        double[] totals   = new double[200];
        int count = 0;
        double grand = 0;

        try {
            Scanner sc = new Scanner(file);
            System.out.println(sc.nextLine()); // header

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);

                String[] parts = line.trim().split("\\s{2,}");
                String prod    = parts[1];
                double price   = Double.parseDouble(parts[2]);
                double qty     = Double.parseDouble(parts[3]);
                double amount  = price * qty;
                grand += amount;

                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (products[i].equals(prod)) {
                        totals[i] += amount;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    products[count] = prod;
                    totals[count]   = amount;
                    count++;
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- PRODUCT-WISE TOTALS ---");
        for (int i = 0; i < count; i++)
            System.out.println(products[i] + " : " + totals[i]);
        System.out.println("Grand Total = " + grand);
    }
}
