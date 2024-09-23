package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

    static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

    public static void main(String[] args) {
        try (
            EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager()
        ) {
            em.getTransaction().begin();
            createObjects(em);
            em.getTransaction().commit();
        }
    }

    private static void createObjects(EntityManager em) {
        Address address = new Address("Inndalsveien", 28);

        Pincode pincode = new Pincode("123", 1);

        CreditCard creditCard1 = new CreditCard(12345, -5000, -10000, pincode);
        CreditCard creditCard2 = new CreditCard(123, 1, 2000, pincode);

        Bank bank = new Bank("Pengebank");
        bank.addOwnedCard(creditCard1);
        bank.addOwnedCard(creditCard2);

        Customer customer = new Customer("Max Mustermann");
        customer.addAddress(address);
        customer.addCreditCard(creditCard1);
        customer.addCreditCard(creditCard2);

        em.persist(address);
        em.persist(pincode);
        em.persist(creditCard1);
        em.persist(creditCard2);
        em.persist(bank);
        em.persist(customer);
    }
}
