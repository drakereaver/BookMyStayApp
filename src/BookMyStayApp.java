/**
 * Application entry point for UC1
 *
 * This is a Book My Stay App
 *
 * @author Developer
 * @version 1.0
 */

import java.util.Scanner;

import java.util.*;
import java.util.*;

class Room {
    private String name;
    private int beds;
    private int size;
    private double price;

    public Room(String name, int beds, int size, double price) {
        this.name = name;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void display(int available) {
        System.out.println(name + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + available);
    }
}

class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory, Room single, Room dbl, Room suite) {
        Map<String, Integer> availability = inventory.getRoomAvailability();
        if (availability.get("Single") > 0) single.display(availability.get("Single"));
        if (availability.get("Double") > 0) dbl.display(availability.get("Double"));
        if (availability.get("Suite") > 0) suite.display(availability.get("Suite"));
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        Room single = new Room("Single Room", 1, 250, 1500.0);
        Room dbl = new Room("Double Room", 2, 400, 2500.0);
        Room suite = new Room("Suite Room", 3, 750, 5000.0);
        RoomSearchService search = new RoomSearchService();
        search.searchAvailableRooms(inventory, single, dbl, suite);
    }
}