package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getStreet() {
        // TODO: implement method!
        return null;
    }

    public Integer getNumber() {
        // TODO: implement method!
        return null;
    }

    public Collection<Customer> getOwners() {
        // TODO: implement method!
        return null;
    }
}
