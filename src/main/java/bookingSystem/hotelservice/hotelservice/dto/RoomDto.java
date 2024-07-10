package bookingSystem.hotelservice.hotelservice.dto;
import bookingSystem.hotelservice.hotelservice.entities.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private String num_room;
    private RoomType room_type;
    private double price_per_night;
    private String capacity;
    private String description;
    private boolean is_available;
    private List<String> images;
    private int etage;
    private List<String> equipments;
    private Double surface;
    private String hotelId;
}
