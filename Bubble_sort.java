import java.util.*;
public class Bubble_sort {
    // Implementing The Bubble Sort Using ArrayList
    static void Bubl_Sort(List<Integer>lst)
    {
        boolean flag = false;
        for (int i=0; i<lst.size()-1; i++)
        {
            for (int j=0; j<lst.size()-i-1; j++)
            {
                if(lst.get(j)>lst.get(j+1))
                {
                    flag=true;
                    int temp=lst.get(j+1);
                    lst.set(j+1,lst.get(j));
                    lst.set(j,temp);
                }
            }
            if(flag==false)
            {
                break;
            }
        }
        System.out.println(lst);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer>lst=new ArrayList<>();
        for(int i=0; i<6; i++)
        {
            System.out.println("enter ele: ");
            int ele=sc.nextInt();
            lst.add(ele);
        }
        Bubl_Sort(lst);
    }
}
