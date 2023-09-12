import java.util.*;

class stack
{
    int []arr;
    int size;
    int top;

    stack ()
    {
        this.size=0;
        this.top=-1;
    }

    stack (int size)
    {
        this.size=size;
        arr=new int[size];
        this.top=-1;
    }

    //IsEmpty Function
    public boolean isEmpty()
    {
        if(top<0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    // Stack is full or not
    public boolean isFull()
    {
        if(top==size-1) return true;

        else return false;
    }

    // pushing the element into the stack

    public void push(int data)
    {
        if(isFull())
        {
            System.out.println("Can't Push the element ! Overflow");
        }
        else {
            top++;
            arr[top]=data;
        }
    }

    // Pop (deleting) the element

    public void pop()
    {
        if(isEmpty()) System.out.println("Can't Pop the element");
        else {
            arr[top]=0;
            top--;
        }
    }

    // Returning The Peak (Top) element
    public int peak()
    {
        if(isEmpty()) return Integer.MAX_VALUE;
        else {
            return arr[top];
        }
    }

    // Printing the stack elements

    public void display(stack st)
    {
        if(st.isEmpty()) System.out.println("NO Elements");
        else {
            int i=top;
            while(i>=0)
            {
                System.out.print(st.arr[i]+" ");
                i--;
            }
            System.out.println();
        }
    }




}



class stack_Imple_array {
    public static void main(String[] args) {

        stack st=new stack(10);
        Scanner sc= new Scanner(System.in);
        System.out.println("       Enter the elements into stack       ");
        for(int i=0; i<10; i++)
        {
            int data=sc.nextInt();
            st.push(data);
        }
        System.out.println("Displaying the stack elements");
        st.display(st);

        System.out.println("Poping the element");
        st.pop();
        st.display(st);

        System.out.print("Peak element (top):- ");
        System.out.println(st.peak());

        // Cheking isempty of isfull
        System.out.println("IsEmpty "+st.isEmpty());
        System.out.println("IsFull "+st.isFull());

    }
}
