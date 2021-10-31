import java.util.*;
public class Q15_March18th
{
    public static void main()throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of numbers you want to enter");
        int n =sc.nextInt();
        if(n<50)
        {
            int ar[]=new int[n];
            int maximum=0;
            int maximumloc=0;
            for(int i=0;i<n;i++)
            {
                System.out.println("Enter integer "+(i+1)+":");
                ar[i]=sc.nextInt(); 
                maximum=Math.max(maximum,ar[i]);
            }

            System.out.println("Original array");
            for(int i=0;i<n;i++)
            {
                System.out.print(ar[i]+" ");
                if(ar[i]==maximum)
                    maximumloc=i;
            }
            System.out.println();

            if(n%2==0)//n is even
            {
                int leftloc=(n/2)-1;
                int rightloc=(n/2);
                int loc=maximumloc;
                while(leftloc!=0 && rightloc!=n-1)
                {
                    if(leftloc!=(n/2)-1)
                    {
                        for(int i=0;i<n;i++)
                        {
                            if(ar[i]<maximum)
                            {
                                maximum=Math.max(maximum,ar[i]);
                            }
                        }
                    }
                    for(int i=0;i<n;i++)
                    {
                        if(maximum==ar[i])
                            loc=i;
                    }
                    int temp=ar[leftloc];
                    ar[leftloc]=maximum;
                    ar[loc]=temp;
                    leftloc--;

                    for(int i=0;i<n;i++)
                    {
                        if(ar[i]<maximum)
                        {
                            maximum=Math.max(maximum,ar[i]);
                        }
                    }
                    for(int i=0;i<n;i++)
                    {
                        if(maximum==ar[i])
                            loc=i;
                    }
                    temp=ar[rightloc];
                    ar[rightloc]=maximum;
                    ar[maximumloc]=temp;
                    rightloc++;
                }       
            }
            else
            {
                int leftloc=(n/2);
                int rightloc=(n/2)+1;
                int loc=maximumloc;
                while(leftloc!=0 && rightloc!=n-1)
                {
                    if(leftloc!=(n/2))
                    {
                        for(int i=0;i<n;i++)
                        {
                            if(ar[i]<maximum)
                            {
                                maximum=Math.max(maximum,ar[i]);
                            }
                        }
                    }
                    int temp=ar[leftloc];
                    ar[leftloc]=maximum;
                    ar[loc]=temp;
                    leftloc--;

                    for(int i=0;i<n;i++)
                    {
                        if(ar[i]<maximum)
                        {
                            maximum=Math.max(maximum,ar[i]);
                        }
                    }
                    temp=ar[rightloc];
                    ar[rightloc]=maximum;
                    ar[maximumloc]=temp;
                    rightloc++;
                }       
            }

            System.out.println("Re-arranged Array");
            for(int i=0;i<n;i++)
                System.out.println( ar[i]+" ");
        }
        else
        {
            System.out.print("\f");
            System.out.println("Enter less than 50 numbers");
            System.out.println();
            Thread.sleep(2500);
            main();
        }
    }
}