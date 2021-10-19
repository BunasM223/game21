package com.test;

import com.test.pack.Card;
import com.test.pack.Pack;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Pack pack = new Pack();
        Scanner sc = new Scanner(System.in);
        int scoreComp = 0;
        int scorePlayer = 0;
        String str = null;
        boolean flagPlayerNext = false;
        boolean flagCompNext = false;
        Random r = new Random();



        pack.shuffle();
        /*for (int i = 0;i < pack.getCards().size();i++) {

            System.out.println("two " + pack.getCards().get(i));

        }*/
        int i = 0;
        for (i = 0;i < pack.getCardPoints().size();i++) {

          if (i == 0 ) {  System.out.println("карты компьюТера: ");}
          if (i == 2 ) {  System.out.println("Ваши карты: ");}

          if (i < 2) {
              scoreComp  += pack.getCardPoints().get(pack.getCards().get(i));
              System.out.println("карта компа "  + pack.getCards().get(i) + " очков "  + scoreComp );
          }
          if ((i >= 2) && (i < 4) ) {
              scorePlayer += pack.getCardPoints().get(pack.getCards().get(i));
              System.out.println("карта игрока "  + pack.getCards().get(i) + " очков "  + scorePlayer );
          }

          if (i >=3 && flagCompNext == false) {
                System.out.println("У Вас " + scorePlayer + " Еще карту? ...Y/N");
                str = sc.nextLine();
          }

          if ("Y".equalsIgnoreCase(str) && i >= 3  && scorePlayer <= 21) {
                flagPlayerNext = true;
                scorePlayer += pack.getCardPoints().get(pack.getCards().get(i));
                System.out.println("Вам выпала карта  - " + pack.getCards().get(i) + "Теперь у вас очков  - " + scorePlayer);
          }else {flagPlayerNext = false;}

          if ("N".equalsIgnoreCase(str) && i >=3) { flagCompNext = true;}

          if (i >=3 && flagCompNext == true) {
                System.out.println("У компа " + scoreComp);
                if (scoreComp <= 21 && r.nextBoolean()) {
                    System.out.println("Он берет ещё карту - " + pack.getCards().get(i));
                    scoreComp  += pack.getCardPoints().get(pack.getCards().get(i));
                    System.out.println("теперь у него " + scoreComp);
                } else flagCompNext = false;

          }

          if (!flagCompNext && !flagPlayerNext && i >=3) {
                if (scoreComp <= 21 && scorePlayer <= 21) {
                    if (scoreComp > scorePlayer) {System.out.println("У компа - " + scoreComp + " у игрока - " + scorePlayer + " - Комп победил!");}
                    else {
                        if (scoreComp < scorePlayer) { System.out.println("У компа - " + scoreComp + " у игрока - " + scorePlayer + " - Игрок победил!");}
                        else {System.out.println("У компа - " + scoreComp + " у игрока - " + scorePlayer + " - Ничья");}
                    }
                    break;
                }
                if (scoreComp > 21 && scorePlayer <= 21) {
                    System.out.println("У компа - " + scoreComp + " у игрока - " + scorePlayer + " - Игрок победил!");
                    break;
                }
                if (scoreComp <= 21 && scorePlayer > 21) {
                    System.out.println("У компа - " + scoreComp + " у игрока - " + scorePlayer + " - Комп победил!");
                    break;
                }
                if (scoreComp > 21 && scorePlayer > 21) {
                    System.out.println("У компа - " + scoreComp + " у игрока - " + scorePlayer + " - Никто нен победил!");
                    break;
                }

          }

        }

        }
}
