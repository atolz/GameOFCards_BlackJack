package StrategyBlackJack;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BlackJackX {

    static String out = "C:\\Users\\atola\\IdeaProjects\\GameOFCards_BlackJack\\src\\StrategyBlackJack\\output.txt";
    static PrintWriter fout;
    static int strategy;
    static PlayerX player;
    static DealerX dealer;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        //fout = new PrintWriter(out);
        fout = new PrintWriter(new FileOutputStream(out,true));


        System.out.println("Which Strategy?");
        strategy = scan.nextInt();

        int dealerWinCnt = 0;
        int playerWinCnt = 0;
        int drawCnt = 0;

        int handsPlayed = 0;

        player = new PlayerX();
        dealer = new DealerX();
        CardDeckX cardDeck = new CardDeckX();
        cardDeck.shuffle();

        System.out.println();

        while (handsPlayed < 100){
            //return old cards in hand if any,... after a play/hand/round
            player.getNewHand();
            dealer.getNewHand();
            try {
                //Player Initial Play
                player.getCard(cardDeck.getNextCard());
                player.getCard(cardDeck.getNextCard());

                if(player.isBlackJack()){
                    playerWinCnt++;
                    toOutput("player");
                    handsPlayed++;
                    continue;
                }
                if(player.isBurst()){
                    dealerWinCnt++;
                    handsPlayed++;
                    toOutput("dealer");
                    continue;
                }

                //Dealer Initial Play
                dealer.getCard(cardDeck.getNextCard());
                dealer.getCard(cardDeck.getNextCard());
                if(dealer.isBlackJack()){
                    dealerWinCnt++;
                    handsPlayed++;
                    toOutput("dealer");
                    continue;
                }
                if(dealer.isBurst()){
                    playerWinCnt++;
                    handsPlayed++;
                    toOutput("player");
                    continue;
                }

                //Players Turn
                while (player.getTheScore() < strategy){
                    player.getCard(cardDeck.getNextCard());
                }
                if(player.isBlackJack()){
                    playerWinCnt++;
                    toOutput("player");
                    handsPlayed++;
                    continue;
                }
                if(player.isBurst()){
                    dealerWinCnt++;
                    handsPlayed++;
                    toOutput("dealer");
                    continue;
                }

                //Dealer Turn
                while (dealer.getTheScore() < strategy){
                    dealer.getCard(cardDeck.getNextCard());
                }
                if(dealer.isBlackJack()){
                    dealerWinCnt++;
                    handsPlayed++;
                    toOutput("dealer");
                    continue;
                }
                if(dealer.isBurst()){
                    playerWinCnt++;
                    handsPlayed++;
                    toOutput("player");
                    continue;
                }

                //Decision
                if(player.getTheScore() > dealer.getTheScore()){
                    playerWinCnt++;
                    toOutput("player");

                }else if(player.getTheScore() < dealer.getTheScore()){
                    dealerWinCnt++;
                    toOutput("dealer");

                }
                else {
                    drawCnt++;
                    toOutput("draw");
                }

                handsPlayed++;
            }catch (NoCardException e){
                cardDeck.shuffle();
                System.out.println("No card exception");
            }
        }

        System.out.println("playerWins: "+playerWinCnt + "\ndealerWins: "+dealerWinCnt + "\ndraws: "+drawCnt);
        fout.write("playerWins: "+playerWinCnt + "\ndealerWins: "+dealerWinCnt + "\ndraws: "+drawCnt+"\n\n");
        fout.flush();
    }

    //method to write to output file
    static void toOutput(String winner){
        fout.println(
                Arrays.toString(player.getMyCard()) +
                        ", "+ Arrays.toString(dealer.getMyCard()) +", "+winner+", "+ strategy);
        fout.flush();
    }
}
