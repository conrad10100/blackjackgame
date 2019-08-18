import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class main {
    public static Integer deckSize()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many decks (6 is at fallsview): ");
        int deckSizeVal = input.nextInt();
        System.out.println("Your deck size is: "+ deckSizeVal);
        return deckSizeVal;
    }
    public static Integer numGames(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many games you want to play: ");
        int numberGames = input.nextInt();
        System.out.println("You want to play this many games: "+ numberGames);
        return numberGames;
    }

    public static ArrayList<Integer> deckShuffle(int deckSizeVal){
        ArrayList<Integer> deckCombo = new ArrayList<Integer>();
        int deckSizeFour= deckSizeVal*4;
        for (int valOfCard=2; valOfCard<=11; valOfCard++) // Suit does not matter in blackjack for scoring
            for (int i=0; i<(deckSizeFour);i++)
               deckCombo.add(valOfCard);

        for (int repeat=0;repeat<deckSizeFour; repeat++ )
        {
            deckCombo.add(10);
            deckCombo.add(10);
            deckCombo.add(10);
        }
        Collections.shuffle(deckCombo);
        System.out.println(deckCombo);
        return deckCombo;
    }

    public static Integer dealCard(ArrayList<Integer> mixedDeck){
        int dealt;
        dealt = mixedDeck.get(0);
        mixedDeck.remove(0);
        return dealt;
    }

    public static boolean result ( int playerSum,  int dealerSum){
        //comparing scores
        boolean win;
        //System.out.println(playerSum);
        if (((playerSum>=dealerSum && playerSum<22)||dealerSum>21)&&playerSum!=dealerSum) { //checks if user has higher score and isn't busted
            win = true;
        }
        else
            win = false;

        return (win);
    }
    public static Integer sums (ArrayList<Integer> cards){
        int sum=0;
        for (int i = 0; i<cards.size(); i++)
            sum= cards.get(i) + sum;
        for (int b = 0; b <cards.size() ; b++) {
            if (cards.get(b)==11 &&sum>21){
                cards.set(b,1);
                sum = sums(cards);
                System.out.println(sum);
            }
        }
        return sum;
    }
    //public Label(String strLabel, int valueDeck);{
    //   return ("hi");
    //}
    public static void main(String[] args) {
        /*Falssview Casino rules: 6 decks, 80% Pen and dealer stays on 17
         */
        ArrayList<Integer> mixedDeck = new ArrayList<Integer>();
        int x=deckSize();
        int gameCount= numGames();
        int givenCard = 0;
        mixedDeck = deckShuffle(x);
        int oGmixedDeck=mixedDeck.size();
        for (int i = 0; i <gameCount ; i++) {
            if (mixedDeck.size()<=oGmixedDeck*0.8){
                mixedDeck=deckShuffle(x);
            }
            System.out.println(mixedDeck.size());
            boolean notOver = true;
            ArrayList<Integer> dealerCards = new ArrayList<Integer>(); //For now we'll only have two players dealer and player
            ArrayList<Integer> playerCards = new ArrayList<Integer>();
            for (int count =0 ; count<2 ;count++) //Deals two cards to each starting with player
            {
                givenCard = dealCard(mixedDeck);
                playerCards.add(givenCard);
                givenCard = dealCard(mixedDeck);
                dealerCards.add(givenCard);
            }
            int playerSum = sums(playerCards);
            int dealerSum = sums(dealerCards);
            if (playerSum==21){
                System.out.println("Yay you win! BLACKJACK");
                System.out.println("Your cards were: "+playerCards);
            }
            else {
                Scanner input = new Scanner(System.in);
                System.out.println("Your cards are: "+playerCards);
                System.out.println("The Dealer's cards are: ?, "+dealerCards.get(1));
                System.out.println("Would you like to hit? Type 1"); //Change it to a button in future when add gui
                int hitAgain = input.nextInt();
                while (hitAgain == 1 && notOver == true) {
                    givenCard = dealCard(mixedDeck);
                    playerCards.add(givenCard);
                    playerSum = sums(playerCards);
                    if (playerSum>21){
                        notOver = false;
                    }
                    else {
                        System.out.println("Your cards are: "+playerCards);
                        System.out.println("Would you like to hit? Type 1"); //Change it to a button in future when add gui
                        hitAgain = input.nextInt();
                    }
                }
                while (dealerSum<17 && notOver== true){
                    givenCard = dealCard(mixedDeck);
                    dealerCards.add(givenCard);
                    dealerSum= sums(dealerCards);
                }
                System.out.println(result(playerSum,dealerSum));
                //below checks who wins
                if (result(playerSum,dealerSum)==true && playerSum!=dealerSum){
                    System.out.println("You win");
                }
                else if(result(playerSum,dealerSum) == false && playerSum!=dealerSum) {
                    System.out.println("You lose");
                }
                else {
                    System.out.println("You tied");
                }
                System.out.println("Your cards were: "+playerCards);
                System.out.println("The Dealer's cards were: "+dealerCards+"\n");
            }
        }

    }
}
