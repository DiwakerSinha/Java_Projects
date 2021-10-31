import java.util.*;
public class Q18
{  
    public static void main()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter input number");
        int S=sc.nextInt();
        if(S<0 || S>10000)
        {
            System.out.println("Invalid Input");
            System.exit(0);
        }

        System.out.println("Enter number of required palindromic numbers after S");
        int N=sc.nextInt();
        if(N<=1 || N>=15)
        {
            System.out.println("Invalid Input");
            System.exit(0);
        }

        int count=0;

        for(int i=S;;i++)
        {
            if(count==N)
                break;
            int twocheck=0;
            for(int j=2;j<=10;j++)//base
            {
                long tempbase_num=base(i,j);
                if(pali(tempbase_num+""))
                {
                    twocheck++;
                }
            }
            if(twocheck>=2)
            {
                System.out.println(i);
                count++;
            }
        }
    }

    public static long base(int original,int base)
    {
        String new_num=""+0;
        while(original!=0)
        {
            new_num=(original%base)+new_num;
            original=original/base;
        }
        return(Long.parseLong(new_num.substring(0,new_num.length()-1)));
    }

    public static boolean pali(String str)
    {
        if(str.length()==1||str.length()==0)
        {
            return true;
        }
        else
        {
            if(str.charAt(0)==str.charAt(str.length()-1))
            {             
                return pali(str.substring(1,str.length()-1));
            }
            else
                return false;
        }
    }
}