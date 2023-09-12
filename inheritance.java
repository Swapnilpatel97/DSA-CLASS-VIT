import java.util.*;
/*
Single Inheritance

super Keyword:- super.superClassVariable;
                super.superclassMethod;
use this when u have to call superclass constructor
    super(#parameters);
 */

// Super class
class superclass
{
  int supAge;
  String supName;



    public superclass(int supAge, String supName)
    {
        this.supAge=supAge;
        this.supName=supName;
    }
  void  print_details()
  {
      System.out.println(supAge);
      System.out.println(supName);
  }
}

// Sub class

class subclass extends superclass{
    String subFavColr;

    public subclass(int age, String name, String subFavColr) {
        super(age,name); // to  call super class constructor
        this.subFavColr=subFavColr;
    }

    void subclass(String subFavColr)
    {
        this.subFavColr=subFavColr;
    }
    void  print_details(){
        System.out.println(supAge);
        System.out.println(supName);
        System.out.println(subFavColr);
    }
}

public class inheritance {
    public static void main(String[] args) {

        subclass obj1=new subclass(21,"Swapnil Patel","Pink");
       //  obj1.subFavColr="Pink";
       //  obj1.supAge=30;
       //  obj1.supName="Swapnil Patel";
        obj1.print_details();
    }
}
