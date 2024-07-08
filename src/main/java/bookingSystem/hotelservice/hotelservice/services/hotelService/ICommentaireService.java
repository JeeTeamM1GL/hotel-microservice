package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Commentaire;

import java.util.List;

public interface ICommentaireService {
    Commentaire save(Commentaire commentaire);
    List<Commentaire> findAll();
    Commentaire findById(String id);
    void deleteById(String id);
    Commentaire update(String id, Commentaire updatedCommentaire);
}
