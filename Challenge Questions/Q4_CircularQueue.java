import java.util.*;
public class Q4_CircularQueue
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of circular queue");
        int str=sc.nextInt();
        int ar[]= new int[str];
        int front=0;
        int rear=0;
        for(int l=0;;l++)
        {
            System.out.println("Enter 1 for adding, 2 for deleting, and 3 for displaying the queue");
            int inp=sc.nextInt();
            if(inp==1)
            {
                if(ar[rear]==0)
                {
                    System.out.println("Enter the number to be added");
                    ar[rear]=sc.nextInt();
                    if(rear==str-1)
                        rear=0;
                    else
                        rear++;
                }
                else
                {
                    System.out.println("Queue is full.Choose another option");
                    continue;
                }
            }
            else if(inp==2)
            {
                if(ar[front]!=0)
                {
                    ar[front]=0;
                    if(front==str-1)
                        front=0;
                    else
                        front++;
                }
                else
                {
                    System.out.println("Queue is empty.Choose another option");
                    continue;
                }
            }
            else if(inp==3)
            {
                for(int i=0;i<str;i++)
                {
                    System.out.print(ar[i]+" ");               
                }
                System.out.println();
            }
            else
            {
                System.out.println("Enter a valid input");
                continue;
            }
        }
    }
}
