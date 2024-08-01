package bookingSystem.hotelservice.hotelservice.controllers;

import bookingSystem.hotelservice.hotelservice.dto.CommentaireDto;
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
@RequestMapping("/api/v1/commentaires")
@CrossOrigin("*")
public class CommentaireController {
    private ICommentaireService commentaireService;

    @PostMapping("/public")
    public ResponseEntity<Commentaire> createCommentaireForPublic(@RequestBody CommentaireDto commentaireDto) {
        Commentaire savedCommentaire = commentaireService.save(commentaireDto);
        return ResponseEntity.ok(savedCommentaire);
    }

//    @GetMapping
//    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
//        List<Commentaire> commentaires = commentaireService.findAll();
//        return ResponseEntity.ok(commentaires);
//    }

    @GetMapping("/public/{id}")
    public ResponseEntity<List<Commentaire>> getCommentairesByHotelForPublic(@PathVariable String id) {
        List<Commentaire> commentaires = commentaireService.findByHotelId(id);
        return ResponseEntity.ok(commentaires);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable String id) {
//        Commentaire commentaire = commentaireService.findById(id);
//        if (commentaire != null) {
//            return ResponseEntity.ok(commentaire);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable String id, @RequestBody Commentaire commentaire) {
//        Commentaire updatedCommentaire = commentaireService.update(id, commentaire);
//        if (updatedCommentaire != null) {
//            return ResponseEntity.ok(updatedCommentaire);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/public/{id}")
    public ResponseEntity<Boolean> deleteCommentaireForPublic(@PathVariable String id) {
        return ResponseEntity.ok(commentaireService.deleteById(id));
    }


}
