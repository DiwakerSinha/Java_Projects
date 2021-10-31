import java.util.*;
public class Q9_FibonacciLike
{
    public static void main()
    {
        System.out.println("The Finonacci-Like Number from 10 to 10000");
        for(int i=10;i<=10000;i++)//runs from 10 to 10000 to discover fibonacci-like numbers
        {
            ArrayList <Integer> ar=new ArrayList<Integer>();
            int sum=0;
            String s=""+i;
            for(int j=0;j<s.length();j++)
            {
                ar.add(Character.getNumericValue(s.charAt(j)));
            }
            
            while(sum<=i)
            {
                sum=0;
                for(int j=0;j<ar.size();j++)
                {
                    sum+=ar.get(j);
                }
                if(sum==i)
                {
                    System.out.println(i);
                }
                ar.add(sum);
                ar.remove(0);
            }
        }
    }
}
