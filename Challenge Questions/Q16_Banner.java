import java.util.*;
public class Q16_Banner
{//open class
    public static void main()
    {//open main method
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number (2<N<9)");
        int N=sc.nextInt();//Stores no.of teams
        sc.nextLine();
        if(N<=2 || N>=9)//condition for N Range
        {
            System.out.println("INVALID INPUT");
            System.exit(0);
        }
        ArrayList <String> ar=new ArrayList <String>();//Store team names

        for(int i=0;i<N;i++)
        {
            System.out.println("Team "+i+": ");
            String team=sc.nextLine();
            ar.add(team);
        }

        int max=0;
        for(int i=0;i<N;i++)
        {
            max=Math.max(max,(ar.get(i).length()));
        }

        for(int i=0;i<max;i++)//printing
        {//open for loop i
            for(int j=0;j<N;j++)
            {//open for loop j
                if(i<(ar.get(j)).length())
                {
                    System.out.print((ar.get(j)).charAt(i));
                }
                else
                    System.out.print(" ");//one space
                System.out.print("        ");
            }//close for loop j
            System.out.println();
        }//close for loop i
    }//end main method
}//end class
/*
Enter number (2<N<9)
3
Team 0: 
Emus
Team 1: 
Road Rols
Team 2: 
Coyote
E        R        C        
m        o        o        
u        a        y        
s        d        o        
                  t        
         R        e        
         o                 
         l                 
         s                 
 
 */