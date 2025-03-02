//fibonac

public class FibboRec
{
  public static void main(String args[])
  {
     int lim=6;
     fibRec(6);
  }
   public static int first=0;
   public static int second=1;
   public static int  next;
  public static void fibRec(int lim)
  {
   
    if(lim>0)
    {
      System.out.print(first+"  ");

      next=first+second;
      first=second;
      second=next;
      fibRec(--lim);
     }
    
   }
 
}