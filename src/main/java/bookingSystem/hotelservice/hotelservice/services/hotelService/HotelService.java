package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.core.utils.IDGenerate;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService implements IHotelService {
    private final HotelRepository hotelRepository;
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> findById(String id) {
        return hotelRepository.findById(id);
    }

    public Hotel save(Hotel hotel) {
        hotel.setId(IDGenerate.generate("HTL"));
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(String id, Hotel hotelDetails) {
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setName(hotelDetails.getName());
            hotel.setDescription(hotelDetails.getDescription());
            hotel.setRooms_count(hotelDetails.getRooms_count());
            hotel.setCover(hotelDetails.getCover());
            return hotelRepository.save(hotel);
        }).orElse(null);
    }
    public Boolean deleteById(String id) {
        try {
            hotelRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }
}
