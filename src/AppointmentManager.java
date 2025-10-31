import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentManager {
    private Scanner scanner;


    public AppointmentManager() {
        scanner = new Scanner(System.in);
    }

    public void searchCustomer(ArrayList<booking> booking) {
        System.out.println("Indtast kundenavn:");
        String name = scanner.nextLine().trim();

        List<booking> results = new ArrayList<>();
        for (booking a : booking) {
            if (a.getNavn().equalsIgnoreCase(name)) {
                results.add(a);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Ingen aftaler fundet for kunden: " + name);
        } else {
            System.out.println("\nFundne aftaler:");
            for (booking a : results) {
                System.out.println(a.getTelefon() + ": " + a.getNavn() + " - " + a.getTid());
            }
        }
    }

    // Giver mulighed for at slette en aftale
    public void deleteBooking(List<booking> foundBooking) {
        System.out.println("\nIndtast telefonnummer på aftale, der skal slettes: ");
        String telefon = scanner.nextLine();

        booking toDelete = null;
        for (booking a : foundBooking) {
            if (String.valueOf(a.getTelefon()).equals(telefon)) {
                toDelete = a;
                break;
            }
        }

        if (toDelete != null) {
            System.out.println("Er du sikker på, du vil slette aftalen? (ja/nej)");
            String confirm = scanner.nextLine().trim().toLowerCase();
            if (confirm.equals("ja")) {
                foundBooking.remove(toDelete);
                System.out.println("Aftale slettet ");
            } else {
                System.out.println("Sletning annulleret.");
            }
        } else {
            System.out.println("Ugyldigt nummer.");
        }
    }


    // Test program
    public static void main(String[] args) {
        Kalender uge1=new Kalender();
        AppointmentManager a1=new AppointmentManager();
        uge1.opdaterKalender();
        a1.searchCustomer(uge1.kalender);
        a1.deleteBooking(uge1.kalender);
        uge1.kalenderUge();


    }
}
