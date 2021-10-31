import java.util.*;
public class Q19_Partition
{
    public static void main()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a number whose partitions you want to find");
        int inp=sc.nextInt();
        int ar[]=new int[inp];
        int counter=0;
        out:for(int i=1;;i++)
        {
            int total=0;
            for(int j=0;j<inp;j++)
            {
                total+=ar[j];
            }
            
            if(total==inp)
            {
                for(int l=0;l<inp;l++)
                {                 
                    System.out.print(ar[l]+" ");
                }
                System.out.println();
            }
            total=0;    

            for(int k=inp-1;k>=0;k--)
            {
                if(ar[k]<9)
                {
                    ar[k]++;
                    break;
                }	
                else
                {
                    if(k==0)
                    {
                        break out;
                    }
                    else
                    {
                        ar[k]=0;
                        if(k-1>=0)
                        {
                            ar[k-1]++;      
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }   
}
