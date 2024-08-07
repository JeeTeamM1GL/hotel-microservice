package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(Long id);
    Hotel save(Hotel hotel);
    void deleteById(Long id);
    Hotel updateHotel(Long id, Hotel hotelDetails);
}
