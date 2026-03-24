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

public class BookMyStayApp {
    private Map<String, Integer> roomAvailability;

    public BookMyStay() {
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }

    public static void main(String[] args) {
        BookMyStay inventory = new BookMyStay();
        System.out.println(inventory.getRoomAvailability());
        inventory.updateAvailability("Single Room", 4);
        System.out.println(inventory.getRoomAvailability());
    }
}
