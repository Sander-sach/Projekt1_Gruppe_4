import java.util.Scanner;

public class Main {
    Scanner tastatur = new Scanner(System.in);
    Kalender k1 = new Kalender();
    AppointmentManager a1 = new AppointmentManager();
    Betaling b1= new Betaling();

    public void startOp() {
        boolean run = true;

        while (run) {
            mainMenu();
            String valg = tastatur.nextLine();
            switch (valg) {
                case "1":
                    boolean run2= true;
                    while(run2){
                        bookingMenu();
                        String valg2 = tastatur.nextLine();
                        switch(valg2){
                            case "1": k1.opdaterKalender();break;
                            case "2":a1.searchCustomer(k1.kalender);
                            a1.deleteBooking(k1.kalender);break;
                            case "3":k1.kalenderUge();break;
                            case "0": returMenu(); run2=false;
                        }
                    }
                    break;
                case "2":
                    b1.betalingsSystem();
                    break;
                case "0":
                    run = false;
            }
        }
    }
        void mainMenu() {
            System.out.println("\tHarry's Salon System\n" +
                    "Tast1: BookingMenu\n" +
                    "Tast2: BetalingsMenu\n" +
                    "Tast0: Afslut Programmt");
        }
    void bookingMenu() {
        System.out.println("\tBooking Kalender Menu\n" +
                "Tast1: Tilføj Booking\n" +
                "Tast2: Slet Booking\n" +
                "Tast3: Se Booking Kalender\n" +
                "Tast0: Retur til Main Menu");
    }
    void returMenu(){
        System.out.println("Tast0: Tilbage til Main menu");
        String valg=tastatur.nextLine();
        if(valg=="0") mainMenu();
    }


        public static void main (String[]arg){
        Main m1=new Main();
        m1.startOp();

        }

}
