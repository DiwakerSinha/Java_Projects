package Connect4;
import java.util.*;
public class Link
{
    int playersNum;
    Players[] p;
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of players");
        playersNum=sc.nextInt();
        p=new Players[playersNum];
        for(int p=0;p<playersNum;p++)
        {
            System.out.println("Enter player name");
            String nm=sc.next();
        }

        
    }
}
