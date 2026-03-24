/**
 * Application entry point for UC1
 *
 * This is a Book My Stay App
 *
 * @author Developer
 * @version 1.0
 */

import java.util.Scanner;

abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

// Concrete room classes
class SingleRoom extends Room {
    public SingleRoom() { super(1, 250, 1500.0); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super(2, 400, 2500.0); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super(3, 750, 5000.0); }
}

// Main class must be public
public class BookMyStayApp {
    public static void main(String[] args) {
        // Availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Room objects
        Room single = new SingleRoom();
        Room doubleR = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display details
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        System.out.println("Double Room:");
        doubleR.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}
