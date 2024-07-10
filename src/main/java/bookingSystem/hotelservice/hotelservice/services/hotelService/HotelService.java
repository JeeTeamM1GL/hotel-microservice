package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.core.utils.IDGenerate;
import bookingSystem.hotelservice.hotelservice.dto.HotelDto;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.entities.Location;
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

    public Hotel save(HotelDto hotelDto) {
        try {
            Location location = Location.builder()
                    .city(hotelDto.getLocation().getCity())
                    .country(hotelDto.getLocation().getCountry())
                    .address(hotelDto.getLocation().getAddress())
                    .build();

            Hotel hotel = Hotel.builder()
                    .id(IDGenerate.generate("HTL"))
                    .name(hotelDto.getName())
                    .cover(hotelDto.getCover())
                    .location(location)
                    .description(hotelDto.getDescription())
                    .gps_coordinate(hotelDto.getGps_coordinate())
                    .rooms_count(hotelDto.getRooms_count())
                    .images(hotelDto.getImages())
                    .createdAt(Instant.now())
                    .build();

            return hotelRepository.save(hotel);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public Hotel updateHotel(String id, Hotel hotelDetails) {
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setName(hotelDetails.getName());
            hotel.setDescription(hotelDetails.getDescription());
            hotel.setRooms_count(hotelDetails.getRooms_count());
            hotel.setCover(hotelDetails.getCover());
            hotel.setUpdatedAt(Instant.now());
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
