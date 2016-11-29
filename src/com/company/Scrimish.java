package com.company;

import java.util.Scanner;

/**
 * Created by zhang on 2016/11/29.
 */
public class Scrimish {
    private Pile[] piles = new Pile[10];
    private int[] cardNum = new int[10];
    private int[] cardNumBackup = new int[10];

    public Scrimish(){
        cardNum[1] = 5;
        cardNum[2] = 5;
        cardNum[3] = 3;
        cardNum[4] = 3;
        cardNum[5] = 2;
        cardNum[6] = 2;
        cardNum[7] = 2;
        cardNum[8] = 2;
        cardNum[0] = 1;
    }

    public void init(){
        cardNum[1] = 5;
        cardNum[2] = 5;
        cardNum[3] = 3;
        cardNum[4] = 3;
        cardNum[5] = 2;
        cardNum[6] = 2;
        cardNum[7] = 2;
        cardNum[8] = 2;
        cardNum[0] = 1;
    }

    public void printPiles(){
        for (int i=1; i<=5; i++){
            System.out.print("Pile" + i + ": ");
            Card[] cards = piles[i].getPileCard();
            for (int j=1; j<=piles[i].getTop(); j++){
                switch (cards[j].getType()){
                    case 7:
                        System.out.print("A ");
                        break;
                    case 8:
                        System.out.print("S ");
                        break;
                    case 0:
                        System.out.print("C ");
                        break;
                    default:
                        System.out.print(cards[j].getType() + " ");
                }
            }
            System.out.println();
        }
    }

    public void createaPile(int num){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //in.close();
        String[] cardType = str.split(" ");
        if (cardType.length != 5){
            System.out.println("Format Error! Please input this pile again: ");
            createaPile(num);
            return;
        }
        piles[num] = new Pile();
        for (int i=0; i<9; i++){
            cardNumBackup[i] = cardNum[i];
        }
        for (int i=0; i<5; i++) {
            switch (cardType[i].toUpperCase()){
                case "A":
                    cardNum[7]--;
                    piles[num].push(new Card(7));
                    break;
                case "S":
                    cardNum[8]--;
                    piles[num].push(new Card(8));
                    break;
                case "C":
                    if (i != 0){
                        System.out.println("CrownCard must be the last card of a pile! " +
                                "Please input this pile again: ");
                        for (int j=0; j<9; j++){
                            cardNum[j] = cardNumBackup[j];
                        }
                        createaPile(num);
                        return;
                    }
                    cardNum[0]--;
                    piles[num].push(new Card(0));
                    break;
                case "1":
                    cardNum[1]--;
                    piles[num].push(new Card(1));
                    break;
                case "2":
                    cardNum[2]--;
                    piles[num].push(new Card(2));
                    break;
                case "3":
                    cardNum[3]--;
                    piles[num].push(new Card(3));
                    break;
                case "4":
                    cardNum[4]--;
                    piles[num].push(new Card(4));
                    break;
                case "5":
                    cardNum[5]--;
                    piles[num].push(new Card(5));
                    break;
                case "6":
                    cardNum[6]--;
                    piles[num].push(new Card(6));
                    break;
                default:
                    System.out.println("Card Type Error! Please input this pile again: ");
                    for (int j=0; j<9; j++){
                        cardNum[j] = cardNumBackup[j];
                    }
                    createaPile(num);
                    return;
            }

        }

    }
    public boolean checkCardNum(){
        for (int i=0; i<9; i++){
            if (cardNum[i] < 0){
                return false;
            }
        }
        return true;
    }
}
