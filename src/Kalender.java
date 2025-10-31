import java.time.*;
import java.util.*;

public class Kalender { // En booking indeholder dag, tidspunkt og navn
    public ArrayList<booking> kalender = new ArrayList<>();

    public void opdaterKalender(){
        booking newBooking = new booking(null,null,0,null);
        newBooking.addBooking();
        kalender.add(newBooking);
    }


    public void kalenderUge(){
        // Start- og slut-tidspunkter
        int startTid = 10;
        int slutTid = 17;
        // Lav en uge (mandag–fredag)
        LocalDate mandag = LocalDate.now().with(DayOfWeek.MONDAY);

        // Udskriv ugeformat
        System.out.println("=== Ugekalender ===\n");
        for (int i = 0; i < 5; i++) { // mandag til fredag
            LocalDate dato = mandag.plusDays(i);
            System.out.println(dato.getDayOfWeek() + " " + dato);

            for (int time = startTid; time <= slutTid; time++) {
                // Tjek om tidspunktet er booket
                boolean fundet = false;
                for (booking b : kalender) {
                    if (b.time.equals(dato) && b.tid == time) {
                        System.out.println("  " + time + ":00  [BOOKET] " + b.navn +"\t"+ "Mobilnummer: "+b.telefon);
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
public static void main(String[] args) {

   Kalender uge1=new Kalender();
   AppointmentManager a1=new AppointmentManager();
 uge1.opdaterKalender();
 a1.searchCustomer(uge1.kalender);
 a1.deleteBooking(uge1.kalender);
 uge1.kalenderUge();
}
}
