package bookingSystem.hotelservice.hotelservice.services.hotelService;

import bookingSystem.hotelservice.hotelservice.entities.Commentaire;

import java.util.List;

public interface ICommentaireService {
    Commentaire save(Commentaire commentaire);
    List<Commentaire> findAll();
    Commentaire findById(Long id);
    void deleteById(Long id);
    Commentaire update(Long id, Commentaire updatedCommentaire);
}
