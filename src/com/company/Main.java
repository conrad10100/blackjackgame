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
        ArrayList<Integer> cardJQK = new ArrayList<>();
        cardJQK.add(11);
        cardJQK.add(12);
        cardJQK.add(13);
        int dealt = mixedDeck.get(0);
        mixedDeck.remove(0);
        if (cardJQK.contains(dealt))
            dealt=10;
        return dealt;
    }

    public static boolean result ( int playerSum,  int dealerSum){
        //First lets calculate player cards score
        boolean win;
        System.out.println(playerSum);

        if (playerSum>=dealerSum && playerSum<22) { //checks if user has higher score and isn't busted
            win = true;
        }
        else
            win = false;
        return win;
    }

    public static Integer sum (ArrayList<Integer> cards){
        int sum = 0;
        for (int i = 0; i<cards.size(); i++)
            sum= cards.get(i) + sum;
        return sum;
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
        int playerSum = 0;
        int dealerSum = 0;
        playerSum = sum(playerCards);
        dealerSum = sum(dealerCards);

        Scanner input = new Scanner(System.in);
        System.out.println("Your cards are: "+playerCards);
        System.out.println("The Dealer's cards are: "+dealerCards.get(0)+", ?");
        System.out.println("Would you like to hit? Type 1"); //Change it to a button in future when add gui
        int hitAgain = input.nextInt();
        while (hitAgain == 1) {
            givenCard = dealCard(mixedDeck);
            playerCards.add(givenCard);
            System.out.println("Your cards are: "+playerCards);
            System.out.println("Would you like to hit? Type 1"); //Change it to a button in future when add gui
            hitAgain = input.nextInt();
            playerSum = sum(playerCards);
        }
        while (dealerSum<17){
            givenCard = dealCard(mixedDeck);
            dealerCards.add(givenCard);
            dealerSum= sum(dealerCards);
        }
        System.out.println("Your cards are: "+playerCards);
        System.out.println("The Dealer's cards are: "+dealerCards);
        System.out.println(result(playerSum,dealerSum));

        //below checks who wins
        if (result(playerSum,dealerSum)==true){
            System.out.println("You win");
        }
        else {
            System.out.println("You lose");
        }
        System.out.println("Your cards are: "+playerCards);
        System.out.println("The Dealer's cards are: "+dealerCards);
        }
    }
