import java.util.*;

class Node
{
    int data;
    Node next;

    Node()
    {
        this.data=0;
        this.next=null;
    }

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
    // Inserting a node into a linked list
    Node insert_node(Node head, int data)
    {
        if(head==null)
        {
            Node temp=new Node(data);
            return temp;
        }
        else {
            Node cur=head;
            while(cur.next!=null)
            {
                cur=cur.next;
            }
            cur.next=new Node (data);
            return head;
        }
    }

    // Deleting a node from linked list
    void delete(Node head, int indx)
    {
        if(indx==1)
        {
            head=head.next;
        }
        else {
            Node cur=head;
            Node pre=null;
            while(cur!=null && indx!=1)
            {
                pre=cur;
                cur=cur.next;
                indx--;
            }
            pre.next=cur.next;
        }
    }

    // Printing the linked list

    void display(Node head)
    {
        if(head==null){
            System.out.println("null");
        }
        else {
            Node cur=head;
            while(cur!=null)
            {
                System.out.print(cur.data+" ->");
                cur=cur.next;
            }
            System.out.println("null");
        }

    }


    // Searching a Node in Linked list

    boolean search(Node head, int data)
    {
        if(head==null)
        {
            return false;
        }
        else {
            Node cur=head;
            while(cur!=null)
            {
                if(cur.data==data)
                {
                   return true;
                }
                cur=cur.next;
            }
            return false;
        }
    }

    // Finding the Node at Given position

    void find(Node head, int pos)
    {
        if(head==null)
        {
            System.out.println("List is Empty");
        }
        else {
            Node cur=head;
            while(cur!=null && pos!=0)
            {
                cur=cur.next;
                pos--;
            }
            System.out.println(cur.data);
        }
    }

    // reversing the linked list

    Node reverse_ll(Node head)
    {
        if(head==null)
        {
            return null;
        }
        Node pre=null;
        Node nex=head;

        while(head!=null)
        {
            nex=head.next;
            head.next=pre;
            pre=head;
            head=nex;
        }
        return pre;
    }

    //               Sort the linked list

    Node middle(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node sp=head;
        Node fp=head;

        while(fp.next!=null && fp.next.next!=null)
        {
            sp=sp.next;
            fp=fp.next.next;
        }
       return sp;
    }

    Node merge_ll(Node left, Node right)
    {
        Node res=null;
        // Base case
        if(left==null) return right;
        if(right==null) return left;

        if(left.data<right.data)
        {
            res=left;
            res.next=merge_ll(left.next, right);
        }
        else {
            res=right;
            res.next=merge_ll(left, right.next);
        }
       return res;
    }
    Node sort_ll(Node head)
    {
        // 1 methods take all data sort and make a new linked list
        // merger sort

        // Applying merge sort
        if(head==null || head.next==null)
        {
            return head;
        }

        Node mid=middle(head);
        Node head2=mid.next;
        mid.next=null;

        return merge_ll(sort_ll(head), sort_ll(head2));
    }

}
public class Linked_list_Implementation {

    public static void main(String[] args) {
    Node head = new Node();
    Scanner sc=new Scanner (System.in);
        System.out.println("Enter the Element to insert to linked list");
    for(int i=0; i<5;i++)
    {
        int ele=sc.nextInt();
        head=head.insert_node(head,ele);
    }
    head=head.next;
    System.out.println("Dispalying the elements ");
    head.display(head);

    // Deleting the nodes
        System.out.println("deleting the element");
    head.delete(head,2);

    head.display(head);

    //Searching the element
        System.out.println(head.search(head,10));

        //Finding the Node at nth position
    head.find(head,3);


    // reversing the linked list
        System.out.println(" ----  Reversing the linked list  ----  ");
        head=head.reverse_ll(head);
        head.display(head);

        // Sorting the linked list
        System.out.println(" -----  Sorting the linked list  -----  ");
        head=head.sort_ll(head);
        head.display(head);



    }
}
