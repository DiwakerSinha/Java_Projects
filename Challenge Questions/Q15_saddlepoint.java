import java.util.*;
public class Q15_saddlepoint
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of 2-D matrix");
        int N=sc.nextInt();
        int[][] ar=new int[N][N];
        if(N>20)//condition enforcer
        {
            System.out.println("Enter input less than 21");
            System.exit(0);
        }
        System.out.println("Enter elements");
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                ar[i][j]=sc.nextInt();
            }
        }


        out:for(int i=0;i<N;i++)
        {
            in:for(int j=0;j<N;j++)
            {
                int comparer=ar[i][j];
                for(int k=0;k<N;k++)//compares for minimum element for the row 
                {
                    if(ar[i][k]<comparer)
                    {
                        continue in;
                    }
                }
                
                for(int l=0;l<N;l++)//compares for the maximum element for the column 
                {
                    if(ar[l][j]>comparer)
                    {
                        continue in;
                    }
                }
                
                System.out.println("Saddle Point "+comparer);
                break out;
            }
        }
    }
}
/*
Enter size of 2-D matrix
3
Enter elements
1
2
4
3
5
7
9
6
10
Saddle Point 6
 */