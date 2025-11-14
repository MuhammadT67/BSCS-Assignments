import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Same as 8.3 but uses HashMap
class Assignment8_4 {

    public static void main(String[] args) {
        File file = new File("SalesEVESession.txt");
        HashMap<String, Double> map = new HashMap<>();
        double grand = 0;

        try {
            Scanner sc = new Scanner(file);
            System.out.println(sc.nextLine());

            while (sc.hasNextLine()) {
                String line    = sc.nextLine();
                System.out.println(line);

                String[] parts = line.split("\t");
                double price   = Double.parseDouble(parts[2]);
                double qty     = Double.parseDouble(parts[3]);
                String repID   = parts[5];
                double amount  = price * qty;
                grand += amount;

                map.merge(repID, amount, Double::sum);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\n--- REP ID-WISE TOTALS (HashMap) ---");
            for (Map.Entry<String, Double> e : map.entrySet())
                System.out.println("Rep " + e.getKey() + " : " + e.getValue());
            System.out.println("Grand Total = " + grand);
        }
    }
}
