import java.util.*;
public class Q6_SmithNumber
{
    public static void main()
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int input=sc.nextInt();//accepting input
        int inputd=input;
        int count=0;
        int sum=0;//for sum of all prime factors
        for(int i=0;;i++)
        {
            for(int j=2;j<=input;j++)
            {
                if(input%j==0)
                {
                    count++;
                    String temp=j+"";
                    for(int k=0;k<temp.length();k++)
                    {
                        sum+=Integer.parseInt(temp.charAt(k)+"");//adding digits of prime factors
                    }
                    input=input/j;
                    break;
                }
            }//closing bracket of for loop j
            if(input==1)//parameter to break infinite for loop i
            {
                break;
            }
        }//closing bracket of for loop i

        //sum of prime numbers done

        String num=inputd+"";
        int sum1=0;
        for(int i=0;i<num.length();i++)//finding sum of digits of the input
        {
            sum1+=Integer.parseInt(num.charAt(i)+"");
        }

        System.out.println("Sum of digits="+sum1);
        System.out.println("Sum of its prime factors="+sum);

        if(sum==sum1 && count>1)
        {
            System.out.println("Smith Number");
        }
        else
        {
            System.out.println("Not a Smith Number");
        }

        /*
         * Enter a number
        666
        Sum of digits=18
        Sum of its prime factors=18
        Smith Number

        Enter a number
        123456789
        Sum of digits=45
        Sum of its prime factors=36
        Not a Smith Number

        Enter a number
        999
        Sum of digits=27
        Sum of its prime factors=19
        Not a Smith Number
        
         */
    }
}
