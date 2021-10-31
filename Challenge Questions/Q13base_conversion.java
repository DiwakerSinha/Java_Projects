import java.util.*;
public class Q13base_conversion
{
    public static void main()
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter integer");
        int x=sc.nextInt();
        String xx=""+x;
        System.out.println("Enter integer");
        int y=sc.nextInt();   
        String yy=""+y;
        if(x==y)
        {
            System.out.println(x+" base("+1+") = "+y+" base("+1+")");
        }
        else if(x>y)
        {
            int check=max(xx);
            o: for(int i=check;i<=20;i++)
            {
                for(int j=max(yy);j<=20;j++)
                {
                    if((basecon(x,i))==(basecon(y,j)))
                    {
                        System.out.println(x+" base("+i+") = "+y+" base("+j+")");
                        break o;
                    }  
                }
            }
        }
        else if(x<y)
        {
            int check=max(xx);
            o:for(int i=check;i<=20;i++)
            {
                for(int j=max(yy);j<=20;j++)
                {
                    if((basecon(y,i))==(basecon(x,j)))
                    {
                        System.out.println(x+" base("+j+") = "+y+" base("+i+")");
                        break o;
                    }  
                }
            }
        }
    }

    public static int basecon(int num,int base)
    {
        String temp=""+num;
        int tempo=0;
        int q=0;
        for(int i=temp.length()-1;i>=0;i--)
        {
            tempo+=(Math.pow(base,q))*(Integer.parseInt(temp.charAt(i)+""));
            q++;
        }
        return tempo;
    }

    public static int max(String str)
    {
        int maxi=0;
        for(int i=0;i<str.length();i++)
        {
            maxi=Math.max(maxi,Integer.parseInt(str.charAt(i)+""));
        }
        return maxi+1;
    }
}
