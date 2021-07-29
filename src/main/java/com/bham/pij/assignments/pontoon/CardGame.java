package com.bham.pij.assignments.pontoon;


import java.util.ArrayList;

//Silvester Stephens 1437955
public abstract class CardGame
{
    Deck deck = new Deck();
    int nplayers;
    ArrayList<Player> namesListOfPlayer = new ArrayList<>();


    public CardGame(int nplayers)
    {
        this.nplayers = nplayers;
    }

    public abstract void dealInitialCards();

    public abstract int compareHands(Player hand1, Player hand2);

    public Deck getDeck()
    {
        return deck;
    }
    
    public Player getPlayer(int i)
    {
        return namesListOfPlayer.get(i);
    }

    public int getNumPlayers()
    {
        return nplayers;
    }

    public abstract ArrayList<String> getCardImageValuePlayer1(Player hand1);

    public abstract ArrayList<String> getCardImageValuePlayer2(Player hand2);


}
