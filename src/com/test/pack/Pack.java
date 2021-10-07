package com.test.pack;

import java.util.ArrayList;
import java.util.Collections;

public class Pack {
    private ArrayList<Card> cards;

    public Pack() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Value value: Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
        for (Card card: cards) {
            System.out.println(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        for (Card card: cards) {
            System.out.println(card);
        }
    }
}
