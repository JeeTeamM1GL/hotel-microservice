package bookingSystem.hotelservice.hotelservice.controllers;

import bookingSystem.hotelservice.hotelservice.entities.Commentaire;
import bookingSystem.hotelservice.hotelservice.services.hotelService.CommentaireService;
import bookingSystem.hotelservice.hotelservice.services.hotelService.ICommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.Instant;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/commentaires")
public class CommentaireController {
    private ICommentaireService commentaireService;

    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        commentaire.setCreatedAt(Instant.now());
        commentaire.setUpdatedAt(Instant.now());
        Commentaire savedCommentaire = commentaireService.save(commentaire);
        return ResponseEntity.ok(savedCommentaire);
    }

    @GetMapping
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireService.findAll();
        return ResponseEntity.ok(commentaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        Commentaire commentaire = commentaireService.findById(id);
        if (commentaire != null) {
            return ResponseEntity.ok(commentaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        commentaire.setUpdatedAt(Instant.now());
        Commentaire updatedCommentaire = commentaireService.update(id, commentaire);
        if (updatedCommentaire != null) {
            return ResponseEntity.ok(updatedCommentaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
