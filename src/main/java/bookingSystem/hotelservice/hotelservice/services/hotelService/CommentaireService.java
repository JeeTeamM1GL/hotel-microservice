package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Commentaire;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.repositories.CommentaireRepository;
import bookingSystem.hotelservice.hotelservice.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentaireService implements ICommentaireService{
    private final CommentaireRepository commentaireRepository;

    public List<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }
    public Commentaire save(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Commentaire findById(String id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        commentaireRepository.deleteById(id);
    }

    public Commentaire update(String id, Commentaire updatedCommentaire) {
        return commentaireRepository.findById(id).map(commentaire -> {
            commentaire.setText(updatedCommentaire.getText());
            commentaire.setUpdatedAt(updatedCommentaire.getUpdatedAt());
            commentaire.setHotel(updatedCommentaire.getHotel());
            return commentaireRepository.save(commentaire);
        }).orElse(null);
    }
}
