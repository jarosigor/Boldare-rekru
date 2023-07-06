package org.code;

import java.lang.invoke.LambdaMetafactory;
import java.util.Scanner;

public class CoinChange {

    public static void getChange(CoinInventory bank, double change) {
        double changeLeft = change;

        for (Coin coin : bank.getInventory().keySet()) {
            Double num = changeLeft / coin.getDenomination();
            int amountLeft = bank.getInventory().get(coin);
            if (num.intValue() > 0) {
                if (num.intValue() <= amountLeft) {
                    changeLeft -= coin.getDenomination() * num;
                    bank.takeCoin(coin, num.intValue());
                    System.out.println("Wydaj " + num.intValue() + " monet "
                            + coin.getDenomination() + coin.getCurrency());
                } else {
                    changeLeft -= coin.getDenomination() * amountLeft;
                    bank.takeCoin(coin, amountLeft);
                    System.out.println("Wydaj " + amountLeft + " monet "
                            + coin.getDenomination() + coin.getCurrency());
                }
            }

            if (changeLeft == 0.0) {
                System.out.println("Udalo sie wydac reszte");
                return;
            }
        }
        System.out.println("Nie udalo sie wydac reszty");
    }
    public static void run() {
        Coin grosz = new Coin(0.01, "PLN");
        Coin dwaGrosze = new Coin(0.02, "PLN");
        Coin piecGroszy = new Coin(0.05, "PLN");
        Coin dziesiecGroszy = new Coin(0.1, "PLN");
        Coin dwadzeisciaGroszy = new Coin(0.2, "PLN");
        Coin piedziesiatGroszy = new Coin(0.5, "PLN");
        Coin zlotowka = new Coin(1, "PLN");
        Coin dwaZlote = new Coin(2, "PLN");
        Coin piecZloty = new Coin(5, "PLN");

        CoinInventory bank = new CoinInventory();
        bank.addCoin(grosz, 10000);
        bank.addCoin(dwaGrosze, 100);
        bank.addCoin(piecGroszy, 100);
        bank.addCoin(dziesiecGroszy, 200);
        bank.addCoin(dwadzeisciaGroszy, 20);
        bank.addCoin(piedziesiatGroszy, 10);
        bank.addCoin(zlotowka, 5);
        bank.addCoin(dwaZlote, 3);
        bank.addCoin(piecZloty, 1);
        bank.printInventory();

        Scanner scanner = new Scanner(System.in);
        double change = 0;
        while (bank.getCoinsQuantity() > 0) {
            System.out.println("Podaj reszte: ");
            change = scanner.nextDouble();
            getChange(bank, change);

            if (bank.getCoinsQuantity() <= 0) {
                System.out.println("Bank jest pusty.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        run();
    }
}