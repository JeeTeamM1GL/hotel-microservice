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
@Table(name = "rooms")

public class Room implements Serializable {
    @Id
    private String id;
    @Column(unique = true)
    private String num_room;
    @Enumerated(EnumType.STRING)
    private RoomType room_type;
    private double price_per_night;
    private String capacity;
    private String description;
    private boolean is_available;
    @ElementCollection
    private List<String> images;
    private int etage;
    @ElementCollection
    private List<String> equipments;
    private Double surface;
    private Instant createdAt;
    private Instant updatedAt;
    private String hotelId;
//    @ManyToOne
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
}
