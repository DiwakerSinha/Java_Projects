package Connect4;
import java.util.*;
public class Deck
{
    ArrayList <String> deck = new ArrayList<String>();;
    int location;
    void deckIni()
    {
        Suit s= new Suit();
        Card c= new Card();
        for(int d=0;d<60;d++)
        {
            deck.add(""+s.suit[d%4]+" "+c.card[d%15]);
        }

        for(int j=0;j<10;j++)
        {
            for(int i=0;i<60;i++)
            {
                int loc=(int)(Math.random()*60);
                String temp=deck.get(loc);
                deck.remove(loc);
                deck.add(temp);
            }
        }
    }
}
