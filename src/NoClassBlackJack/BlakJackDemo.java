package NoClassBlackJack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BlakJackDemo {
    static int cardsIndex = 0;
    private static final int[] cardDeck = {1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    static int[] playerCards;
    static int playerIndx;
    static int playerPoint;

    static int[] dealerCards;
    static int dealerCardIndx;
    static int dealerPoint = 0;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer = "";
        //Shuffle the cards
        shuffle(cardDeck);

        //initialize point and cards
        playerPoint = 0;
        playerCards = new int[12];
        ;
        playerIndx = 0;

        dealerPoint = 0;
        dealerCards = new int[12];
        dealerCardIndx = 0;

        dealerCards[dealerCardIndx++] = getCard();
        dealerCards[dealerCardIndx++] = getCard();
        //dealer
        if (totalScore(dealerCards) == 21) {
            System.out.println("Game Over!, Dealer Won");
            scoreSummary();
            return;
        } else if (totalScore(dealerCards) > 21) {
            System.out.println("Game Over!, Dealer Lost");
            scoreSummary();
            return;
        }

        playerCards[playerIndx++] = getCard();
        playerCards[playerIndx++] = getCard();
        //player
        if (totalScore(playerCards) == 21) {
            System.out.println("Game Over!, Player Won");
            scoreSummary();
            return;
        } else if (totalScore(playerCards) > 21) {
            System.out.println("Game Over!, Player Lost");
            scoreSummary();
            return;
        }

        scoreSummary();
        while (totalScore(dealerCards) < 17) {

            System.out.println("Player, Want more card? Yes/No");
            answer = scan.next();
            if (answer.equalsIgnoreCase("yes")) {
                playerCards[playerIndx++] = getCard();
                if (totalScore(playerCards) == 21) {
                    System.out.println("Game Over!, Player Won");
                    scoreSummary();
                    return;
                } else if (totalScore(playerCards) > 21) {
                    System.out.println("Game Over!, Player Lost");
                    scoreSummary();
                    return;
                }
            } else
                System.out.println("Player Passed");
            scoreSummary();


            System.out.println("Dealer, Want more card? Yes/No");
            answer = scan.next();
            if (answer.equalsIgnoreCase("yes")) {
                dealerCards[playerIndx++] = getCard();
                if (totalScore(dealerCards) == 21) {
                    System.out.println("Game Over!, Dealer Won");
                    scoreSummary();
                    return;
                } else if (totalScore(dealerCards) > 21) {
                    System.out.println("Game Over!, Dealer Lost");
                    scoreSummary();
                    return;
                }
            } else
                System.out.println("Dealer Passed");
            scoreSummary();

        }

        if (totalScore(playerCards) > totalScore(dealerCards))
            System.out.println("Player Won!\n");
        else if (totalScore(dealerCards) > totalScore(playerCards))
            System.out.println("Dealer Won!\n");
        else
            System.out.println("A draw Occurred");

        //Score Summary
        scoreSummary();

    }

    public static void shuffle(int[] cards) {

        Random rnd = new Random();
        int j = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            j = randomFromrange(i + 1, cards.length - 1);
            swap(i, j);
        }
        System.out.println(Arrays.toString(cards));
    }

    private static void swap(int i, int j) {
        int a = cardDeck[i];
        cardDeck[i] = cardDeck[j];
        cardDeck[j] = a;
    }

    static int randomFromrange(int lower, int upper) {
        Random rnd = new Random();
        int noOFTntsInRange = upper - lower + 1;
        return lower + rnd.nextInt(noOFTntsInRange);
    }

    static int getCard() {
        return cardDeck[cardsIndex++];

    }

    static int totalScore(int[] cards) {
        int points = 0;
        for (int card : cards) {
            points += card;
        }
        return points;
    }

    static void scoreSummary() {
        System.out.println("Dealer Point: " + totalScore(dealerCards) +
                "\nPlayer Point: " + totalScore(playerCards));
    }
}
