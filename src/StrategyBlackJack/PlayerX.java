package StrategyBlackJack;

import java.util.Arrays;

public class PlayerX {
    //int point = 0;
    int theScore = 0;
    int minScore = 0;
    int maxScore = 0;

    boolean hasAce = false;

    int [] myCard;

    int myCardIndx = 0;

    PlayerX(){
        //point = 0;
        myCard = new int[12];
    }

    void showPoints(){
        System.out.println("Player points: "+getTheScore());
    }

    void showCards(){
        System.out.print("Player card: ");
        for (int x: myCard) {
            if(x != 0){
                System.out.print(x+", ");
            }
        }
        System.out.println();
    }

    void getCard(int cardPoint){
        //point = point + cardPoint;
        minScore = minScore + cardPoint;
        if(hasAce)
            maxScore = maxScore + cardPoint;
        else{
            maxScore = maxScore + (cardPoint == 1 ? 11 : cardPoint);
            hasAce = true;
        }
        //add to card
        myCard[myCardIndx++] = cardPoint;
    }

    boolean isBlackJack(){
        return getTheScore() == 21;
    }

    boolean isBurst(){
        return getTheScore() > 21;
    }

    public int getTheScore() {
        if(maxScore > 21)
            theScore = minScore;
        else
            theScore = maxScore;
        return theScore;
    }

    public void getNewHand(){
        myCardIndx = 0;
        maxScore = 0;
        minScore = 0;
        theScore = 0;
        hasAce = false;
        myCard = new int[12];
    }

    public int[] getMyCard() {
        return Arrays.copyOf(myCard,myCardIndx);
    }
}

