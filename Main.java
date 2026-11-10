import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Company> market = new PriorityQueue<>();


        market.add(new Company("Nintendo", 12000));
        market.add(new Company("Umbrella", 8000));
        market.add(new Company("Oscorp", 25000));
        market.add(new Company("Cyberdyne", 18000));
        market.add(new Company("Vault-Tec", 32000));
        market.add(new Company("Aperture", 5000));
        market.add(new Company("Black Mesa", 15000));
        market.add(new Company("LexCorp", 45000));
        market.add(new Company("Globex", 1000));
        market.add(new Company("InGen", 38000));

        Company smallest = market.poll();

        if (smallest != null) {
            System.out.println("Smallest company: " + smallest);
            market.add(smallest);
        }

        final int TITAN_THRESHOLD = 500000;
        Company titan = null;
        int mergerCount = 0;

        for (Company company : market) {
            if (company.size >= TITAN_THRESHOLD) {
                if (titan == null || company.size > titan.size) {
                    titan = company;
                }
            }
        }

      
        while (market.size() >= 2 && titan == null) {
            Company first = market.poll();
            Company second = market.poll();

            int newSize = (int) (
                ((double) first.size + second.size) * 1.1
            );

            String newName = first.name + "-" + second.name;
            Company merged = new Company(newName, newSize);

            market.add(merged);
            mergerCount++;

            System.out.println(
                "\nMERGER: " + first.name + " and " + second.name
                + " have merged into " + merged.name
                + " with size " + merged.size + "!"
            );

            if (merged.size >= TITAN_THRESHOLD) {
                titan = merged;
            }
        }

       

        if (titan != null) {
            System.out.println("Industry Titan: " + titan);
        } else {
            System.out.println("No titan has emerged.");
        }

        System.out.println("Total mergers: " + mergerCount);
        System.out.println("Companies remaining: " + market.size());
    }
}

class Company implements Comparable<Company> {
    String name;
    int size;

    public Company(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(Company other) {
        return Integer.compare(this.size, other.size);
    }

    @Override
    public String toString() {
        return name + " (size: " + size + ")";
    }
}
