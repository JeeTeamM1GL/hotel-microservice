package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.dto.HotelDto;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface IHotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(String id);
    Hotel save(HotelDto hotelDto);
    Boolean deleteById(String id);
    Hotel updateHotel(String id, Hotel hotelDetails);
}
