import java.util.*;

public class TestIntInputLoop
{
  
  public static void main(String[] args)
  {
    Scanner reader=new Scanner(System.in);
    System.out.println("Please enter an integer:");
    
    while(!reader.hasNextInt())
    {
      reader.next();
      System.out.println("That was not an integer, please try again:");
    }
    int num=reader.nextInt();
    System.out.println("You finally entered an integer value of: "+num);
    
    reader.close();
  
  }//end main
  
}//end class