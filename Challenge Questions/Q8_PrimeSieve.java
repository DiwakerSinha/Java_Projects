import java.util.Scanner;
public class Q8_PrimeSieve
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter till which prime number you want");
        int n = sc.nextInt();
        long ar[]=new long[n];
        for(int i=0;i<n;i++)
            ar[i]=i;
        ar[1]=0;
        for(int a=0;a<n;a++)
        {
            if(ar[a]!=0)
            {
                for(int b=a+1;b<n;b++)
                {
                    if(ar[b]!=0)
                    {
                        if(ar[b]%ar[a]==0)
                            ar[b]=0;
                    }
                }
            }
        }

        for(int a=0;a<n;a++)
            if(ar[a]!=0)
                System.out.print(ar[a]+" ");
    }
}