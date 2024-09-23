package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owningBank", cascade = CascadeType.ALL)
    private Set<CreditCard> ownedCards = new HashSet<>();

    public Bank() {}

    public Bank(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void addOwnedCard(CreditCard card) {
        ownedCards.add(card);
        card.setOwningBank(this);
    }
}
