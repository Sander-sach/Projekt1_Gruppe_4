import java.time.*;
import java.util.*;

public class Kalender {
    // En booking indeholder dag, tidspunkt og navn
    static class Booking {
        String navn;
        LocalDate dato;
        int klokke;

        Booking(String navn, LocalDate dato, int klokke) {
            this.navn = navn;
            this.dato = dato;
            this.klokke = klokke;
        }
    }

    public static void main(String[] args) {
        // Lav en ArrayList med alle bookinger
        ArrayList<Booking> kalender = new ArrayList<>();

        // Start- og slut-tidspunkter
        int startTid = 10;
        int slutTid = 17;

        // Lav en uge (mandag–fredag)
        LocalDate mandag = LocalDate.now().with(DayOfWeek.MONDAY);

        // Tilføj et par bookinger som eksempel
        kalender.add(new Booking("Allan", mandag, 10));
        kalender.add(new Booking("Tobias", mandag.plusDays(2), 13));
        kalender.add(new Booking("Valdemar", mandag.plusDays(4), 16));

        // Udskriv ugeformat
        System.out.println("=== Ugekalender ===\n");
        for (int i = 0; i < 5; i++) { // mandag til fredag
            LocalDate dato = mandag.plusDays(i);
            System.out.println(dato.getDayOfWeek() + " " + dato);

            for (int time = startTid; time <= slutTid; time++) {
                // Tjek om tidspunktet er booket
                boolean fundet = false;
                for (Booking b : kalender) {
                    if (b.dato.equals(dato) && b.klokke == time) {
                        System.out.println("  " + time + ":00  [BOOKET] " + b.navn);
                        fundet = true;
                        break;
                    }
                }
                if (!fundet) {
                    System.out.println("  " + time + ":00  [LEDIG]");
                }
            }
            System.out.println();
        }
    }
}
