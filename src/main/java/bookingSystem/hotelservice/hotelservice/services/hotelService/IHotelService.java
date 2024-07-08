package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(String id);
    Hotel save(Hotel hotel);
    Boolean deleteById(String id);
    Hotel updateHotel(String id, Hotel hotelDetails);
}
