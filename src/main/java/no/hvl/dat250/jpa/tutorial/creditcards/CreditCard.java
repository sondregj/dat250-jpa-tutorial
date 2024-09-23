package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Bank owningBank;

    public CreditCard() {}

    public CreditCard(
        Integer number,
        Integer balance,
        Integer creditLimit,
        Pincode pincode
    ) {
        this.number = number;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.pincode = pincode;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }

    public void setOwningBank(Bank bank) {
        owningBank = bank;
    }
}
