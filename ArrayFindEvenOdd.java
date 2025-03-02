/*
3. Write a java program to pass the array function name as findEvenOdd( ), then display the even and odd number in array.
*/

import java.util.Scanner;
public class ArrayFindEvenOdd
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   int a[]=new int[5];

   System.out.println("Enter the values in array");
   for(int i=0; i<a.length; i++)
   {
     a[i]=sc.nextInt();
   }
   
   findEvenOdd(a);
   
 }

 public static void findEvenOdd(int a[])
 {
   System.out.println("Even numbers in the array: ");
   for(int i=0; i<a.length; i++)
   {
     if(a[i]%2==0)
     {
       System.out.print(a[i]+" ");
     }
     
   }
  

   System.out.println("\nOdd numbers in the array: ");
   for(int i=0; i<a.length; i++)
   {
     if(a[i]%2!=0)
     {
       System.out.print(a[i]+" ");
     }
     
   }
 }
}