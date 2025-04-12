package pl.radekpalka.anki_clone.anki_clone_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Flashcard {

    public Flashcard() {
    }

    public Flashcard(String front, String back, Deck deck){
        this.front = front;
        this.back = back;
        this.deck = deck;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String front;
    private String back;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonIgnore
    private Deck deck;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
