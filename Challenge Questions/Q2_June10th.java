import java.util.*;
public class Q2_June10th
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        String ar[][]=new String[6][20];
        System.out.println("Enter frequency of waves(greater than 2 and less than 12)");
        int F=sc.nextInt();
        System.out.println("Enter amplitude of waves(greater than 2 and less than 7)");
        int A=sc.nextInt();
        int T=0;
        int row=5;
        while(T<19)
        {
            int temp=T;
            for(int i=temp+1;i<temp+F;i++)
            {
                ar[row][T]="*";
                if(T<19)
                    T++;
            }

            if(T!=19){
                if(row==5)
                {
                    for(int j=5;j>5-A;j--)
                    {
                        ar[row][T]="*";
                        row--;
                    }
                    row=6-A;
                }
                else
                {
                    for(int j=6-A;j<=5;j++)
                    {
                        ar[row][T]="*";
                        row++;
                    }
                    row=5;
                }
            }
        }
        
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<20;j++)
            {
                try
                {
                    if(ar[i][j].length()==0)
                    {
                        ar[i][j]=".";
                    }
                }
                catch(Exception e)
                {
                    ar[i][j]=".";
                }
            }
        }
        
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<20;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
