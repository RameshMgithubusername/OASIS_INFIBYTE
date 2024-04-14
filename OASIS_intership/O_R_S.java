
import java.util.Scanner;

// Class to represent a Train
class Train {
    private int trainNumber;
    private String trainName;

    public Train(int trainNumber, String trainName) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
    }

    // Getters and setters
}

// Class to represent a Reservation
class Reservation {
    private static int nextPnr = 1;
    private int pnr;
    private String passengerName;
    private int trainNumber;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(String passengerName, int trainNumber, String classType, String dateOfJourney, String from,
            String to) {
        this.pnr = nextPnr++;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    // Getter for PNR
    public int getPnr() {
        return pnr;
    }
}

// Class to manage reservations
class ReservationManager {
    // Database to store reservations
    private Reservation[] reservations;
    private int numReservations;

    public ReservationManager(int capacity) {
        reservations = new Reservation[capacity];
        numReservations = 0;
    }

    // Method to add a reservation
    public void addReservation(Reservation reservation) {
        if (numReservations < reservations.length) {
            reservations[numReservations] = reservation;
            numReservations++;
            System.out.println("Reservation successfully added! PNR: " + reservation.getPnr());
        } else {
            System.out.println("Reservation failed: Database full!");
        }
    }

    // Method to cancel a reservation
    public void cancelReservation(int pnr) {
        boolean found = false;
        for (int i = 0; i < numReservations; i++) {
            if (reservations[i].getPnr() == pnr) {
                found = true;
                // Cancel the reservation (e.g., remove from database)
                // Implement your cancellation logic here
                System.out.println("Reservation with PNR " + pnr + " canceled successfully!");
                // Shift remaining reservations to fill the gap
                for (int j = i; j < numReservations - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                numReservations--;
                break;
            }
        }
        if (!found) {
            System.out.println("Reservation not found!");
        }
    }
}

public class O_R_S {
    private static Scanner scanner = new Scanner(System.in);
    private static ReservationManager reservationManager = new ReservationManager(100); // Capacity of 100 reservations

    public static void main(String[] args) {
        // Sample data for trains
        Train train1 = new Train(1001, "Express Train");
        Train train2 = new Train(1002, "Local Train");

        // Sample data for reservations
        Reservation reservation1 = new Reservation("John Doe", 1001, "First Class", "2024-04-10", "City A", "City B");
        Reservation reservation2 = new Reservation("Jane Smith", 1002, "Economy Class", "2024-04-11", "City B",
                "City C");

        // Adding sample reservations to the reservation manager
        reservationManager.addReservation(reservation1);
        reservationManager.addReservation(reservation2);

        // Implement login functionality here

        // Implement reservation and cancellation functionality using reservationManager
        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void makeReservation() {
        // Accept user input for making a reservation
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey (YYYY-MM-DD): ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter from location: ");
        String from = scanner.nextLine();
        System.out.print("Enter to location: ");
        String to = scanner.nextLine();

        // Create a reservation object and add it to the reservation manager
        Reservation newReservation = new Reservation(passengerName, trainNumber, classType, dateOfJourney, from, to);
        reservationManager.addReservation(newReservation);
    }

    private static void cancelReservation() {
        // Accept user input for canceling a reservation
        System.out.print("Enter PNR of the reservation to cancel: ");
        int pnr = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        reservationManager.cancelReservation(pnr);
    }
}
