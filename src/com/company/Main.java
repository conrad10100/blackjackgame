package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        /*Falssview Casino rules: 6 decks, 80% Pen and dealer stays on 17
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many decks (6 is at fallsview): ");
        int deckNumber = input.nextInt();
        for (int deckSize = 0; deckSize<=deckNumber; deckSize++)
            System.out.println(deckSize);
    }
}
