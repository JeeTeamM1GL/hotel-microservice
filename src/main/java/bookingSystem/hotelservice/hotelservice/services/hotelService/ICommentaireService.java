package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.dto.CommentaireDto;
import bookingSystem.hotelservice.hotelservice.entities.Commentaire;

import java.util.List;

public interface ICommentaireService {
    Commentaire save(CommentaireDto commentaireDto);
    //List<Commentaire> findAll();
    List<Commentaire> findByHotelId(String hotelId);
    //Commentaire findById(String id);
    //Commentaire update(String id, Commentaire updatedCommentaire);
    boolean deleteById(String id);
}
