package bookingSystem.hotelservice.hotelservice.entities;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Location implements Serializable {
    private String address;
    private String country;
    private String city;
}
