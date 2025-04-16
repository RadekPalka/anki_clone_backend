package pl.radekpalka.anki_clone.anki_clone_backend.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.radekpalka.anki_clone.anki_clone_backend.model.Deck;
import pl.radekpalka.anki_clone.anki_clone_backend.model.Flashcard;
import pl.radekpalka.anki_clone.anki_clone_backend.repository.DeckRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final DeckRepository deckRepository;

    public DataLoader(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @Override
    public void run(String... args) {
        if (!deckRepository.existsByTitle("PL-ENG Animals")){
            Deck deck = new Deck();
            deck.setTitle("PL-ENG Animals");
            deck.setAuthor("Official");

            List<Flashcard> flashcards = List.of(
                    new Flashcard("pies", "dog", deck),
                    new Flashcard("kot", "cat", deck),
                    new Flashcard("koń", "horse", deck),
                    new Flashcard("krowa", "cow", deck),
                    new Flashcard("świnia", "pig", deck),
                    new Flashcard("kura", "chicken", deck),
                    new Flashcard("owieczka", "sheep", deck),
                    new Flashcard("kaczka", "duck", deck),
                    new Flashcard("mysz", "mouse", deck),
                    new Flashcard("ptak", "bird", deck)
            );

            deck.setFlashcards(flashcards);

            deckRepository.save(deck);

            System.out.println("📦 Deck 'PL-ENG Animals' with 10 flashcards added to the database!");
        }
    }
}
