package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.dto.RoomDto;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.entities.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> findAll();
    List<Room> findRoomsByHotelId(String hotelId);
    Optional<Room> findById(String id);
    Room save(RoomDto roomDto);
    boolean deleteById(String id);
    Room updateRoom(String id, Room roomDetails);
}
