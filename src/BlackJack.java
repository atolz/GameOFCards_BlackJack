public class BlackJack {
    public static void main(String[] args) {
        Player player =new Player();
        Dealer dealer = new Dealer();
        CardDeck.shuffle();


        //Game starts
        System.out.println("Game Start: Initial Cards: ");
        dealer.getCard(CardDeck.getNextCard());
        dealer.getCard(CardDeck.getNextCard());
        dealer.showCards();
        if(dealer.isBlackJack()){
            System.out.println("Dealer Won!");
            return;
        }
        if(dealer.isOver()){
            System.out.println("Player Won!");
            return;
        }

        player.getCard(CardDeck.getNextCard());
        player.getCard(CardDeck.getNextCard());
        player.showCards();

        if(player.isBlackJack()){
            System.out.println("Player Won!");
            return;
        }
        if(player.isOver()){
            System.out.println("Dealer Won!");
            return;
        }
        System.out.println();

        while (dealer.point < 17){
            System.out.println("Dealer still less 17");
            player.getCard(CardDeck.getNextCard());
            player.showCards();
            if(player.isBlackJack()){
                System.out.println("Player Won!");
                System.out.println("\nSummary: ");
                player.showPoints();
                dealer.showPoints();
                return;
            }
            if(player.isOver()){
                System.out.println("Player Burst, points more than 21");
                player.showPoints();
                System.out.println("Dealer Won!");
                return;
            }

            dealer.getCard(CardDeck.getNextCard());
            dealer.showCards();
            if(dealer.isBlackJack()){
                System.out.println("Dealer Won!");
                System.out.println("\nSummary: ");
                player.showPoints();
                dealer.showPoints();
                return;
            }
            if(dealer.isOver()){
                System.out.println("Dealer burst, points more than 21");
                dealer.showPoints();
                System.out.println("Player Won!");
                return;
            }
        }

        //Decision stage by dealer
        if(dealer.point > player.point){
            System.out.println("Dealer Won!");
            System.out.println("\nSummary: ");
            dealer.showPoints();
            player.showPoints();
        }else {
            System.out.println("Player Won!");
            System.out.println("\nSummary: ");
            player.showPoints();
            dealer.showPoints();
        }

    }
}
