package com.company;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        Scrimish user = new Scrimish();
        Scrimish computer = new Scrimish();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Scrimish Game!");
        System.out.println("Now, you can set your cards by input 1~6, A, S or C." +
                "   Caution! Crown Card must be hidden on the bottom of one of the 5 piles!");
        while (true) {
//            user.init();
//            System.out.println("Please input your first pile of cards(from bottom to top): ");
//            user.createaPile(1);
//            System.out.println("Please input your second pile of cards(from bottom to top): ");
//            user.createaPile(2);
//            System.out.println("Please input your third pile of cards(from bottom to top): ");
//            user.createaPile(3);
//            System.out.println("Please input your fourth pile of cards(from bottom to top): ");
//            user.createaPile(4);
//            System.out.println("Please input your fifth pile of cards(from bottom to top): ");
//            user.createaPile(5);
//            System.out.println();
//            if (!user.checkCardNum()){
//                System.out.println("Card Num Error! Please reset your cards!");
//                continue;
//            }
            user.autoSetaPile();        //!!!!!!!!! 临时测试 !!!!!!!!!!

            user.printPiles();
            System.out.println("Now, please check your cards, if there is no problem, input \"Y\", else input \"N\": ");
            if (in.nextLine().toUpperCase().equals("Y"))
                break;
        }
        computer.autoSetaPile();
        //computer.printPiles();
        System.out.println("OK! Computer has already set the cards. Let's begin to fight!");


        // Begin Fight!!!
        // boolean operateDone = false;
        while (true) {
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            newPage();
            System.out.println("Your Scrimish:");
            user.printPiles();
            System.out.println("Computer's Scrimish");
            //computer.printEasyPiles();
            computer.printPiles();

            Pile userPile;
            int userPileNum;
            Card userCard;
            int operation;
            while (true){
                System.out.print("Now, please choose a card from a pile(1~5): ");
                userPileNum = in.nextInt();
                userPile = user.getPile(userPileNum);
                if (userPile.getTop() == 0){
                    System.out.println("There is no card in this pile, please choose again!");
                    continue;
                }
                userCard = userPile.getTopCard();

                System.out.print("Please input operation 1、attack  2、discard: ");
                operation = in.nextInt();
                if (operation == 2){
                    if (userCard.getType()==0){
                        System.out.println("Crown Card cannot be discarded!");
                        continue;
                    }
                    userPile.pop();
                    computer.autoOperate();
                    break;
                }
                if (operation != 1){
                    System.out.println("Operation number wrong!");
                    continue;
                }
                if (userCard.getType() == 8){
                    System.out.println("ShieldCard cannot be used to attack!" +
                            " Please choose again!");
                    continue;
                }
                break;
            }

            if (operation == 2){
                continue;
            }

            Pile computerPile;
            Card computerCard;
            int computerPileNum;
            while (true){
                System.out.print("Please choose a card form a pile of computer to attack: ");
                computerPileNum = in.nextInt();
                computerPile = computer.getPile(computerPileNum);
                if (computerPile.getTop() == 0){
                    System.out.println("There is no card in this pile, please choose again!");
                    continue;
                }
                computerCard = computerPile.getTopCard();
                break;
            }

            System.out.print("Your card is " + userCard.getTypeName() + "    ");
            System.out.println("Computer's card is "+computerCard.getTypeName());

        }

    }

    public static void newPage(){
        for (int i=0; i<20; i++)
            System.out.println();
    }

}

