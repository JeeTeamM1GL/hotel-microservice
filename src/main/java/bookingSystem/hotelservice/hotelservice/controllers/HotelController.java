package bookingSystem.hotelservice.hotelservice.controllers;

import bookingSystem.hotelservice.hotelservice.dto.HotelDto;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.services.hotelService.IHotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {
    private IHotelService hotelService;

    //@CrossOrigin("*")
    @GetMapping
    public ResponseEntity< List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hotel>> findHotelById(@PathVariable String id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelDto hotelDto) {
        Hotel savedHotel = hotelService.save(hotelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String id, @RequestBody Hotel hotelDetails) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelDetails);
        if (updatedHotel != null) {
            return ResponseEntity.ok(updatedHotel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteHotel(@PathVariable String id) {
        return ResponseEntity.ok(hotelService.deleteById(id));
    }

}
