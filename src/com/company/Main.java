package com.company;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws IOException {
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
                sleep(1000);
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
                if ((userPileNum > 5) || (userPileNum < 1)){
                    System.out.println("Error");
                    continue;
                }
                userPile = user.getPile(userPileNum);
                if (userPile.getTop() == 0){
                    System.out.println("There is no card in this pile, please choose again!");
                    continue;
                }
                userCard = userPile.getTopCard();

                System.out.print("Please input operation 1.attack  2.discard: ");
                operation = in.nextInt();
                if (operation == 2){
                    if (userCard.getType()==0){
                        System.out.println("Crown Card cannot be discarded!");
                        continue;
                    }
                    userPile.pop();
                    computer.autoOperate("Computer", "You", user);
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
            //operation == 1 ( attack!!! )
            Pile computerPile;
            Card computerCard;
            int computerPileNum;
            while (true){
                System.out.print("Please choose a card form a pile of computer to attack: ");
                computerPileNum = in.nextInt();
                if ((computerPileNum > 5) || (computerPileNum < 1)){
                    System.out.println("Error!");
                    continue;
                }
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
            if (computerCard.getType() == 0){
                System.out.println("You Victory!!!");
                System.in.read();
                System.exit(0);
            }
            switch (userCard.getType()){
                case 0:
                    System.out.println("Computer Victory!!!");
                    System.in.read();
                    System.exit(0);
                case 7:
                    if (computerCard.getType() == 8){
                        System.out.println("Neither card will be discarded");
                        continue;
                    }else
                    {
                        System.out.println("You win!");
                        computerPile.pop();
                    }
                    break;
                default:
                    switch (computerCard.getType()){
                        case 7:
                            System.out.println("You win!");
                            computerPile.pop();
                            break;
                        case 8:
                            System.out.println("Both card will be discarded!");
                            computerPile.pop();
                            userPile.pop();
                            break;
                        default:
                            if (userCard.getType() == computerCard.getType()){
                                System.out.println("Both card will be discarded!");
                                computerPile.pop();
                                userPile.pop();
                            }else
                                if (userCard.getType() > computerCard.getType()){
                                    System.out.println("You win!");
                                    computerPile.pop();
                                }else{
                                    System.out.println("You lose");
                                    userPile.pop();
                                }
                    }
            }
            computer.autoOperate("Computer", "You", user);
            System.in.read();
        }

    }

    public static void newPage(){
        for (int i=0; i<20; i++)
            System.out.println();
    }

}

