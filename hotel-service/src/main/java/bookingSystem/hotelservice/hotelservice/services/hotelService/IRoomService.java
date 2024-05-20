package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> findAll();
    Optional<Room> findById(Long id);
    Room save(Room room);
    void deleteById(Long id);
}
