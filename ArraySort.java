/*1. Write program to create array of size and arrange all values in ascending & descending order?
import java.util.Scanner;
public class ArraySort
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    
    int a[]=new int[5];

    System.out.println("Enter the values in array:");
    for(int i=0; i<a.length; i++)
    {
        a[i]=sc.nextInt();
    }

     System.out.println("Display the original array:");
     for(int i=0; i<a.length; i++)
     {
       System.out.println(a[i]);
     } 

     //sort the array in asc order
     for(int i=0; i<a.length; i++)
     {
        for(int j=i+1; j<a.length; j++)
        {
          if(a[i]>a[j])
          {
             int temp=a[i];
                 a[i]=a[j];
                 a[j]=temp;
          }
        }
     }
     System.out.println("display the asc array");
     for(int i=0; i<a.length; i++)
     {
         System.out.println(a[i]);
     }

    //sort array des order
    for(int i=0; i<a.length; i++)
    {
      for(int j=i+1; j<a.length; j++)
      {
        if(a[i]<a[j])
        {
          int temp=a[i];
              a[i]=a[j];
              a[j]=temp;
        }
      }
    }

    System.out.println("Display the dec array");
    for(int i=0; i<a.length; i++)
    {
       System.out.println(a[i]);
    }
  }
}*/
import java.util.Scanner;
public class ArraySort
{
public static void printarrayFun(int a[])
{
  //System.out.println("display the array");
     for(int i=0; i<a.length; i++)
     {
         System.out.println(a[i]);
     }
}
//fun of asc
public static void ascarray(int a[])
{
    

     //sort the array in asc order
     System.out.println("Display the asc array");
     for(int i=0; i<a.length; i++)
     {
        for(int j=i+1; j<a.length; j++)
        {
          if(a[i]>a[j])
          {
             int temp=a[i];
                 a[i]=a[j];
                 a[j]=temp;
          }
        }
     }

}
//fun of dec
public static void desarray(int a[])
{
    

     //sort the array in desc order
     System.out.println("Display the dec array");
     for(int i=0; i<a.length; i++)
     {
        for(int j=i+1; j<a.length; j++)
        {
          if(a[i]<a[j])
          {
             int temp=a[i];
                 a[i]=a[j];
                 a[j]=temp;
          }
        }
     }

}

  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    
    int a[]=new int[5];

    System.out.println("Enter the values in array:");
    for(int i=0; i<a.length; i++)
    {
        a[i]=sc.nextInt();
    }

    printarrayFun(a);
    desarray(a);
    printarrayFun(a);
    ascarray(a);
    printarrayFun(a);
    

}
}