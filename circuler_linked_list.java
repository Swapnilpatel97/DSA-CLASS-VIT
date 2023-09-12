import java.util.*;

class CNode {
    int data;
    CNode next ;
    public CNode() {
        this.data = 0;
        this.next=null;
     next=null;
    }

    CNode(int data) {
        this.data = data;
        this.next=null;
    }
    // insert a node in circular linked list

    static CNode insert_node(CNode head,int data)
    {
        CNode newNode=new CNode(data);
        CNode cur=head;
        CNode pre=head;
       while(cur.next!=head)
       {
           pre=cur;
           cur=cur.next;
       }
       newNode.next=cur.next;
       cur.next=newNode;
       return  head;
    }

    // Deleting the Node by given data
    CNode delete_CLL(CNode head, int data)
    {
        if(head==null)
        {
            return null;
        }
        else {
            CNode cur = head;
            CNode pre =null;
            while(cur.next!=head)
            {
                if(cur.data==data)
                {
                    pre.next=cur.next;
                    break;
                }
                pre=cur;
                cur=cur.next;
            }
            return head;
        }
    }

    // Sorting the linked list

    static CNode sort_CLL(CNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        else {
            CNode cur=head;
            do
            {
                CNode temp=head;
                while (temp.next!=head)
                {
                    if(temp.data>cur.data)
                    {
                        int ele = temp.data;
                        temp.data = cur.data;
                        cur.data=ele;
                    }
                    temp=temp.next;
                }
                cur=cur.next;
            }while(cur.next!=head);
        }
        return head;
    }

    // Reversing the linked list

    static CNode reverse_CL(CNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        else {
            // getting previous node of head
            CNode pre=head;
            while(pre.next!=head)
            {
                pre=pre.next;
            }
            CNode cur=head;
            CNode nex=head;
            while(cur.next!=head)
            {
                nex=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nex;
            }
            // Now last Node point to first Node
            head.next=pre;
            head=pre;
            return head;
        }
    }

    // Traversing the linked list
    static void display(CNode head)
    {
        CNode cur=head;
        CNode temp=head;
        while(temp.next!=cur)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print(temp.data+" -> ");
        System.out.println("null");
    }
}

public class circuler_linked_list {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CNode head=new CNode(10);
        CNode cur=head;
        for(int i=0; i<8; i++)
        {
            int ele=sc.nextInt();
            CNode temp= new CNode(ele);
            cur.next=temp;
            cur=cur.next;
        }
        cur.next=head;
        head.display(head);

        // Inserting the data into the linked list
        System.out.println("inserting the node");
        head.insert_node(head,1000);
        head.display(head);

        // Delete Node of linked list
        System.out.println("Deleting the Node ");
        head=head.delete_CLL(head,5);
        head.display(head);

        // Sorting the linked list
        System.out.println("Sorting the linked list");
        head=head.sort_CLL(head);
        head.display(head);

        // Reversing the linked list
        System.out.println("Reversing the linked list");
        head=head.reverse_CL(head);
        head.display(head);


    }
}
