public class Q10_ArrayDiagonalPattern
{
    public static void main(int n,char ch1, char ch2, char ch3)
    {
        if(n>10)
        {
            System.out.println("Size out of range");
            System.exit(0);
        }
        char arr[][]=new char[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=' ';   
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j||(i+j)==n-1)
                {
                    arr[i][j]=ch3;
                }
            }
        }

        for(int i=0;i<n/2;i++)
        {
            for(int j=i;j<n-1-i;j++)
            {
                if(arr[i][j]==' ')
                    arr[i][j]=ch1;
            }
        }

        for(int i=n/2;i<n;i++)
        {
            for(int j=n-1-i;j<i;j++)
            {
                if(arr[i][j]==' ')
                    arr[i][j]=ch1;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==' ')
                {
                    arr[i][j]=ch2;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]);
            }          
            System.out.println();
        }
    }
}
