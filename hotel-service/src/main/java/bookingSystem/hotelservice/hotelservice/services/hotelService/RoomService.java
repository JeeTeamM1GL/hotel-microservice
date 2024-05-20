package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.entities.Room;
import bookingSystem.hotelservice.hotelservice.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    private final RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }
    public Room updateRoom(Long id, Room roomDetails) {
        return roomRepository.findById(id).map(hotel -> {
            hotel.setNum_room(roomDetails.getNum_room());
            hotel.setDescription(roomDetails.getDescription());
            hotel.setCapacity(roomDetails.getCapacity());
            hotel.setEquipments(roomDetails.getEquipments());
            return roomRepository.save(hotel);
        }).orElse(null);
    }
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
