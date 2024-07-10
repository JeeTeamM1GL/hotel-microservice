package bookingSystem.hotelservice.hotelservice.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotels")
public class Hotel implements Serializable {
    @Id
    private String id;
    @Column(nullable = false, unique = true)
    private String name;
    private Location location;
    private int rooms_count;
    private String description;
    private String cover;
    @ElementCollection
    private List<String> images;
    private String gps_coordinate;
    private Instant createdAt;
    private Instant updatedAt;
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Room> rooms;
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Commentaire> commentaires;
}
