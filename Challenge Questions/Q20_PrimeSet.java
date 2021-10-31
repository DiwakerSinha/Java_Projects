import java.util.*;
public class Q20_PrimeSet
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the prime number");
        int length=sc.nextInt();
        int start=(int)(Math.pow(10,length-1))+1;
        int end=(int)Math.pow(10,length);
        int counter=0;
        out:for(int i=start;i<end;i+=2)
        {
            String temp=i+"";
            while(temp.length()!=0)
            {
                if(prime(temp))
                {
                    temp=temp.substring(0,temp.length()-1);
                }
                else
                    continue out;
            }
            counter++;
            System.out.println(i);
        }
        System.out.println(counter);
    }  

    public static boolean prime(String temp)
    {
        int temp1=Integer.parseInt(temp);
        if(temp1==1)
            return false;
        for(int i=2;i<=temp1/2;i++)
        {
            if(temp1%i==0)
                return false;
        }
        return true;
    }
}
