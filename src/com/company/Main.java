package com.company;

import java.util.Scanner;

import static com.company.cardEnum.DaggerCard;
import static com.company.cardEnum.SwordCard;


public class Main {

    public static void main(String[] args) {
        Scrimish user = new Scrimish();
        Scrimish computer = new Scrimish();
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Scrimish Game!\n");
        System.out.println("Now, you can set your cards by input 1~6, A, S or C.\n" +
                "   Caution! Crown Card must be hidden on the bottom of one of the 5 piles!");
        while (true) {
            System.out.println("Please input your first pile of cards(from bottom to top): ");
            user.createaPile(1);
            System.out.println("Please input your second pile of cards(from bottom to top): ");
            user.createaPile(2);
            System.out.println("Please input your third pile of cards(from bottom to top): ");
            user.createaPile(3);
            System.out.println("Please input your fourth pile of cards(from bottom to top): ");
            user.createaPile(4);
            System.out.println("Please input your fifth pile of cards(from bottom to top): ");
            user.createaPile(5);
            System.out.println("Now, please check your cards, if there is no problem, input \"Y\", else input \"N\": ");
            if (in.nextLine().equals("Y"))
                break;
        }
        System.out.println("OK! Computer has already set the cards. Let's begin to fight!\n");
    }
}

