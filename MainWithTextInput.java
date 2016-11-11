import java.util.*;
import java.io.*;

public class MainWithTextInput
{
  public static void main (String[] args)
  {
    Scanner inputStream=null;
   
    try
    {
      inputStream=new Scanner(new FileInputStream("UserInput.txt"));
    }//end try
    
    catch (FileNotFoundException e)
    {
      System.out.println("There was an error accessing the UserInput.txt file! Please check that it does in fact exist and it is not open a the moment.");
      System.exit(0);
    }//end catch
    
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer for system selection. Plz modify the text file and try again.");
      return;
    }
    int systemSelection=inputStream.nextInt();
    
    if (systemSelection==1)
    {
      
    }//add code for CSTR heating
    else if(systemSelection==2)
    {
      
    }//ad code for level system
    else 
    {
      System.out.println("Please chose either 1 or 2 depending on the process you would like to simulate.");
    }
    
    inputStream.nextLine();
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer for input signal. Plz modify the text file and try again.");
      return;
    }
    int inputSignal=inputStream.nextInt();
    inputStream.nextLine();
    
    if (inputSignal==1)
    {
      double stepChange=inputStream.nextDouble();

    }
    else if (inputSignal==2)
    {
      double
      
    }
    
    
    int =inputStream.nextInt();
    int =inputStream.nextInt();
    
    inputStream.nextLine();//move to next line
    
    String line=inputStream.nextLine();//read whole next line
    
    System.out.println(n1+", "+n2+", "+line);
    
    inputStream.close();
    
    while(!inputStream.hasNextInt())
    {
      inputStream.next();
      System.out.println("You did not enter an integer for system selection. plz modifie the text file and try again");
      return;
    }
    int num=inputStream.nextInt();
    System.out.println("You finally entered an integer value of: "+num);
    
  }//end main
  
  
  
}//end text input class