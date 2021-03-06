package com.company;

/**
 * Created by zhang on 2016/11/29.
 */
public class Pile {
    private int top;
    private Card[] pileCard;

    public Card getTopCard(){
        return pileCard[top];
    }

    public Card[] getPileCard() {
        Card[] cards = new Card[10];
        for (int i=1; i<=top; i++)
            cards[i] = pileCard[i];
        return cards;
    }

    public int getTop() {
        return top;
    }

    public Pile(){
        pileCard = new Card[10];
        top = 0;
    }

    public void push(Card card){
        top++;
        pileCard[top] = card;
    }

    public Card pop()
    {
        top--;
        return pileCard[top+1];
    }
}
