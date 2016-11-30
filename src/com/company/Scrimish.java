package com.company;

import sun.reflect.Reflection;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

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

    public Pile getPile(int pile) {
        return piles[pile];
    }

    public void autoOperate(String myName, String hisName, Scrimish opponent) throws IOException {
        System.out.println(myName + " is operating!");
        int operate = (int) (Math.random() * 10) + 1;
        int pileNum = (int) (Math.random() * 5) + 1;
        Pile myPile = piles[pileNum];
        Card myCard = myPile.getTopCard();
        if (operate == 1){
            System.out.println(myName + " discard a card from pile" + pileNum);
            piles[pileNum].pop();
            return;
        }else{
            while ( myCard.getType() == 8) {
                pileNum = (int) (Math.random() * 5) + 1;
                myPile = piles[pileNum];
                myCard = myPile.getTopCard();
            }
            System.out.print(myName + " choose a card from pile" + pileNum +
                    " to attack " + hisName + " pile");
            Pile hisPile;
            Card hisCard;
            do{
                pileNum = (int) (Math.random() * 5) + 1;
                hisPile = opponent.getPile(pileNum);
            }while(hisPile.getTop() == 0);
            hisCard = hisPile.getTopCard();
            System.out.println(pileNum);
            System.out.print(myName + " card is " + myCard.getTypeName() + "    ");
            System.out.println(hisName + " card is" + hisCard.getTypeName());

            if (hisCard.getType() == 0){
                System.out.println(myName + " Victory!!!");
                System.in.read();
                System.exit(0);
            }
            switch(myCard.getType()){
                case 0:
                    System.out.println(hisName + " Victory!!!");
                    System.in.read();
                    System.exit(0);
                    break;
                case 7:
                    if (hisCard.getType() == 8){
                        System.out.println("Neither card will be discarded");
                        return;
                    }else
                    {
                        System.out.println(myName + " win!");
                        hisPile.pop();
                    }
                    break;
                default:
                    switch (hisCard.getType()){
                        case 7:
                            System.out.println(myName + " win!");
                            hisPile.pop();
                            break;
                        case 8:
                            System.out.println("Both card will be discarded!");
                            myPile.pop();
                            hisPile.pop();
                            break;
                        default:
                            if (myCard.getType() == hisCard.getType()){
                                System.out.println("Both card will be discarded!");
                                myPile.pop();
                                hisPile.pop();
                            }else{
                                if (myCard.getType() > hisCard.getType()){
                                    System.out.println(myName + " win!");
                                    hisPile.pop();
                                }else
                                {
                                    System.out.println(hisName + " win!");
                                    myPile.pop();
                                }
                            }
                    }
            }
        }
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

    public void printEasyPiles(){
        for (int i=1; i<=5; i++){
            System.out.print("Pile" + i + ": ");
            for (int j=1; j<=piles[i].getTop(); j++){
                System.out.print("# ");
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

    public void autoSetaPile(){
        int crownCard = (int)(Math.random() * 5) + 1;
        piles[crownCard] = new Pile();
        piles[crownCard].push(new Card(0));
        for (int i=1; i<=5; i++){
            int pileNum = 5;
            if (i == crownCard){
                pileNum = 4;
            }
            else{
                piles[i] = new Pile();
            }
            for (int j=0; j<pileNum; j++){
                int card = (int)(Math.random() * 8) + 1;
                if (cardNum[card] == 0){
                    j--;
                    continue;
                }
                cardNum[card]--;
                piles[i].push(new Card(card));
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
