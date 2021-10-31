import java.util.*;
public class Q1_June10th
{
    public static void main()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter integer");
        int n= sc.nextInt();//size of array
        int ar[][]= new int[n][n];//initial array to store randomly generated 1s and 0s
        int counter=0;
        
        for(int i=0;i<n;i++)//initialize array to store randomly generated 1s and 0s
        {
            for(int j=0;j<n;j++)
            {
                ar[i][j]=(int)(Math.random()+0.5);
                if(ar[i][j]==1)
                    counter++;
            }
        }
        
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                { 
                    System.out.print(ar[i][j]+" ");
                }
                System.out.println();
            }
        System.out.println("Before rotation 1, the total Black squares = "+counter);
        counter=0;
        for(int z=2;z<=4;z++)
        {           
            int temp[][]=new int[n][n];
            int k=n-1;
            for(int i=0;i<n;i++)//ar rotated into temp
            {
                for(int j=0;j<n;j++)
                {
                    temp[j][k]=ar[i][j];
                }
                k--;
            }

            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(temp[i][j]==1 || ar[i][j]==1)
                    {
                        ar[i][j]=1;
                        counter++;
                    }
                    System.out.print(ar[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("Before rotation "+z+", the total Black squares = "+counter);
            counter=0;
        }
    }
}
