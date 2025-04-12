package pl.radekpalka.anki_clone.anki_clone_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.radekpalka.anki_clone.anki_clone_backend.model.Deck;
import pl.radekpalka.anki_clone.anki_clone_backend.repository.DeckRepository;

import java.util.List;

@RestController
@RequestMapping("/api/decks")
public class DeckController {
    private final DeckRepository deckRepository;

    public DeckController(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @GetMapping
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    @GetMapping("/official")
    public List<Deck> getOfficialDecks() {
        return deckRepository.findByAuthor("Official");
    }

    @GetMapping("/{id}")
    public Deck getDeckById(@PathVariable Long id) {
        return deckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deck not found"));
    }
}
