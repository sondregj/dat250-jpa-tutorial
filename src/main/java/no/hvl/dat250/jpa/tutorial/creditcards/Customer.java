package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<CreditCard> ownedCards = new HashSet<>();

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        address.addOwner(this);
        addresses.add(address);
    }

    public Collection<CreditCard> getCreditCards() {
        return ownedCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        ownedCards.add(creditCard);
    }
}
