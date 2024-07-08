package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.entities.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> findAll();
    Optional<Room> findById(String id);
    Room save(Room room);
    void deleteById(String id);
    Room updateRoom(String id, Room roomDetails);
}
