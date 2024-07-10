package bookingSystem.hotelservice.hotelservice.dto;
import bookingSystem.hotelservice.hotelservice.entities.Location;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDto implements Serializable {
    private String name;
    private Location location;
    private int rooms_count;
    private String description;
    private String cover;
    private List<String> images;
    private String gps_coordinate;
}
