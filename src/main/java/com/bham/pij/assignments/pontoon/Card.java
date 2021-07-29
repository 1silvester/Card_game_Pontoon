package com.bham.pij.assignments.pontoon;

// Silvester Stephens 1437955

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Card {
    private Image image;
    public Card(Suit suit, Value value)
    {
        this.setSuit(suit);
        this.setValue(value);

//        String stringCardName = this.value + "_of_" + this.suit;
//        image = new Image("./cards"+stringCardName.toLowerCase());
//        this.setImage(image);

    }
    Suit suit;
    Value value;


    public static enum Suit
    {
       CLUBS,HEARTS,DIAMONDS,SPADES;
    }




    public static enum Value
    {
        ACE(1,11),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10)
        ;

        public int[] intValue;

        Value(int... value)
        {
            this.intValue = value;
        }

        public int[] getIntValue()
        {
            return this.intValue;
        }

    }

    public void setSuit(Suit suit)
    {

        this.suit = suit;
    }

//    public void setImage(Image image){this.image = image;}

//    public Image getImage(){return this.image;}

    public void setValue(Value value)
    {
        this.value = value;
    }

    public Suit getSuit()
    {
        return this.suit;
    }

    public Value getValue()
    {
        return this.value;
    }


    public ArrayList<Integer> getNumericalValue()
    {
        ArrayList<Integer> cardArrayValue = new ArrayList<Integer>();
        for(int i : value.getIntValue())
        {
            cardArrayValue.add(i);
        }

        return cardArrayValue;
    }

    public String stringCardName()
    {
        return this.getValue()+ "_of_" + this.getSuit()+".png";
    }

}
