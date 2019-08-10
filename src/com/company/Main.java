import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static Integer deckSize()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many decks (6 is at fallsview): ");
        int deckSizeVal = input.nextInt();
        System.out.println("Your deck size is: "+ deckSizeVal);
        return deckSizeVal;
    }

    public static ArrayList<Integer> deckShuffle(int deckSizeVal){
        ArrayList<Integer> deckCombo = new ArrayList<Integer>();
        for (int i=0; i<deckSizeVal;i++)
            for (int valOfCard=1; valOfCard<=13; valOfCard++) // Suit does not matter in blackjack for scoring
                deckCombo.add(valOfCard);
        Collections.shuffle(deckCombo);
        System.out.println(deckCombo);
        return deckCombo;
    }

    public static Integer dealCard(ArrayList<Integer> mixedDeck){
        int dealt = mixedDeck.get(0);
        mixedDeck.remove(0);
        return dealt;
    }

    public static boolean result ( ArrayList<Integer> playerCards,  ArrayList<Integer> dealerCards){
        //First lets calculate player cards score
        boolean win = true;
        int playerSum = 0;
        int dealerSum = 0;
        playerSum = playerCards.get(0)+playerCards.get(1);
        dealerSum = dealerCards.get(0)+dealerCards.get(1);
        if (playerSum>=dealerSum)
            win = true;
        else
            win = false;
        return win;
    }

    public static void main(String[] args) {
        /*Falssview Casino rules: 6 decks, 80% Pen and dealer stays on 17
         */
        ArrayList<Integer> mixedDeck = new ArrayList<Integer>();
        ArrayList<Integer> dealerCards = new ArrayList<Integer>(); //For now we'll only have two players dealer and player
        ArrayList<Integer> playerCards = new ArrayList<Integer>();

        int x=deckSize();
        int givenCard = 0;
        mixedDeck = deckShuffle(x);
        for (int count =0 ; count<2 ;count++) //Deals two cards to each starting with player
        {
            givenCard = dealCard(mixedDeck);
            playerCards.add(givenCard);
            givenCard = dealCard(mixedDeck);
            dealerCards.add(givenCard);
        }
        if ((playerCards.get(0)==(11))||(playerCards.get(0)==(12))||(playerCards.get(0)==(13)))
            playerCards.set(0,10);
        if ((playerCards.get(1)==(11))||(playerCards.get(1)==(12))||(playerCards.get(1)==(13)))
            playerCards.set(1,10);


        System.out.println("Your cards are: "+playerCards);
        System.out.println("The Dealer's cards are: "+dealerCards.get(0)+", ?");
        System.out.println(result(playerCards,dealerCards));
    }
}
