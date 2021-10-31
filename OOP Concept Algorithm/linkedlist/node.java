package q18_linkedlist;


public class node
{
    int a;
    node next;
    
    public node()
    {}
   
    
    node join(node y)
    {
        this.next=y;
        return y;
    }
    
    public String toString()
    {
        return (this.a+"");
    }
}
