package q11_inheritance;


public class bestfour extends Iscscores
{
    int total_points;
    bestfour()
    {
        total_points=0;
    }

    void best_subjects()
    {
        int max=-1;
        int maxloc=-1;
        for(int j=0;j<6;j++)
            {
                total_points+=point(num[0][j]);
            }
        System.out.println("Total Points are "+ total_points);
        for(int i=0;i<4;i++)
        {
            max=-1;
            for(int j=0;j<6;j++)
            {
                if(num[0][j]>max)
                {
                    max=num[0][j];
                    maxloc=j;
                }
            }
            System.out.println(num[1][maxloc]);
            num[0][maxloc]=-1;
        }
    }
}