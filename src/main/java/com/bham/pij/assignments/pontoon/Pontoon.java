package com.bham.pij.assignments.pontoon;

// Silvester Stephens 1437955

import java.util.ArrayList;

public class Pontoon extends CardGame
{

    public Pontoon(int nplayers)
    {
        super(nplayers);
        for(int i = 0; i < nplayers; i++)
        {
            Player thisPlayer = new Player("Player: " + Integer.parseInt(String.valueOf(i)));
            namesListOfPlayer.add(thisPlayer);
        }
    }


    @Override
    public void dealInitialCards()
    {

        for(int i = 0; i < nplayers; i++)
        {
        if(namesListOfPlayer.get(i).getHandSize() < 2)
        {
            for(int y =0; y< namesListOfPlayer.size(); y++)
            {
            namesListOfPlayer.get(i).dealToPlayer(deck.dealRandomCard());
            }
        }
        }
    }



    @Override
    public int compareHands(Player hand1, Player hand2)
    {
         // compares the values of the getNumeric hand value to return the best hand to the player
        {

        // values greater than 21 bust
         if(hand1.getBestNumericalHandValue() > 21 || hand2.getBestNumericalHandValue() > 21)

            if(hand1.getBestNumericalHandValue() > 21 && hand2.getBestNumericalHandValue() > 21)
                return 0;
            else if(hand2.getBestNumericalHandValue() > 21)
                return -1;
            else if(hand1.getBestNumericalHandValue() > 21)
                return +1;


        // 2 cards either equalling 21
        if(hand1.getHandSize() == 2 || hand2.getHandSize() == 2 )

            if(hand1.getBestNumericalHandValue() == 21 && hand2.getBestNumericalHandValue() == 21)
            { if(hand1.getHandSize() < hand2.getHandSize())
                return -1;
                else if(hand2.getHandSize() < hand1.getHandSize())
                return +1;
                else if( hand2.getHandSize() == hand1.getHandSize())
                    return 0;
            }
             else if(hand1.getBestNumericalHandValue() == 21 && hand1.getHandSize() < hand2.getHandSize())
                return -1;
             else if (hand2.getBestNumericalHandValue() == 21 && hand2.getHandSize() < hand1.getHandSize())
                return +1;


        // five card trick
        if(hand1.getHandSize() == 5 || hand2.getHandSize() == 5) // if either one has 5 cards

            if(hand1.getBestNumericalHandValue() <= 21 || hand2.getBestNumericalHandValue() <= 21)

                if(hand1.getBestNumericalHandValue() > hand2.getBestNumericalHandValue() ) // when hand1 is greater than hand2 and 1 has less cards
                {
                    return -1;
                }
                 else if(hand2.getBestNumericalHandValue() > hand1.getBestNumericalHandValue()) // when hand2 is greater than hand1 and has less card than hand1
                 {
                        return +1;
                 }
                else if(hand1.getBestNumericalHandValue() == hand2.getBestNumericalHandValue()) // when both hands are equal then compare hand sizes to determine winner
                {
                    if (hand1.getHandSize() < hand2.getHandSize())
                        return -1;
                    else if(hand2.getHandSize() < hand1.getHandSize())
                        return +1;
                    else if(hand1.getHandSize() == hand2.getHandSize())
                        return 0;
                }

        // hand values equal to 21
        if(hand1.getBestNumericalHandValue() == 21 || hand2.getBestNumericalHandValue() == 21)

            if( hand1.getBestNumericalHandValue() == 21 && hand2.getBestNumericalHandValue() == 21)
            {
                if(hand1.getHandSize() < hand2.getHandSize())
                return -1;
                else if(hand2.getHandSize() < hand1.getHandSize())
                    return +1;
                else if(hand1.getHandSize() == hand2.getHandSize())
                    return 0;

            }
             else if(hand1.getBestNumericalHandValue() == 21)
                return -1;
             else if(hand2.getBestNumericalHandValue() == 21)
                return +1;


        // hand values of equal to or less than total value of 20
        if(hand1.getBestNumericalHandValue() <= 20 || hand2.getBestNumericalHandValue() <= 20)

            if(hand1.getBestNumericalHandValue() == hand2.getBestNumericalHandValue())
                if(hand1.getHandSize() < hand2.getHandSize())
                {
                    return -1;
                } else if(hand2.getHandSize() < hand1.getHandSize())
                {
                    return +1;
                } else if(hand1.getHandSize() == hand2.getHandSize())
                {
                    return 0;
                }
             if (hand1.getBestNumericalHandValue() > hand2.getBestNumericalHandValue())
                return -1;
             else
                 return +1;
        }
    }

    @Override
    public ArrayList<String> getCardImageValuePlayer1(Player hand1)
    {
        int hand1Size = 0;
        ArrayList<Card> cardArrayList;
        ArrayList<String> stringArrayListOfCards = new ArrayList<>();


        while (hand1.getHandSize() > hand1Size){
            cardArrayList = hand1.getCards();
            for (Card card : cardArrayList) {
                stringArrayListOfCards.add(card.getValue() + "_of_" + card.getSuit() + ".png");
            }
        hand1Size++;
        }
        return stringArrayListOfCards;
    }

    @Override
    public ArrayList<String> getCardImageValuePlayer2(Player hand2)
    {
        int hand2Size = 0;
        ArrayList<Card> cardArrayList;
        ArrayList<String> stringArrayListOfCards = new ArrayList<>();


        while (hand2.getHandSize() > hand2Size){
            cardArrayList = hand2.getCards();
            for (Card card : cardArrayList) {
                stringArrayListOfCards.add(card.getValue() + "_of_" + card.getSuit() + ".png");
            }
            hand2Size++;
        }
        return stringArrayListOfCards;
    }





}
