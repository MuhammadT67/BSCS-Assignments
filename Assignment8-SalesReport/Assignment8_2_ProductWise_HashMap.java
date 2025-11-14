import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Same as 8.1 but uses HashMap instead of arrays
class Assignment8_2 {

    public static void main(String[] args) {
        File file = new File("SalesEVESession.txt");
        HashMap<String, Double> map = new HashMap<>();
        double grand = 0;

        try {
            Scanner sc = new Scanner(file);
            System.out.println(sc.nextLine());

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);

                String[] parts = line.split("\t");
                String prod    = parts[1];
                double price   = Double.parseDouble(parts[2]);
                double qty     = Double.parseDouble(parts[3]);
                double amount  = price * qty;
                grand += amount;

                map.merge(prod, amount, Double::sum);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("End of file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\n--- PRODUCT-WISE TOTALS (HashMap) ---");
            for (Map.Entry<String, Double> e : map.entrySet())
                System.out.println(e.getKey() + " : " + e.getValue());
            System.out.println("Grand Total = " + grand);
        }
    }
}
