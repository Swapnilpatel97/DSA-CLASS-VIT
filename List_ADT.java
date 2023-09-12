import java.util.*;

class List_Implementation{
    int size;
    int[] arr=new int[100];
    int ptr=0;
    List_Implementation(int size)
    {
        this.size=size;
        int [] arr=new int[size];
    }

    // Adding the element in the array
    void add(int ele)
    {
        arr[ptr]=ele;
        ptr++;
    }

    // Setting the element int the specific index
    void set(int ind, int ele)
    {
        for(int i=ptr+1; i>=ind; i--)
        {
            arr[i]=arr[i-1];
        }
        arr[ind-1]=ele;
    }
    // Deleting the element from the list
    void remove(int ele)
    {
        int ind=0;
        for(int i=0; i<ptr+1; i++)
        {
            if(ele==arr[i])
            {
                ind=i;
                break;
            }
        }
        for(int i=ind; i<ptr+1;i++)
        {
            arr[i]=arr[i+1];
        }
        ptr--;
    }

    // Displaying The List

    void display()
    {
        System.out.print("[ ");
        for (int i=0; i<ptr+1; i++)
        {
            System.out.print(arr[i]+", ");
        }
        System.out.print("]");
        System.out.println();
    }

    // Element preset in the list or not

    boolean isPresent(int ele)
    {
        for(int i=0; i<ptr+1; i++)
        {
            if(arr[i]==ele)
            {
                return true;
            }
        }
        return false;
    }

    // Size of the List
    int size()
    {
        return ptr+1;
    }

}

public class List_ADT {

    public static void main(String[] args) {
        // Testing the Mnual Implemented List

        List_Implementation lst=new List_Implementation(100);
        Scanner sc=new Scanner (System.in);
        for(int i=0; i<5; i++)
        {
            int ele=sc.nextInt();
            lst.add(ele);
        }
        lst.remove(5);
        System.out.println(lst.isPresent(2));
        lst.set(2,10);
        lst.display();
        System.out.println(lst.size());

    }
}
