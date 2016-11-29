package com.company;

/**
 * Created by zhang on 2016/11/29.
 */

enum cardEnum{
    DaggerCard, SwordCard, MorningStarCard, WarAxeCard,
    HalberdCard, LongswordCard, ArcherCard, ShieldCard, CrownCard
}
enum normalCardEnum{
    DaggerCard, SwordCard, MorningStarCard, WarAxeCard,
    HalberdCard, LongswordCard
}
enum specialCardEnum{
    ArcherCard, ShieldCard, CrownCard
}

public class Card {

    private int type;
    public Card(int atype){
        type = atype;
    }

    public int getType() {
        return type;
    }


    //    private cardEnum type;
//    public Card(cardEnum type)
//    {
//        this.type = type;
//    }
//    public cardEnum getType(){
//        return type;
//    }
//
//    public static int normalCompare(Card card1, Card card2)
//    {
//        cardEnum type1 = card1.getType();
//        cardEnum type2 = card2.getType();
//        if (type1 == type2)
//            return 0;
//        if (type1 == cardEnum.DaggerCard)
//            return -1;
//        if (type2 == cardEnum.DaggerCard)
//            return 1;
//        if (type1 == cardEnum.LongswordCard)
//            return 1;
//        if (type2 == cardEnum.LongswordCard)
//            return -1;
//        if (type1 == cardEnum.SwordCard)
//            return -1;
//        if (type2 == cardEnum.SwordCard)
//            return 1;
//        if (type1 == cardEnum.MorningStarCard)
//            return -1;
//        if (type2 == cardEnum.MorningStarCard)
//            return 1;
//        if (type1 == cardEnum.WarAxeCard)
//            return -1;
//        else
//            return 1;
//    }
}
