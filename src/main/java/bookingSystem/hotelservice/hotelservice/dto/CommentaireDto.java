package bookingSystem.hotelservice.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentaireDto {
    private String text;
    private String hotelId;
    private String userId;
}
