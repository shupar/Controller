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
    
    //Scanning for process to simulate
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for system selection. Plz modify the text file and try again.");
      return;
    }
    int systemSelection=inputStream.nextInt();
    
    if (systemSelection==1)
    {
      
    }//add code for CSTR heating
    else if(systemSelection==2)
    {
      
    }//add code for level system
    else 
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the process you would like to simulate.");
      return;
    }
    inputStream.nextLine();
    
    //scanning for type of input signal to impose on selected process
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for input signal. Plz modify the text file and try again.");
      return;
    }
    int inputSignal=inputStream.nextInt();
    inputStream.nextLine();
    //System.out.println(inputSignal);
    
    //if user choses a step change, scan for step
    int stepChange=0;
    if (inputSignal==1)
    {
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an rounded (integer) value for your desired step. Plz modify the text file and try again.");
      return;
      }
      stepChange=inputStream.nextInt();
    }
    
    //if user selects disturbance, scan for dusturbance magnitude and time
    int disturbanceMag=0;
    int disturbanceStart=0;
    int disturbanceEnd=0;
 
    if (inputSignal==2)
    {
      inputStream.nextLine();
      
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an rounded (integer) value for your disturbance magnitude. Plz modify the text file and try again.");
      return;
      }
      disturbanceMag=inputStream.nextInt();
      
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an rounded (integer) value for the start time of your disturbance. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      return;
      }
      disturbanceStart=inputStream.nextInt();
      
      System.out.println(disturbanceMag);
      
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an rounded (integer) value for the end time of your disturbance. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      return;
      }
      disturbanceEnd=inputStream.nextInt();
    }
    else
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the type of change you would like to invoke on your process.");
      return;
    }
      
      System.out.println(disturbanceMag+disturbanceStart+disturbanceEnd);
    
   /* inputStream.nextLine();//move to next line
    
    String line=inputStream.nextLine();//read whole next line
    
    inputStream.close();
    
    while(!inputStream.hasNextInt())
    {
      inputStream.next();
      System.out.println("You did not enter an integer for system selection. plz modifie the text file and try again");
      return;
    }
    int num=inputStream.nextInt();
    System.out.println("You finally entered an integer value of: "+num);*/
    
  }//end main
  
  
  
}//end text input class