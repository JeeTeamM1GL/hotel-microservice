package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.clients.UserRestClient;
import bookingSystem.hotelservice.hotelservice.core.utils.IDGenerate;
import bookingSystem.hotelservice.hotelservice.dto.CommentaireDto;
import bookingSystem.hotelservice.hotelservice.entities.Commentaire;
import bookingSystem.hotelservice.hotelservice.entities.Hotel;
import bookingSystem.hotelservice.hotelservice.repositories.CommentaireRepository;
import bookingSystem.hotelservice.hotelservice.repositories.HotelRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentaireService implements ICommentaireService{
    @Autowired
    private final CommentaireRepository commentaireRepository;
    @Autowired
    private final UserRestClient client;

    // La liste des commentaire par chaque hotel
    public List<Commentaire> findByHotelId(String hotelId) {
        var list = commentaireRepository.findByHotelId(hotelId);

        list.forEach(c-> {
            var user = client.findUserById(c.getUserId());
            c.setUser(user);
        });
        return list;
    }

    // Enregistrement d'un commentaire
    public Commentaire save(CommentaireDto commentaireDto) {
        Commentaire commentaire = Commentaire.builder()
                .id(IDGenerate.generate("COM"))
                .text(commentaireDto.getText())
                .hotelId(commentaireDto.getHotelId())
                .userId(commentaireDto.getUserId())
                .createdAt(Instant.now())
                .build();
        return commentaireRepository.save(commentaire);
    }

//    public Commentaire findById(String id) {
//        return commentaireRepository.findById(id).orElse(null);
//    }

//    public Commentaire update(String id, Commentaire updatedCommentaire) {
//        return commentaireRepository.findById(id).map(commentaire -> {
//            commentaire.setText(updatedCommentaire.getText());
//            commentaire.setUpdatedAt(updatedCommentaire.getUpdatedAt());
//            commentaire.setHotelId(updatedCommentaire.getHotelId());
//            return commentaireRepository.save(commentaire);
//        }).orElse(null);
//    }


    //Suppression d'un commentaire
    public boolean deleteById(String id) {
        try {
            commentaireRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
