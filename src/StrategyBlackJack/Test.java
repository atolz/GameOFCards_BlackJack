package StrategyBlackJack;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test {
    static String out = "C:\\Users\\atola\\IdeaProjects\\GameOFCards_BlackJack\\src\\StrategyBlackJack\\output.txt";
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(out);

        //Ace ambiguity Test
        System.out.println("Ace ambiguity Test");
        PlayerX playerX = new PlayerX();
        playerX.getCard(1);
        playerX.getCard(1);
        System.out.println(playerX.maxScore == 12);
        System.out.println(playerX.maxScore);
        System.out.println(playerX.minScore);

        //theScore test
        System.out.println("getTheScoreTest()");
        playerX.getNewHand();
        playerX.getCard(1);
        playerX.getCard(9);
        playerX.getCard(2);
        System.out.println("maxScore: " + playerX.maxScore);
        System.out.println("minScore: " + playerX.minScore);
        System.out.println("\ntheScore: "+playerX.getTheScore());

        pw.write(Arrays.toString(playerX.getMyCard()) + ",player");
        pw.flush();

        System.out.println(playerX.isBurst());
        System.out.println(Arrays.toString(playerX.getMyCard()));

        cardDeckXTest();

    }

    static void cardDeckXTest(){
        CardDeckX cardDeck = new CardDeckX();
        cardDeck.shuffle();
        try {
            System.out.println(cardDeck.getNextCard());
            System.out.println(cardDeck.getNextCard());
            System.out.println(cardDeck.index);
            cardDeck.shuffle();
            System.out.println(cardDeck.index);
        } catch (NoCardException e) {
            e.printStackTrace();
        }
    }
}
