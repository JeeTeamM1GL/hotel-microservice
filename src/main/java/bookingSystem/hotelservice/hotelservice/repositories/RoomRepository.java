package bookingSystem.hotelservice.hotelservice.repositories;

import bookingSystem.hotelservice.hotelservice.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

}
