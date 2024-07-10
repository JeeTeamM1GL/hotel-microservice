package bookingSystem.hotelservice.hotelservice.entities;

import bookingSystem.hotelservice.hotelservice.clients.User;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "commentaires")

public class Commentaire implements Serializable {
    @Id
    private String id;
    private String text;
    private Instant createdAt;
    private Instant updatedAt;
    private String hotelId;
    private String userId;
    private User user;
//    @ManyToOne
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
}
