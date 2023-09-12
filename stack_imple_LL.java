import java.util.*;

class Lstack{
    int data;
    Lstack next;

    Lstack ()
    {
        this.data=0;
        this.next=null;
    }

    Lstack(int data)
    {
        this.data=data;
        this.next=null;
    }

   boolean isEmpty(Lstack head)
    {
        if(head==null) return true;
        else return false;
    }
    boolean isFull(Lstack head)
    {
        if(head==null) return true;
        else return false;
    }

    // Push operation
    public Lstack push( Lstack head , int data)
    {
        Lstack node=new Lstack(data);
        if(head==null)
        {
            head=node;
            return head;
        }
        else {
            node.next=head;
            head=node;
        }
        return head;
    }

    // Pop operation
    public Lstack pop(Lstack head)
    {
        if(isEmpty(head)) System.out.println("No Element");
        else
        {
            head=head.next;
        }
        return head;
    }

    // Peak element of linked list
    public int peak(Lstack head)
    {
        if(isEmpty(head)) return Integer.MAX_VALUE;
        else {
            return head.data;
        }
    }

   public void display(Lstack head)
    {
       if (isEmpty(head)) System.out.println(" No Element");
       else {
           Lstack cur = head;
           while(cur.next!=null) {
               System.out.println(cur.data + " ");
               cur=cur.next;
           }
       }
    }

    //
}

public class stack_imple_LL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Lstack st=new Lstack();
        System.out.println("       Enter the elements into stack       ");
        for(int i=0; i<6; i++)
        {
            int data=sc.nextInt();
            st=st.push(st,data);
        }
        System.out.println("Displaying the stack elements");
        st.display(st);

        System.out.println("Poping the element");
        st=st.pop(st);
        st.display(st);

        System.out.print("Peak element (top):- ");
        System.out.println(st.peak(st));

        st=st.push(st,100);
        st.display(st);
    }
}
