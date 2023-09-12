import java.util.*;
public class Array_Operations {
    // Insert Element at Kth Index
    static void insert_At_Kth_index(int[] arr, int idx, int ele)
    {
        if(idx>arr.length-1)
        {
            System.out.println("Cannot Insert at this index , array Out Of Bound ");
        }
            arr[idx]=ele;
    }

    // Delete Elements of Array
    static void delete_array(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            arr[i]=0;
        }
    }

    // Searching Element and Printing Index of that element
    static int search_element(int[] arr, int ele)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==ele)
            {
                return i;
            }
        }
        return -1;
    }

    // Counting the Element How Many times Occur

    static void count_element_duplicate(int[] arr, int ele)
    {
        int cnt=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==ele)
            {
                cnt++;
            }
        }
        System.out.println(+ele+" Prsent "+cnt+" times");
    }

    // Printing the Array
    static void Print(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size of Array:- ");
        int n=sc.nextInt();
        int []arr=new int[n];
        Print(arr);
        for (int i=0; i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        // Insert Element at Kth Index
        System.out.print("Enter index where u want to insert:-");
        int idx=sc.nextInt();
        System.out.println();
        System.out.print("Enter Element u want to insert:-");
        int ele=sc.nextInt();
        insert_At_Kth_index(arr,idx, ele);
        Print(arr);

        // Searching Element and Printing Index of that element
        System.out.print("Enter element u want to serch :- ");
        int search_ele=sc.nextInt();
        int ele_idx=search_element(arr,search_ele);
        System.out.println(search_ele+" Present at index "+ ele_idx);

        // Counting the Element How Many times Occur
        System.out.print("Enter Element for how many times it is present in array:- ");
        int cnt_ele=sc.nextInt();
        count_element_duplicate(arr,cnt_ele);

        // Delete Elements of Array
        System.out.println("After deleting the all Array Elements");
        delete_array(arr);
        Print(arr);
    }
}
