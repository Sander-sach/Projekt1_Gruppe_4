import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class booking {
    String telefon;
    String navn;
    String tid;
    LocalDateTime time;
    Scanner input=new Scanner(System.in); // tager kunde info + booking tid fra tastatur

    // DateTimeformatter sætter et format for hvordan dato skal skrives
    //indtastning i terminalen skal altså skrives i dette format for at virke.
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    // Constructer starter en Booking med navn, tlf, tid.
    booking(String navn,String telefon, LocalDateTime time){
        this.navn=navn;
        this.time=time;
        this.telefon=telefon;
    }




    public void addBooking(){
        // Indtast kunde navn og telefoner nummer i booking
        navn = input.nextLine();
        telefon = input.nextLine();
        // While loop spørg efter en gyldig dato
        //indskrevet dato som String skal matche formattet dd-MM-yyyy HH:mm ellers fejler den
        while(true) {
            this.tid = input.nextLine();
            try {
                LocalDateTime tid = LocalDateTime.parse(this.tid, formatter);
                time=tid;
                break;
                //catch fanger fejl som skulle opstå hvis der indtastet forkert dato format
            } catch (DateTimeParseException k) {
                System.out.println("Ikke gyldig dato eller tid");
            }
        }
        input.close();
    }
    // ToString lavet til test
    public String toString(){
        return navn+"\t"+telefon+"\t"+time;
    }

    public static void main(String[]arg){
        booking a1=new booking(null,null,null);
        a1.addBooking();
        System.out.println(a1);


    }//Main
}
