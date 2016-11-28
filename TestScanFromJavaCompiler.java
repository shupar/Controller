import java.util.*;

public class TestScanFromJavaCompiler
{
  public static void main (String[]args)
  {    
    Scanner reader=new Scanner(System.in);
    boolean exit=false;
    int choice=0;
    
    do
    {
      exit=false;
      while(!exit)
      {
        try
        {
          System.out.println("Please enter 1 into the java compile if you would like to proceed or 2 if you would like to reevaluate the amount of iterations to simulate.");
          choice=reader.nextInt();
          exit=true;
        }
        
        catch(InputMismatchException e)
        {
          reader.nextLine();
          System.out.println("You did not select option 1 or 2 (entered as an integer). Please enter 1 to proceed with the rest of the code or 2 to reevaluate the number of iterations.");
        }
          
      }//end catch for user's selection
    }while(choice!=1&&choice!=2);
      
    reader.close();
  }//end main
  
}//end class