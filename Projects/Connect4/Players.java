package Connect4;
import java.util.*;
class Players
{
    String name;
    ArrayList <String> playerCards = new ArrayList<String> ();
    
    Players(String nm)
    {
        name=nm;
        Deck d=new Deck();
        for(int i=0;i<7;i++)
        {
            playerCards.add(d.deck.get(i));
            d.deck.remove(i);
        }
    }
}
