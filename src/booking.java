import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class booking {
    String telefon;
    String navn;
    int tid;
    String stime;
    LocalDate time;
    Scanner input=new Scanner(System.in); // tager kunde info + booking tid fra tastatur

    // DateTimeformatter sætter et format for hvordan dato skal skrives
    //indtastning i terminalen skal altså skrives i dette format for at virke.
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Constructer starter en Booking med navn, tlf, tid.
    booking(String navn, LocalDate time,int tid,String telefon){
        this.navn=navn;
        this.time=time;
        this.telefon=telefon;
        this.tid=tid;
    }

    public void addBooking(){
        // Indtast kunde navn og telefoner nummer i booking
        System.out.println("Indtast navn: ");
        navn = input.nextLine();
        System.out.println("Indtaste telefon nummer: ");
        telefon = input.nextLine();

        // While loop spørg efter en gyldig dato
        //indskrevet dato som String skal matche formattet dd-MM-yyyy HH:mm ellers fejler den
        while(true) {
            System.out.println("Indtast booking dato i format: dd-MM-yyyy");
            this.stime = input.nextLine();
            try {
                LocalDate tid = LocalDate.parse(this.stime, formatter);
                time=tid;
                break;
                //catch fanger fejl som skulle opstå hvis der indtastet forkert dato format
            } catch (DateTimeParseException k) {
                System.out.println("Ikke gyldig dato eller tid");
            }
        }
        // klokkeslæt for booking kun i timer fx: 10,11,12,13,14,15,16
        System.out.println("Indtast tid for booking:");
        tid = input.nextInt();

    }
    public static void main(String[]arg){
        booking a1=new booking(null,null,0,null);
        a1.addBooking();
        System.out.println(a1);


    }//Main
}
