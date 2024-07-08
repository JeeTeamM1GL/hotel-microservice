package bookingSystem.hotelservice.hotelservice.entities;

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
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String text;
    private Instant createdAt;
    private Instant updatedAt;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
