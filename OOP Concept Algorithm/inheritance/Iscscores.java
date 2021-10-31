package q11_inheritance;


public class Iscscores
{
    int num[][];
    Iscscores()
    {        
        int num2[][]={{91,34,67,89,71,12},{1,2,3,4,5,6}};
        num=num2;
    }

    int point(int n)
    {
        if(n>=90)
        {return 1;}
        else if(n>=80)
        {return 2;}
        else if(n>=70)
        {return 3;}
        else if(n>=60)
        {return 4;}
        else if(n>=50)
        {return 5;}
        else if(n>=40)
        {return 6;}
        else if(n>=30)
        {return 7;}
        else if(n>=20)
        {return 8;}
        else if(n>=10)
        {return 9;}
        else
        {return 10;}
    }
}