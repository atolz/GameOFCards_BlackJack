import java.util.Arrays;
import java.util.Random;

public class CardDeck {
    static int index = 0;
    private static final int [] cards = {1, 2,2,2,2, 3,3,3,3, 4,4,4,4, 5,5,5,5, 6,6,6,6, 7,7,7,7, 8,8,8,8,  9,9,9,9, 10,
                    10,10,10,10,  10,10,10,10,  10,10,10,10};




    public static void shuffle(){
        
        Random rnd = new Random();
        int j = 0;
        for(int  i = 0; i < cards.length - 1; i++){
            j = randomFromrange(i+1, cards.length - 1);
            swap(i,j);
        }
        System.out.println(Arrays.toString(cards));
    }

    private static void swap(int i, int j){
        int a = CardDeck.cards[i];
        CardDeck.cards[i] = CardDeck.cards[j];
        CardDeck.cards[j] = a;
    }

    static int randomFromrange(int lower, int upper){
        Random rnd = new Random();
        int noOFTntsInRange = upper - lower + 1;
        return lower + rnd.nextInt(noOFTntsInRange);
    }

    static int getNextCard(){
        return CardDeck.cards[index++];

    }

    //public static void main(String[] args) { shuffle(); }
}


