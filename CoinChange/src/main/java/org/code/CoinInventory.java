package org.code;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// 'Bank' class storing our coins where later we will be able to manipulate the type of coins we store
public class CoinInventory {
    private Map<Coin, Integer> inventory;
    private int coinsQuantity;

    public CoinInventory() {
        inventory = new TreeMap<>(Comparator.comparingDouble(Coin::getDenomination).reversed());
        coinsQuantity = 0;
    }

    public void addCoin(Coin coin, int quantity) {
        if (quantity < 0) {
            return;
        }

        int currQuantity = inventory.getOrDefault(coin, 0);
        inventory.put(coin, currQuantity + quantity);
        coinsQuantity += quantity;
    }

    public void takeCoin(Coin coin, int quantity) {
        if (quantity < 0) {
            return;
        }
        int currQuantity = inventory.getOrDefault(coin, 0);
        if (currQuantity == 0) {
            System.out.println("There's no more " + coin.getDenomination() + coin.getCurrency() + " coins!");
        }
        else if (currQuantity - quantity < 0) {
            System.out.println("There's not enough coins in bank. Current quantity of"
                    + coin.getDenomination() + coin.getCurrency() + " is " + currQuantity);
        } else {
            inventory.put(coin, currQuantity - quantity);
            coinsQuantity -= quantity;
        }
    }

    public void printInventory() {
        System.out.println("Current inventory state:");
        for (Coin coin : inventory.keySet()) {
            System.out.println(coin.getDenomination() + " " + coin.getCurrency() + " " + inventory.get(coin));
        }
    }

    public int getCoinsQuantity() {
        return coinsQuantity;
    }

    public Map<Coin, Integer> getInventory() {
        return inventory;
    }
}
