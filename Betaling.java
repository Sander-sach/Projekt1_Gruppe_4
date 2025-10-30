import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Betaling {

    // simpel betaling med dato og beløb
    static class Payment {
        LocalDate date;
        double amount;

        Payment(LocalDate date, double amount) {
            this.date = date;
            this.amount = amount;
        }

        public String toString() {
            return date + "  -  " + amount + " kr.";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ArrayList<Payment> payments = new ArrayList<>();

        // Tilføj nogle eksempler (kun for test)
        payments.add(new Payment(LocalDate.of(2025, 10, 25), 200));
        payments.add(new Payment(LocalDate.of(2025, 10, 26), 150));
        payments.add(new Payment(LocalDate.of(2025, 10, 27), 300));

        System.out.println("=== Betalingssystem ===");
        System.out.println("Du kan søge efter betalinger før dags dato (" + LocalDate.now().format(formatter) + ")");
        System.out.print("Indtast dato du vil søge efter (dd-MM-yyyy): ");

        String inputDate = input.nextLine();

        try {
            LocalDate searchDate = LocalDate.parse(inputDate, formatter);

            // Kun datoer FØR dags dato er tilladt
            if (!searchDate.isBefore(LocalDate.now())) {
                System.out.println("Du kan kun søge efter datoer før dags dato.");
                return;
            }

            // Søg i ArrayList
            boolean found = false;
            for (Payment p : payments) {
                if (p.date.equals(searchDate)) {
                    System.out.println("Fundet betaling: " + p);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Ingen betalinger fundet på denne dato.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Forkert datoformat. Brug dd-MM-yyyy.");
        }

        input.close();
    }
}

