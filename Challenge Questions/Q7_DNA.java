import java.util.*;
public class Q7_DNA
{
    public static void main()throws Exception
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of strings you want to enter");
        int m=sc.nextInt();
        System.out.println("Enter the length of each string");
        int n=sc.nextInt();
        String ar[][]=new String[m][2];//the second matrix column is for recording inversions
        for(int i=0;i<m;i++)
        { 
            System.out.println("Enter string(ALL CAPS)");
            String temp1=sc.next();
            if(temp1.length()!=n)
            {
                System.out.println("Enter the string of correct length");
                i--;
                continue;
            }
            for(int j=0;j<n;j++)
            {
                char temp2=temp1.charAt(j);
                if(temp2!='A' && temp2!='T' && temp2!='C' && temp2!='G')
                {
                    System.out.println("The string can only contain 'A', 'C', 'G', and 'T'");
                    i--;
                    continue;
                }
            }
            ar[i][0]=temp1;
        }
        //the input has been taken
        System.out.println("\f");

        for(int i=0;i<m;i++)//runs through the various strings in the array
        { 
            int counter=0;
            for(int j=0;j<n;j++)//runs through the String
            {        
                for(int k=j+1;k<n;k++)//counts inversions
                {
                    char base=ar[i][0].charAt(j);
                    if(base>ar[i][0].charAt(k))
                    {
                        counter++;
                    }
                }
            }
            ar[i][1]=""+counter;//inversions counted and stored
        }

        for(int i=0;i<m;i++)//sorting
        {
            for(int j=0;j<m-1;j++)
            {
                if(Integer.parseInt(ar[j][1])>Integer.parseInt(ar[j+1][1]))
                {
                    String temp[]={""+ar[j][0],""+ar[j][1]};
                    ar[j][0]=ar[j+1][0];
                    ar[j][1]=ar[j+1][1];
                    ar[j+1][0]=temp[0];
                    ar[j+1][1]=temp[1];
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            System.out.println(ar[i][0]);
        }
    }
}
