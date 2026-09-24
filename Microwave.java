import java.util.Scanner;

/**
 * Calculates microwave heating time.
 *
 * @author Carel
 * @version 1.0
 * @since 2026-09-24
 */
public final class Microwave {

    /**
     * Private constructor.
     */
    private Microwave() { }

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String item = "";
        double time = 0;

        while (true) {
            System.out.print("Enter item (sub, pizza, soup): ");
            item = scanner.nextLine().trim().toLowerCase();

            if ("sub".equals(item)) {
                time = 60;
                break;
            } else if ("pizza".equals(item)) {
                time = 45;
                break;
            } else if ("soup".equals(item)) {
                time = 105;
                break;
            }
            System.out.println("Invalid item.");
        }

        int quantity = 0;
        while (true) {
            System.out.print("Enter quantity (1-3): ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity >= 1 && quantity <= 3) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid quantity.");
        }

        if (quantity == 2) {
            time *= 1.5;
        } else if (quantity == 3) {
            time *= 2.0;
        }

        final int mins = (int) time / 60;
        final int secs = (int) time % 60;

        System.out.println("\nTotal time for " + quantity + " "
                + item + "(s):");
        System.out.println(mins + " minute(s) " + secs + " second(s)");

        scanner.close();
    }
}
