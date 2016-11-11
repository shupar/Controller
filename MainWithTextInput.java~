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
    
    int n1=inputStream.nextInt();
    int n2=inputStream.nextInt();
    
    inputStream.nextLine();//move to next line
    
    String line=inputStream.nextLine();//read whole next line
    
    System.out.println(n1+", "+n2+", "+line);
    
    inputStream.close();
    
    
  }//end main
  
  
  
}//end text input class