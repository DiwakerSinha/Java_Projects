package Connect4;
public class Suit
{
    String suit[];
    void suits()
    {
        suit=new String[15];
        for(int i=0;i<10;i++)
            suit[i]=""+i;
            
        suit[10]="Reverse";
        suit[11]="Skip";
        suit[12]="Wild";
        suit[13]="Draw 2";
        suit[14]="Draw 4";
    }
}
