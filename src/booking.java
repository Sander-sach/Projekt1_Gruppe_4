import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class booking {
    // tilføj tlf nummer som variabel dette skal være søge variablen
    String navn;
    String tid;
    LocalDateTime time;
    Scanner input=new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    booking(String navn, LocalDateTime time){
        this.navn=navn;
        this.time=time;


    }

    public void addBooking(){
        navn = input.nextLine();
        while(true) {
            this.tid = input.nextLine();
            try {
                LocalDateTime tid = LocalDateTime.parse(this.tid, formatter);
                time=tid;
                break;
            } catch (DateTimeParseException k) {
                System.out.println("Ikke gyldig dato eller tid");
            }
        }
        input.close();
    }
    public String toString(){
        return navn+"\t"+time;
    }





    public static void main(String[]arg){
        booking a1=new booking(null,null);
        a1.addBooking();
        System.out.println(a1);


    }//Main
}
