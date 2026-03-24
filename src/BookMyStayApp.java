/**
 * Application entry point for UC1
 *
 * This is a Book My Stay App
 *
 * @author Developer
 * @version 1.0
 */

import java.util.*;

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

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

class CancellationService {
    private Map<String, String> reservationRoomTypeMap;
    private Stack<String> rollbackStack;

    public CancellationService() {
        reservationRoomTypeMap = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation request for Reservation ID: " + reservationId);
            return;
        }
        String roomType = reservationRoomTypeMap.remove(reservationId);
        Map<String, Integer> availability = inventory.getRoomAvailability();
        inventory.updateAvailability(roomType, availability.get(roomType) + 1);
        rollbackStack.push(reservationId);
        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory(RoomInventory inventory) {
        System.out.println("Rollback History (Most Recent First):");
        while (!rollbackStack.isEmpty()) {
            String reservationId = rollbackStack.pop();
            String roomType = reservationRoomTypeMap.getOrDefault(reservationId, "Unknown");
            System.out.println("Released Reservation ID: " + reservationId);
            System.out.println("Updated " + roomType + " Room Availability: " + inventory.getRoomAvailability().get(roomType));
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        cancellationService.registerBooking("Single-1", "Single");
        cancellationService.registerBooking("Double-1", "Double");

        cancellationService.cancelBooking("Single-1", inventory);
        cancellationService.cancelBooking("Double-1", inventory);

        cancellationService.showRollbackHistory(inventory);
    }
}