package q18_linkedlist;
import java.util.Scanner;
public class linkedList
{
    node start;
   

    public linkedList(){
        Scanner sc=new Scanner(System.in);
        System.out.println("how much wood would a wood chuck chuck if a wood chuck could chuck wood");
        int a=sc.nextInt();
        System.out.println(a+" cubic metres of wood");
        node p=new node();
        start = p ;
        for(int i=0;i<a;i++)
       {
           System.out.println("enter the value of this node good sir/ if the ting goes ma'am");
           p.next=new node();
           p.next.a=sc.nextInt();
           p=p.next;
        }
    }
        
    
    

}
