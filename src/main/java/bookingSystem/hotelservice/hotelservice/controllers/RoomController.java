package bookingSystem.hotelservice.hotelservice.controllers;


import bookingSystem.hotelservice.hotelservice.dto.RoomDto;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.entities.Room;
import bookingSystem.hotelservice.hotelservice.services.hotelService.IRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private IRoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody RoomDto roomDto) {
        Room savedRoom = roomService.save(roomDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable String id, @RequestBody Room roomDetails) {
        Room updateRoom = roomService.updateRoom(id, roomDetails);
        if (updateRoom != null) {
            return ResponseEntity.ok(updateRoom);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRoom(@PathVariable String id) {
        return ResponseEntity.ok(roomService.deleteById(id));
    }
}
