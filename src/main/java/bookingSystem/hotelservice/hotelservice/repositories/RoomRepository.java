package bookingSystem.hotelservice.hotelservice.repositories;

import bookingSystem.hotelservice.hotelservice.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findRoomsByHotelId(String hotelId);
}
