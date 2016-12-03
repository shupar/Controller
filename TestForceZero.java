import java.util.*;
public class TestForceZero
{
  public static void main(String[]args)
  {
    Scanner reader=new Scanner(System.in);
    double disturbanceStart=1;
    
     Boolean pass1=false;
      while(!pass1)
      {
        System.out.println("Enter the number zero: ");
        disturbanceStart=reader.nextDouble();
        if (disturbanceStart!=0)
        {
          pass1=false;
          System.out.println("You didnt input 0 for your disturbance start time. Please try again.");
        }
        else if(disturbanceStart==0)
        {
          System.out.println("Your disturbance start time is "+disturbanceStart+"s.");
          pass1=true;
        }
      }
    reader.close();
    
  }
  
  
  
}//end class