import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestScan
{
  public static void main (String[]args)
  {
    System.out.println("I will read from a pre-made text file");
    Scanner inputStream=null;
    
    try
    {
      inputStream=new Scanner(new FileInputStream("ScanTest.txt"));
      
    }//end try
    
    catch (FileNotFoundException e)
    {
      System.out.println("File not found/could not be opened");
      System.exit(0);
      
    }//end catch
 
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer for system selection. plz try again");
      
     return;
    }
    int num=inputStream.nextInt();
    System.out.println("You finally entered an integer value of: "+num);
    
    if(num<0)
      System.out.println("your first number is negative!");
   
    int n1=inputStream.nextInt();
    int n2=inputStream.nextInt();
    
    inputStream.nextLine();//move to next line
    
    String line=inputStream.nextLine();//read whole next line
    
    System.out.println(n1+", "+n2+", "+line);
    
    inputStream.close();
   
  }//end main

}//end testscan class