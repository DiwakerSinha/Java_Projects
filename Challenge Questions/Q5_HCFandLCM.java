import java.util.*;
class Q5_HCFandLCM
{   
    int num1,num2;
    Q5_HCFandLCM(int x,int y)
    {
        if(x<y)
        {
            num1=x;
            num2=y;
        }
        else
        {
            num1=y;
            num2=x;
        }
    }

    static int HCF(int num1,int num2)
    {
        if(num2==0)
            return num1;
        else
        {
            int p=Math.min(num1,num2);
            int q=Math.max(num1,num2);
            return HCF(p,q%p);
        }
    }

    static int LCM(int num1,int num2)
    {
        int p=num1*num2;
        return p/HCF(num1,num2);
    }
    
    static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers between who you want to find HCF and LCM");
        int x=sc.nextInt();
        int y=sc.nextInt();
        Q5_HCFandLCM obj = new Q5_HCFandLCM(x,y);
        System.out.println("The HCF is "+HCF(obj.num1,obj.num2));
        System.out.println("The LCM is "+LCM(obj.num1,obj.num2));
    }
}