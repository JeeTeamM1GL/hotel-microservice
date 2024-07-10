package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.core.utils.IDGenerate;
import bookingSystem.hotelservice.hotelservice.dto.RoomDto;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.entities.Room;
import bookingSystem.hotelservice.hotelservice.repositories.HotelRepository;
import bookingSystem.hotelservice.hotelservice.repositories.RoomRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {
    @Autowired
    private final RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findById(String id) {
        return roomRepository.findById(id);
    }

    public Room save(RoomDto roomDto) {
        Room room = Room.builder()
                .id(IDGenerate.generate("ROOM"))
                .num_room(roomDto.getNum_room())
                .room_type(roomDto.getRoom_type())
                .price_per_night(roomDto.getPrice_per_night())
                .capacity(roomDto.getCapacity())
                .description(roomDto.getDescription())
                .is_available(roomDto.is_available())
                .images(roomDto.getImages())
                .etage(roomDto.getEtage())
                .equipments(roomDto.getEquipments())
                .surface(roomDto.getSurface())
                .hotelId(roomDto.getHotelId())
                .createdAt(Instant.now())
                .build();
        return roomRepository.save(room);
    }
    public Room updateRoom(String id, Room roomDetails) {
        return roomRepository.findById(id).map(hotel -> {
            hotel.setNum_room(roomDetails.getNum_room());
            hotel.setPrice_per_night(roomDetails.getPrice_per_night());
            hotel.setDescription(roomDetails.getDescription());
            hotel.setCapacity(roomDetails.getCapacity());
            hotel.setEquipments(roomDetails.getEquipments());
            hotel.set_available(roomDetails.is_available());
            hotel.setImages(roomDetails.getImages());
            hotel.setEtage(roomDetails.getEtage());
            hotel.setSurface(roomDetails.getSurface());
            hotel.setRoom_type(roomDetails.getRoom_type());
            hotel.setHotelId(roomDetails.getHotelId());
            hotel.setUpdatedAt(Instant.now());
            return roomRepository.save(hotel);
        }).orElse(null);
    }
    public boolean deleteById(String id) {
        try {
            roomRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


}
