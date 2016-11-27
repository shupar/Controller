import java.util.*;
import java.io.*;

public class MainWithTextInput
{
  public static void main (String[] args)
  {
    //creating a scanner object that will communicate with the text input file
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
      inputStream.close();
      return;
    }
    int systemSelection=inputStream.nextInt();
    
    //confirm process or ask user to pick from given options
    if (systemSelection==1)
    {
      System.out.println("The system you have selected is the CSTR heating system.");
    }
    else if(systemSelection==2)
    {
      System.out.println("The system you have selected is the level control system.");
    }
    else 
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the process you would like to simulate.");
      inputStream.close();
      return;
    }
  
     //input time increment
    int iterations=0;
    inputStream.nextLine();
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double value for the time increment. Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
    double timeInc=inputStream.nextDouble();
    
    if (timeInc<0)
    {
      System.out.println("You did not enter a valid time (bigger than 0s). Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
    }
    System.out.println("Your chosen time increment is: "+timeInc);
     
    //input runtime 
    inputStream.nextLine();
    while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an integer type value for the run time of your simulation. Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
    int runTime=inputStream.nextInt();
    
    if (runTime<0)
    {
      System.out.println("You did not enter a valid run time (bigger than 0s). Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
    }
     
    double x = runTime / timeInc;
    int xint;
    xint=(int)x;
    double resultx = runTime - timeInc * xint;
    
    if(resultx!=0)
     {
       System.out.println("Your run time is not a multiple of your time increment...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
    System.out.println("Your chosen run time increment is: "+runTime);
    
    if(timeInc>=runTime)
    {
      System.out.println("Your time increment is larger than or equal to your simulation runtime. You should reconsider how often you would like to iterate.");
      inputStream.close();
      return;
    }
    else 
    {
      Scanner reader=new Scanner(System.in);
      boolean exit=false;
      int choice=0;
      iterations=(int)(runTime/timeInc);
      
      System.out.println("For your set run time of "+runTime+"s and time increment of "+timeInc+"s for each iteration, the program will compute "+iterations+".");
     
      do
    {
      exit=false;
      while(!exit)
      {
        try
        {
          System.out.println("Please enter 1 into the java compiler if you would like to proceed or 2 if you would like to reevaluate the amount of iterations to simulate.");
          choice=reader.nextInt();
          exit=true;
        }
        
        catch(InputMismatchException e)
        {
          reader.nextLine();
          System.out.println("You did not select option 1 or 2 (entered as an integer).");
        }
      }
    }while(choice!=1&&choice!=2);
    //end catch for user's selection of how to proceed
           
      if(choice==2)
      {
        reader.close();
        System.out.println("Proceed to the text file to change your time specifications then come back to compile and run once more.");
        inputStream.close();
        return;
      }
      else
      {
        reader.close();
      }
    }
 
    //scanning for type of input signal to impose on selected process
   inputStream.nextLine();
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for input signal. Plz modify the text file and try again.");
      inputStream.close();
      return;
    }
    int inputSignal=inputStream.nextInt();
    
    inputStream.nextLine();
        
    double setPoint=0;
    double startSetPoint=0;
    double disturbanceMag=0;
    double disturbanceStart=0;
    double disturbanceEnd=0;
    
    //if user choses a step change, scan for step and start time of step
    if (inputSignal==1)
    {
      System.out.println("You have chosen to invoke a change in setpoint on your selected process.");
      
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an interger or double type value for your desired setpoint. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
      setPoint=inputStream.nextDouble();
      
      if(setPoint<0)
     {
        System.out.println("Your set point change is below 0K if you chose the CSTR of below Om if you chose the distillation column...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an interger value for your desired start set point time. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
      startSetPoint=inputStream.nextDouble();
      
      //ask user to try again is set point start is after the runtime and is setpoint start is not a multiple of timeInc
      if(startSetPoint>runTime)
      {
        System.out.println("Your start of set point change is after your process run time...  Please reconsider the timing of your input signal and try again.");
        inputStream.close();
        return;
      }
      else if(startSetPoint<0)
     {
        System.out.println("Your stat of set point change is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      
    double y = startSetPoint / timeInc;
    int yint;
    yint=(int)y;
    double resulty = startSetPoint - timeInc * yint;
    
     if(resulty!=0)
     {
       System.out.println("Your start of set point change is not a multiple of your time increment...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
         
      System.out.println("The step change you have chosen is "+setPoint+"and will commence at t = "+startSetPoint+"s.");
      
      //ensure user does not enter a disturbance since they have selected a change in step point
      inputStream.nextLine();
      Boolean pass=false;
      while(!pass)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your disturbance magnitude. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        disturbanceMag=inputStream.nextDouble();
        if (disturbanceMag!=0)
        {
          pass=false;
          System.out.println("You didnt input 0 for your disturbance magnitude. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(disturbanceMag==0)
        {
          System.out.println("Your disturbance magnitude value is 0.");
          pass=true;  
        }
      }
      
      inputStream.nextLine();
      Boolean pass1=false;
      while(!pass1)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your disturbance start time. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        disturbanceStart=inputStream.nextDouble();
        if (disturbanceStart!=0)
        {
          pass1=false;
          System.out.println("You didnt input 0 for your disturbance start time. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(disturbanceStart==0)
        {
          System.out.println("Your disturbance start time is "+disturbanceStart+"s.");
          pass1=true;
        }
      }
      
      inputStream.nextLine();
      Boolean pass2=false;
      while(!pass2)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your disturbance end time. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        disturbanceEnd=inputStream.nextDouble();
        if (disturbanceEnd!=0)
        {
          pass2=false;
          System.out.println("You didnt input 0 for your disturbance end time. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(disturbanceEnd==0)
        {
          System.out.println("Your disturbance end time is "+disturbanceEnd+"s.");
          pass2=true;
        }
      }
    }
    
   
    //if user selects disturbance, ensure they did not set values for setPoint change
    else if (inputSignal==2)
    {
      System.out.println("You have chosen to invoke a disturbance on your selected process.");
     
      Boolean pass3=false;
      while(!pass3)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your change in set point. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        setPoint=inputStream.nextDouble();
        if (setPoint!=0)
        {
          pass3=false;
          System.out.println("You didnt input 0 for your change in set point. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(setPoint==0)
        {
          System.out.println("Your setPoint value is 0.");
          pass3=true;  
        }
      }
      
      inputStream.nextLine();
      Boolean pass4=false;
      while(!pass4)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your change in setpoint start time. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        startSetPoint=inputStream.nextDouble();
        if (startSetPoint!=0)
        {
          pass4=false;
          System.out.println("You didnt input 0 for your change in setpoint start time. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(startSetPoint==0)
        {
          System.out.println("Your change in setpoint start time is "+startSetPoint+"s.");
          pass4=true;
        }
      }
      
      //input disturbance values
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double type value for your disturbance magnitude. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
      disturbanceMag=inputStream.nextDouble();
      
      if(disturbanceMag>0)
     {
        System.out.println("This is a heating system! you therefore need to COOL your system (enter a negative disturbance magnitude) with your chosen disturbance...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for the start time of your disturbance. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
      disturbanceStart=inputStream.nextDouble();
      
      if(disturbanceStart<0)
     {
        System.out.println("Your start of disturbance is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
    
      double z = disturbanceStart / timeInc;
    int zint;
    zint=(int)z;
    double resultz = disturbanceStart - timeInc * zint;
    
     if(resultz!=0)
     {
        System.out.println("Your start of disturbance is not a multiple of your time increment...  Please modify the text file and try again.");
        inputStream.close();
        return;
     } 
      
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for the end time of your disturbance. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
      disturbanceEnd=inputStream.nextDouble();
      
      if(disturbanceEnd<0)
     {
        System.out.println("Your end of disturbance is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      
    double a = disturbanceEnd / timeInc;
    int aint;
    aint=(int)a;
    double resulta = disturbanceEnd - timeInc * aint;
    
     if(resulta!=0)
     {
        System.out.println("Your end of disturbance is not a multiple of your time increment...  Please modify the text file and try again.");
        inputStream.close();
        return;
     } 
     
    }
    //if user enters an int but not one of the choices for input signal
    else
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the type of change (input signal) you would like to invoke on your process.");
      inputStream.close();
      return;
    }
    
    if (disturbanceStart>disturbanceEnd)
    {
     System.out.println("Your disturbance start time must come before your disturbance end time!! Plz modify the text file and try again."); 
     inputStream.close();
     return;
    }
    System.out.println("The disturbance magnitude you have chosen is "+disturbanceMag+"and will commence at t = "+disturbanceStart+"s and will end at t = "+disturbanceEnd+"s.");

    //code to read valve details
    inputStream.nextLine();
    double kV=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for the gain of the valve you are using. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
    kV=inputStream.nextDouble();
    System.out.println("The gain of the valve is: "+kV);
    
    inputStream.nextLine();
    double tauV=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for the time constant of your valve. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
    tauV=inputStream.nextDouble();
    System.out.println("The time constant of your valve is: "+tauV);

    //code to read what type of controller to simulate
    inputStream.nextLine();
    String controller=inputStream.next();
    //System.out.println("The controller type you have chosen is: "+controller);
    
    while(!controller.equals("P")&&!controller.equals("I")&&!controller.equals("D")&&!controller.equals("PI")&&!controller.equals("PD")&&!controller.equals("ID")&&!controller.equals("PID"))
    {
      System.out.println("You did enter a valid type of controller. Please go back into the text file and modify your choice.");
      inputStream.close();
      return;      
    }
    
      //what to do next as a function of user controller choice
    double kC=0;
    double kCP=0;
    double tauI=Math.pow(10, 100);//large number to cancel out term
    double tauD=0;
    
    //for P only type controller
    if (controller.equals("P"))
      {
        inputStream.nextLine();
       while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
       inputStream.nextLine();
      Boolean pass1=false;
      while(!pass1)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your integral time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        if (tauI!=0)
        {
          pass1=false;
          System.out.println("You didnt input 0 for your integral time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauI==0)
        {
          tauI=Math.pow(10, 100);
          System.out.println("Your integral time constant was set to a very large number of "+tauI+" in order to be able to cancel the integral term.");
          pass1=true;
        }
      }
      
      inputStream.nextLine();
      Boolean pass2=false;
      while(!pass2)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your derivative time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        if (tauD!=0)
        {
          pass2=false;
          System.out.println("You didnt input 0 for your derivative time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauD==0)
        {
          System.out.println("Your change in setpoint start time is "+tauD+".");
          pass2=true;
        }
      }
    }
    
     //for I only type controller    
      else if(controller.equals("I"))
      {
      inputStream.nextLine();
       while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or double for your controller gain. Please modify the text file and try again.");//CHECK!!!!!!!!!!!!!
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        System.out.println("Your controller gain is "+kC+". Note: this is not a proportional gain.");
        
      inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
      inputStream.nextLine();
      Boolean pass4=false;
      while(!pass4)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your derivative time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        if (tauD!=0)
        {
          pass4=false;
          System.out.println("You didnt input 0 for your derivative time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauD==0)
        {
          System.out.println("Your change in setpoint start time is "+tauD+".");
          pass4=true;
        }
      }  
     }
      
     //for D only type controller
      else if(controller.equals("D"))
      {
         inputStream.nextLine();
         while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or double for your controller gain. Please modify the text file and try again.");//CHECK!!!!!!!!!!!!!
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();

        System.out.println("Your controller gain is "+kC+". Note: this is not a proportional gain.");
           
      inputStream.nextLine();
      Boolean pass6=false;
      while(!pass6)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your integral time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        if (tauI!=0)
        {
          pass6=false;
          System.out.println("You didnt input 0 for your integral time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauI==0)
        {
          tauI=Math.pow(10, 100);
          System.out.println("Your integral time constant was set to a very large number of "+tauI+" in order to be able to cancel the integral term.");
          pass6=true;
        }
      }
        
      inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
      }
      
      //for PI controller type
      else if(controller.equals("PI"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
      inputStream.nextLine();
      Boolean pass7=false;
      while(!pass7)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your derivative time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        if (tauD!=0)
        {
          pass7=false;
          System.out.println("You didnt input 0 for your derivative time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauD==0)
        {
          System.out.println("Your change in setpoint start time is "+tauD+".");
          pass7=true;
        }
      } 
    }
      //for PD type controller
      else if(controller.equals("PD"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
      inputStream.nextLine();
      Boolean pass8=false;
      while(!pass8)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your integral time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        if (tauI!=0)
        {
          pass8=false;
          System.out.println("You didnt input 0 for your integral time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauI==0)
        {
          tauI=Math.pow(10, 100);
          System.out.println("Your integral time constant was set to a very large number of "+tauI+" in order to be able to cancel the integral term.");
          pass8=true;
        }
      }
      
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD); 
      }
      
      //for ID controller type
      else if(controller.equals("ID"))
      {
         inputStream.nextLine();
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or double for your controller gain. Please modify the text file and try again.");//CHECK!!!!!!!!!!!!!
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();

        System.out.println("Your controller gain is "+kC+". Note: this is not a proportional gain."); 
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI); 
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
      }
      else if(controller.equals("PID"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
      }
     
      //input process parameters for CSTR heating
      double initialT=0;
      double rho=0;
      double vol=0;
      double flow=0;
      double cP=0;
      
      //input parameters for the distillation column
     double d=0;
     double rho2=0;
     double lFlow=0;
     double vFlow=0;
     double blank=0;//there is only 5 necessary params in the level control therefore we will force user to enter 0 in the last parameter slot
     
      
     if(systemSelection==1)
     {      
      //T initial [K]
      inputStream.nextLine();     
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the initial temperature or your process. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      initialT=inputStream.nextDouble();
      
      if(initialT<0)
     {
        System.out.println("Your temperature is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      else if (initialT>2000)
      {
        System.out.println("Just letting you know you're initial temperature is above the melting point of carbon steel..... You may want to reconsider what you're doing... :P");
      }
      System.out.println("The initial temperature of your process is: "+initialT+"K.");
     
      //density of the fluid in the system [kh/m3]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the density of your process fluid. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      rho=inputStream.nextDouble();
      
      if(rho<500)
     {
        System.out.println("Your fluid density is below 500kg/m3... You probably arent operating with a liquid, which is necessary for this system to function... Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      System.out.println("The density of your process fluid is: "+rho+"kg/m3.");
      
      //volume of the tank [m3]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the volume of your process' tank. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      vol=inputStream.nextDouble();
      
      if(vol<0)
     {
        System.out.println("Your volume is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      
      System.out.println("The volume of your process' tank is: "+vol+"m3.");
      
      //flow rate [kg/s]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the mass flow rate or your process. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      flow=inputStream.nextDouble();
      
      if(flow<0)
     {
        System.out.println("Your mass flow rate is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      double volumeForFlow=flow/rho;
      if(volumeForFlow>vol)
      {
        System.out.println("Your tank volume cant hold the amount of fluid you want to run through your system. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      System.out.println("The mass flow rate of your process is: "+flow+ "kg/s.");
      
      //heat capacity [kJ/kg*K]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the heat capacity or your process. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      cP=inputStream.nextDouble();
      if(cP<0)
     {
        System.out.println("Your heat capacity is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      System.out.println("The heat capacity of your process is: "+cP+"kJ/kg*K.");
     
      if(inputSignal==1&&setPoint<initialT)
     {
        System.out.println("The CSTR process is a HEATING process not a REFRIGERATING system...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      else if(inputSignal==2&&(disturbanceMag+initialT)<0)
      {
        System.out.println("Your chosen disturbance magnitude will result in a temperature below absolute zero...  Please modify the text file and try again.");
        inputStream.close();
        return;
      }
    
     }
     
     //input variables for the distillation column
    
     else if(systemSelection==2)
     {  
      //column diameter [m]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for your process' tank diameter. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      d=inputStream.nextDouble();
      if(d<0)
     {
        System.out.println("Your diameter is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      System.out.println("The diameter of your column is: "+d+"m.");
      
      //density of the fluid in the system {kg/m3}
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the density of your process fluid. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      rho2=inputStream.nextDouble();
      
      if(rho2<0)
     {
        System.out.println("Your fluid density is below 0... Please modify the text file and try again.");
        inputStream.close();
        return;
     }
      System.out.println("The density of your process fluid is: "+rho2+"kg/m3.");
           
      //liquid flow {kg/s}
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for your process' liquid. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      lFlow=inputStream.nextDouble();
      if(lFlow<0)
     {
        System.out.println("Your liquid flow is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     }  
      System.out.println("The liquid flow of the fluid in your tank is: "+lFlow+"kg/s.");
          
      //vapour flow rate [kg/s]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the vapour flow rate or your process. Plz modify the text file and try again.");
        inputStream.close();
        return;
      }
      vFlow=inputStream.nextDouble();
      
      if(vFlow<0)
     {
        System.out.println("Your vapour flow is below 0...  Please modify the text file and try again.");
        inputStream.close();
        return;
     } 
      System.out.println("The vapour flow rate of your process is: "+vFlow+ "kg/s.");
       
      inputStream.nextLine();
      Boolean passing=false;
      while(!passing)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for the empty parameter in the level system. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        blank=inputStream.nextDouble();
        if (blank!=0)
        {
          passing=false;
          System.out.println("You didnt input 0 for the last parameter in the level system. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(blank==0)
        {
          passing=true;
        }
      }  
      if(inputSignal==2&&(disturbanceMag+lFlow)<0)
      {
        System.out.println("Your chosen disturbance magnitude will result in a negative flow...  Please modify the text file and try again.");
        inputStream.close();
        return;
      }
     }

     
      Scanner reader2=new Scanner(System.in);
      boolean exit=false;
      int choice2=0;
      
    do
    {
      exit=false;
      while(!exit)
      {
        try
        {
          System.out.println("All of your text file entries are listed above. If you are ready to proceed with the simulation using the displayed values, enter 1, if not enter 2 to change your input values.");
          choice2=reader2.nextInt();
          exit=true;
        }
        
        catch(InputMismatchException e)
        {
          reader2.nextLine();
          System.out.println("You did not select option 1 or 2 (entered as an integer).");
        }
      }
    }while(choice2!=1&&choice2!=2);
    reader2.close();
    //end catch for user's selection of how to proceed

    //creating controller objects
    Proportional proportional;
    if(controller.equals("I")||controller.equals("D")||controller.equals("ID"))//to cancel out the proportional error action send a value of Kc=0 (stored in kCP)
    {proportional=new Proportional(kCP);}
    else
    {proportional=new Proportional(kC);}
    
    Integral integral=new Integral(kC, tauI);
    Derivative derivative=new Derivative(kC, tauD);
    
    //creating process objects
    CSTRHeatingSystem cstr=new CSTRHeatingSystem(initialT, rho, vol, flow, cP);
    DistillationColumn column=new DistillationColumn(d, rho, lFlow, vFlow);//dont actually need to send blank cuz dont need to recieve the last parameter
   
        //call results depending on program
    Results results=new Results();    
    if(systemSelection==1)
    {    
      results.calculations(setPoint, disturbanceMag, disturbanceStart, disturbanceEnd, proportional, integral, derivative, cstr, startSetPoint,  iterations, timeInc, tauV, kV, systemSelection);
    }
    else if (systemSelection==2)
    {
      results.calculations(setPoint, disturbanceMag, disturbanceStart, disturbanceEnd, proportional, integral, derivative, column, startSetPoint, iterations,timeInc, tauV, kV, systemSelection);
    }
      
    
    System.out.println("Your results will be output into an excel file called FileOutput. Please ensure that when you open the file, you say YES to do I trust where it is coming from and YES to the use of delimiters to separate columns (with the use of tabs) and rows (with the use of the next line function).");
    
    inputStream.close();
    
   
  }//end main
  
}//end text input class