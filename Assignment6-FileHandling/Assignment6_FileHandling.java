import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Country {
    int id;
    String name, capital;
    long population;
    double area;

    Country(int id, String name, String capital, long population, double area) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    double density() {
        return population / area;
    }

    void printInput() {
        System.out.println(id + " | " + name + " | " + capital + " | " + population + " | " + area);
    }

    void printOutput() {
        System.out.printf("%-20s -> Density: %.2f per km²%n", name, density());
    }
}

// Reads country data from a CSV file and calculates population density
class Assignment6_FileHandling {

    public static void main(String[] args) {
        File file = new File("countries.txt");
        ArrayList<Country> list = new ArrayList<>();

        try {
            Scanner sc = new Scanner(file);
            if (sc.hasNextLine()) sc.nextLine(); // skip header

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] d = line.split(",");
                list.add(new Country(
                    Integer.parseInt(d[0].trim()),
                    d[1].trim(), d[2].trim(),
                    Long.parseLong(d[3].trim()),
                    Double.parseDouble(d[4].trim())
                ));
            }
            sc.close();

            System.out.println("=== INPUT ===");
            for (Country c : list) c.printInput();

            System.out.println("\n=== OUTPUT ===");
            for (Country c : list) c.printOutput();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
