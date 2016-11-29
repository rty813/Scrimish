package com.company;

import java.util.Scanner;

/**
 * Created by zhang on 2016/11/29.
 */
public class Scrimish {
    private Pile[] piles = new Pile[10];

    public void printPiles(){
        for (int i=1; i<=5; i++){
            System.out.println("Pile" + i + ":");
            Card[] cards = piles[i].getPileCard();
            for (int j=1; j<=piles[i].getTop(); j++){
                switch (cards[j].getType()){
                    case 7:
                        System.out.println("A ");
                        break;
                    case 8:
                        System.out.println("S ");
                        break;
                    case 0:
                        System.out.println("C ");
                        break;
                    default:
                        System.out.println(cards[j].getType() + " ");
                }
            }
            System.out.println("\n");
        }
    }

    public void createaPile(int num){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] cardType = str.split(" ");
        if (cardType.length != 5){
            System.out.println("Error! Please input a pile in one line!\n");
            createaPile(num);
            return;
        }
        
    }
}
