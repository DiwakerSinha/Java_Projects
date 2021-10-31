 import java.util.*;
public class Q17_infix_to_postfix
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter infix input");
        String s="("+sc.nextLine()+")";
        char stack[]=new char[s.length()];
        int top=-1;  
        for(int i=0;i<s.length();i++)
        {
            if(Character.isLetter(s.charAt(i)))
            {
                System.out.print(s.charAt(i));
            }
            else
            {
                if(s.charAt(i)=='(')
                {
                    top++;
                    stack[top]=s.charAt(i);
                }
                else if(s.charAt(i)==')')
                {
                    int b=-1;
                    for(int j=top;;j--)
                    {
                        if(stack[j]=='(')
                        {
                            b=j;
                            break;
                        }
                    }
                    for(int j=top;j>=b;j--)
                    {
                        if(stack[j]!='(' && stack[j]!=' ')
                            System.out.print(stack[j]);
                    }
                    if(top!=0) 
                    {
                        top=b-1;
                    }
                }
                else if(precedence(s.charAt(i))<precedence(stack[top]))
                {
                    System.out.print(s.charAt(i));
                }
                else if(precedence(s.charAt(i))==precedence(stack[top]))
                {
                    char temp=stack[top];
                    stack[top]=s.charAt(i);
                    System.out.print(temp);
                }
                else if(precedence(s.charAt(i))>precedence(stack[top]))
                {
                    top++;
                    stack[top]=s.charAt(i);
                }
            }
        }
    }

    static int precedence(char c)
    {
        if(c=='-' || c=='+')
        {
            return 1;
        }
        else if(c=='*' || c=='/')
        {
            return 2;
        }
        else if(c=='^')
        {
            return 3;
        }
        else 
            return -1;
    }
}
