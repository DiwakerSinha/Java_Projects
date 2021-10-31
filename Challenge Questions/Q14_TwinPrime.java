import java.util.*;
public class Q14_TwinPrime
{
    public static void main()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number");
        int num=sc.nextInt();

        int up_small=0;
        int up_big=0;
        up:for(int i=num;;i++)//checks for twin primes above
        {
            if(prime(i))
            {
                if(prime(i-2))
                {
                    up_big=i;
                    up_small=i-2;
                    break up;
                }
                else if(prime(i+2))
                {
                    up_big=i+2;
                    up_small=i;
                    break up;
                }
            }
        }

        int down_small=0;
        int down_big=0;
        down:for(int i=num;i>0;i--)//checks for twin primes below
        {
            if(prime(i))
            {
                if(prime(i-2))
                {
                    down_big=i;
                    down_small=i-2;
                    break down;
                }
                else if(prime(i+2))
                {
                    down_big=i+2;
                    down_small=i;
                    break down;
                }
            }
        }

        if(num-down_big<up_small-num)//used to minimize the difference between the two twin primes and the input
            System.out.println(down_small+" and "+down_big);
        else
            System.out.println(up_small+" and "+up_big);
    }

    public static boolean prime(int n)//checks for prime
    {
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
/* 
Enter number
15
17 and 19

Enter number
123
137 and 139

 */