package bookingSystem.hotelservice.hotelservice.repositories;

import bookingSystem.hotelservice.hotelservice.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
