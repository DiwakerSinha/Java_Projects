 import java.util.*;
public class Q3_Kaleys
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines you want the Kaley's Triangle printed");
        int n=sc.nextInt();
        int ar[][]=new int[n][(int)(Math.pow(n,3))+1100000];
        ar[0][0]=1;
        long start=System.nanoTime();
        for(int i=0;i<n-1;i++)//rows
        {
            int pos=0;
            c:for(int j=0;j<(int)(Math.pow(n,3)+1100000);j++)//columns
            {
                int counter=1;

                if(ar[i][j]==0)
                    break c;
                int first=ar[i][j];

                while(ar[i][j+1]==first)//counter for like number
                {
                    counter++;
                    j++;
                }

                if(ar[i][j+1]!=first)
                {
                    ar[i+1][pos]=counter;
                    pos++;
                    ar[i+1][pos]=first;
                    pos++;
                }

                if(ar[i][j]==0)
                    break c;

            }
            pos=0;           
        }

        for(int i=0;i<n;i++)//printing
        {
            for(int j=0;j<(int)(Math.pow(n,3))+1100000;j++)//max heap storage
            {
                if(ar[i][j]==0)
                    break;
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        long end=System.nanoTime();
        System.out.println(end-start);
    }
}