import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Sales rep ID-wise totals using arrays
class Assignment8_3 {

    public static void main(String[] args) {
        File file = new File("SalesEVESession.txt");

        String[] repIDs  = new String[200];
        double[] repTots = new double[200];
        int count = 0;
        double grand = 0;

        try {
            Scanner sc = new Scanner(file);
            System.out.println(sc.nextLine());

            while (sc.hasNextLine()) {
                String line  = sc.nextLine();
                System.out.println(line);

                String[] parts = line.split("\t");
                double price   = Double.parseDouble(parts[2]);
                double qty     = Double.parseDouble(parts[3]);
                String repID   = parts[5];
                double amount  = price * qty;
                grand += amount;

                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (repIDs[i].equals(repID)) {
                        repTots[i] += amount;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    repIDs[count]  = repID;
                    repTots[count] = amount;
                    count++;
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- REP ID-WISE TOTALS ---");
        for (int i = 0; i < count; i++)
            System.out.println("Rep " + repIDs[i] + " : " + repTots[i]);
        System.out.println("Grand Total = " + grand);
    }
}
