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
        for (int deckSize = 0; deckSize<=deckSizeVal; deckSize++)
            System.out.println(deckSize);
        return deckSizeVal;
    }

    public static ArrayList<Integer> deckMix(int deckSizeVal){
        ArrayList<Integer> deckCombo = new ArrayList<Integer>();
        for (int i=0; i<deckSizeVal;i++)
            for (int valOfCard=1; valOfCard<=13; valOfCard++)
                deckCombo.add(valOfCard);
        Collections.shuffle(deckCombo);
        return deckCombo;
    }
    

    public static void main(String[] args) {
        /*Falssview Casino rules: 6 decks, 80% Pen and dealer stays on 17
         */
        int x=deckSize();
        deckMix(x);
        System.out.println(deckMix(x));
    }
}
