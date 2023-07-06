package org.code;

public class Coin {
    private double denomination;
    private String currency;

    public Coin(double denomination, String currency) {
        this.denomination = denomination;
        this.currency = currency;
    }

    public double getDenomination() {
        return denomination;
    }

    public String getCurrency() {
        return currency;
    }
}
