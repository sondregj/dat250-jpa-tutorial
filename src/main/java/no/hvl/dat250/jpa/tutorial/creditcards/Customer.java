package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        // TODO: implement method!
        return null;
    }

    public Collection<Address> getAddresses() {
        // TODO: implement method!
        return null;
    }

    public Collection<CreditCard> getCreditCards() {
        // TODO: implement method!
        return null;
    }
}
