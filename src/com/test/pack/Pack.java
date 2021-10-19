package com.test.pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Pack {
    private ArrayList<Card> cards;
    HashMap<Card, Integer> cardPoints = new HashMap<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public HashMap<Card, Integer> getCardPoints() {
        return cardPoints;
    }

    public Pack() {
        cards = new ArrayList<>();
        cardPoints = new HashMap<>();

        int point;
        int i = 0;
        for (Suit suit : Suit.values()) {

            for (Value value: Value.values()) {
                switch (value){

                    case SIX:
                        point = 6;
                        break;
                    case SEVEN:
                        point = 7;
                        break;
                    case EIGHT:
                        point = 8;
                        break;
                    case NINE:
                        point = 9;
                        break;
                    case TEN:
                        point = 10;
                        break;
                    case JACK:
                        point = 2;
                        break;
                    case QUEEN:
                        point = 3;
                        break;
                    case KING:
                        point = 4;
                        break;
                    case ACE:
                        point = 11;
                        break;
                    default:
                        point = 0;
                        break;
                }
                /*cardPoints.put(new Card(suit, value),point);*/
                cards.add(new Card(suit, value));
                cardPoints.put(cards.get(i),point);
                i++;
            }
        }

       /*for (int i = 0;i < cards.size();i++) {
            System.out.println("new " + cards.get(i));
        }*/
        /*for (Card card: cards) {
            System.out.println(card);
        }*/
    }

    public void shuffle() {
        Collections.shuffle(cards);
        /*for (Card card: cards) {
            System.out.println(card);
        }*/
    }

}
