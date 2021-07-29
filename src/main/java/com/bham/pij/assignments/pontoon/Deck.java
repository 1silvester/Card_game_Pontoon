package com.bham.pij.assignments.pontoon;

// Silvester Stephens 1437955


import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public Deck()
    {
        for(int i = 0; i < 4; i++){
            for(int y = 0; y < 13; y++){
                deckOfCards.add(new Card(Card.Suit.values()[i], Card.Value.values()[y]));
            }
        }
    }

    public void reset()
    {
        deckOfCards.clear();

            for(int i = 0; i < 4; i++){
                for(int y =0; y < 13; y++){
                    deckOfCards.add(new Card(Card.Suit.values()[i], Card.Value.values()[y]));
                }
            }

    }

    public void shuffle()
    {
        ArrayList<Card> deckOfTempCards = new ArrayList<Card>();

        Random randomInt = new Random();
        int chosenCardIndex = 0;
        int firstDeckSize = this.deckOfCards.size();
        for(int i =0; i < firstDeckSize; i++)
        {
            chosenCardIndex = randomInt.nextInt((this.deckOfCards.size()-1)+1);
            deckOfTempCards.add(this.deckOfCards.get(chosenCardIndex));
            this.deckOfCards.remove(chosenCardIndex);

        } this.deckOfCards = deckOfTempCards;
    }

    public Card getCard(int i)
    {
        return this.deckOfCards.get(i);
    }
    public Card dealRandomCard()
    {
        Random randomInt = new Random();
        Card randCard;
        int chosenCardIndex = 0;

        chosenCardIndex = randomInt.nextInt((this.deckOfCards.size()-1)+1);
        randCard = this.deckOfCards.get(chosenCardIndex);
        this.deckOfCards.remove(chosenCardIndex);
        return randCard;

    }



    public int size()
    {
        ArrayList<Card> countOfCards = new ArrayList<>();
        int sizeOfDeck;

        for(Card c : this.deckOfCards)
        {
            countOfCards.add(c);
        }
        sizeOfDeck = countOfCards.size();
        return sizeOfDeck;
    }
}
