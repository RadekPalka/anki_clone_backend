package pl.radekpalka.anki_clone.anki_clone_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.radekpalka.anki_clone.anki_clone_backend.model.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
}