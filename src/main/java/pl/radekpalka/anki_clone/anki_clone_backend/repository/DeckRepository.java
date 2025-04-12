package pl.radekpalka.anki_clone.anki_clone_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radekpalka.anki_clone.anki_clone_backend.model.Deck;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findByAuthor(String author);
}
