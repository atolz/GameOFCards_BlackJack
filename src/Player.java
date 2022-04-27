public class Player {
    int point = 0;
    int [] myCard;
    int myCardIndx = 0;

    Player(){
        point = 0;
        myCard = new int[12];
    }

    void showPoints(){
        System.out.println("Player points: "+point);
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
        point = point + cardPoint;
        //add to card
        myCard[myCardIndx++] = cardPoint;
    }

    boolean isBlackJack(){
        return point == 21;
    }

    boolean isOver(){
        return point > 21;
    }
}
