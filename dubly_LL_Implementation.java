import java.util.*;

class DNode
{
    int data;
    DNode prev;
    DNode next;

    // Constructor defining
    DNode ()
    {
        this.data=0;
        this.next=null;
        this.prev=null;
    }

    DNode (int data)
    {
        this.data=data;
        this.prev=null;
        this.next=null;
    }


    //Inserting the Node into linked list
    static DNode insert(DNode head, int data)
    {
        if(head==null)
        {
            DNode temp=new DNode(data);
            return temp;
        }
        else {
            DNode cur=head;
            while(cur.next!=null)
            {
                cur=cur.next;
            }
            DNode temp=new DNode(data);
            cur.next=temp;
            temp.prev=cur;
            return head;
        }
    }

    // Delete the first node into linked list
    static DNode  Delete_head(DNode  head) {
        if(head==null) {
            return null;
        }
        else {
            DNode temp=head;
            head=head.next;
            temp.next=null;
            head.prev=null;
            return head;
        }
    }

    // Delete the Last node from linked list
    static DNode  Delete_last(DNode  head) {
        if(head==null) {
            return null;
        }
        DNode temp=head;
        DNode pre=head;
        while(temp.next!=null) {
            pre=temp;
            temp=temp.next;
        }
        pre.next=null;
        temp.prev=null;
        return head;
    }

    // delete the Middle node into linked list
    static DNode  Delete_middle(DNode  head) {

        if (head==null) {
            return null;
        }
        else {
           DNode sp=head;
           DNode fp=head;
           DNode pre=head;
           while(fp!=null  && fp.next!=null)
           {
               pre=sp;
               sp=sp.next;
               fp=fp.next.next;
           }
           pre.next=sp.next;
           sp.next.prev=pre;
        }
        return head;
    }


    // Delete the given node into linked list

    static DNode Delete_given_Node(DNode head, int data)
    {
        DNode cur=head;
        DNode pre=head;
        while(cur.data!=data && cur.next!=null)
        {
            pre=cur;
            cur=cur.next;
        }
        if(cur.next!=null)
        {
            pre.next=cur.next;
            cur.next.prev=pre;
        }
        else {
           pre.next=null;
           cur.prev=null;
        }
        return head;
    }
    static DNode delete(DNode head, int data)
    {
        if(head==null)
        {
            return null;
        }
        else {
            if(head.data==data)
            {
                head=head.Delete_head(head);
                return head;
            }
            else {
                head=head.Delete_given_Node(head,  data);
               return head;
            }
        }
    }

    // Searching the Node is Present in Linked List or Not

    static boolean search_node(DNode head, int data)
    {
        if(head==null)
        {
            return false;
        }
        else {
            DNode cur=head;
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


    // Sort the given linked list

    static DNode middle(DNode head)
    {
       DNode sp = head;
       DNode fp = head;
        while(fp.next!=null && fp.next.next!=null)
        {
            sp=sp.next;
            fp=fp.next.next;
        }
        return sp;
    }

    static DNode merge_DL(DNode left, DNode right)
    {
        DNode res=null;

        if(left==null) return right;
        if(right==null) return left;

        if(left.data<right.data)
        {
            res=left;
            res.next=merge_DL(left.next, right);
            res.next.prev=res;
            res=res.next;
        }
        else if(left.data>right.data) {
            res=right;
            res.next=merge_DL(left, right.next);
            res.next.prev=res;
            res=res.next;
        }
        else {
            res=right;
            res.next=merge_DL(left.next, right.next);
            res.next.prev=res;
            res=res.next;
        }
        return res;
    }

    static DNode sort_DL(DNode head)
    {
        // Applying Merge Sort
        if(head==null || head.next==null)
        {
            return head;
        }

        DNode mid = middle(head);
        DNode head2=mid.next;
        mid.next=null;
        head2.prev=null;

        return merge_DL(sort_DL(head), sort_DL(head2));
    }

    // Reverse the linked list
    static DNode reverse_DL(DNode head)
    {
        if(head==null || head.next== null)
        {
            return head;
        }
        DNode pre=null;
        DNode cur=head;
        DNode nex=head;

        while(cur!=null)
        {
            nex=cur.next;
            cur.next=pre;
            cur.prev=nex;
            pre=cur;
            cur=nex;
        }
        return pre;
    }

    // Traversing the linked list
    static void Print(DNode head)
    {
        DNode cur=head;
        if(cur==null)
        {
            System.out.println("null");
        }
        else {
            while(cur!=null)
            {
                System.out.print(cur.data+"->");
                cur=cur.next;
            }
            System.out.println("null");
        }
    }
}


public class dubly_LL_Implementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        DNode head= new DNode();

        // Inserting the Node into linkesd list
        System.out.println("-----  Enter the Node into linked list  -----");
        for(int i=0; i<10; i++)
        {
            int data=sc.nextInt();
            head=head.insert(head,data);
        }
        head=head.next;
        System.out.println("Traversing......");
        head.Print(head);

        // Deleting the Node from linked list
        System.out.println("Deleting The Head of linked list");
        head=head.Delete_head(head);  // delete head of linked list
        head.Print(head);
        System.out.println("Deleting The Middle of linked list");
        head=head.Delete_middle(head);  // delete middle of linked list
        head.Print(head);
        System.out.println("Deleting The Tail Node of linked list");
        head=head.Delete_last(head);  // delete last node of linked list
        head.Print(head);

        // Give Node value to delete that Node
        System.out.print("Enter element u want to delete: ");
        int ele=sc.nextInt();
        head=head.delete(head,ele);
        head.Print(head);

        // Searching the Node is Present or Not

        System.out.print("Enter element u want to Search: ");
        int sele=sc.nextInt();
        System.out.println(head.search_node(head,sele));

        // reversing the doubly linked list
        System.out.println("Reverse Doubly linked List");
        head=head.reverse_DL(head);
        head.Print(head);

        // Sorting the Linked list
        System.out.println("Sorting the Linked list");
        head=head.sort_DL(head);
        head.Print(head);


    }
}
