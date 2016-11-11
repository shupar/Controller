import java.util.*;

public class MainInput
{
  Scanner reader=new Scanner(System.in);
  
  public static void main (String[] args)
  {
    int systemSelection=0, inputSignal=0;
    double step=0, setPoint=0, tol=0;
    int controllerSelection=0;//changed this from string to int for simplicity
    double propSignal=0, intSignal=0, derivSignal=0, finalSignal=0;
    double kC=0, tauI=0, tauD=0;

    System.out.println("Please indicate which process you would like to test.");
    System.out.println("Select \'1\' for CSTR Heating System.");
    System.out.println("Select \'2\' for Level System.");
    systemSelection=reader.nextInt();
    //variable "systemSelection" to save user choice of system (read off txt file)
    
    System.out.println("For this process, please indicate what kind of input signal to send to the system.");
    System.out.println("Select \'1\' for a step change.");
    System.out.println("Select \'2\' for a disturbance.");
    inputSignal=reader.nextInt();
    //variable "inputSignal" to save user choice of input signal (read off txt file)   
    
    System.out.println("Please enter the time increment between readings.");
    //variable "step" to save step size (read off txt file)   
    System.out.println("Please enter the desired set point for the process.");
    //variable "setPoint" to save setpoint (read off txt file)   
    System.out.println("Please select the minimum tolerance to be achieved before the system is considered stable.");
    //variable "tol" for tolerance between setpoint and measured value from process (read off txt file)   
    
    if (systemSelection==1)
    {
      //insert code to call CSTR process object
      //send input signal, set point, step and tolerance
    }
    else if (systemSelection==2)
    {
      //insert code to call level object
      //send input signal, set point, step and tolerance
    }
    else
    {
      //error message
    }
    
    System.out.println("Select your controller by indicating P, I, D or a combination of these.");
    System.out.println("Please ensure there are no spaces between the letters representing each action and that the letters are capitalized.");
    //variable "controllerSelection" to save user choice of controller action(s) (read off txt file)
    
    switch(controllerSelection)
    {
      case "P":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        //create object to call Proportional action and receive signal in return and save that value in "propSignal" variable
        break;
      case "I":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        System.out.println("Enter the value of tauI for your controller.");
        //use "tauI" variable to read this entry
        //create object to call Integral action and receive signal in return and save that value in "intSignal" variable        
        break; 
      case "D":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        System.out.println("Enter the value of tauD for your controller.");
        //use "tauD" variable to read this entry
        //create object to call Derivative action and receive signal in return and save that value in "derivSignal" variable        
        break; 
      case "PI":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        System.out.println("Enter the value of tauI for your controller.");
        //use "tauI" variable to read this entry
        //create objects to call Proportional and Integral actions and receive signals in return and save that values in "propSignal" and "intSignal" variables
        finalSignal=propSignal+intSignal;
        break; 
      case "PD":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        System.out.println("Enter the value of tauD for your controller.");
        //use "tauD" variable to read this entry
        //create objects to call Proportional and Derivative actions and receive signals in return and save that values in "propSignal" and "derivSignal" variables
        finalSignal=propSignal+derivSignal;
        break;
      case "ID":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        System.out.println("Enter the value of tauI for your controller.");
        //use "tauI" variable to read this entry
        System.out.println("Enter the value of tauD for your controller.");
        //use "tauD" variable to read this entry
        //create objects to call Integral and Derivative actions and receive signals in return and save that values in "intSignal" and "derivSignal" variables
        finalSignal=intSignal+derivSignal;
        break; 
      case "PID":
        System.out.println("Enter the value of Kc for your controller.");
        //use "kC" variable to read this entry
        System.out.println("Enter the value of tauI for your controller.");
        //use "tauI" variable to read this entry
        System.out.println("Enter the value of tauD for your controller.");
        //use "tauD" variable to read this entry
        //create objects to call Proportional, Integral and Derivative actions and receive signals in return and save that values in "propSignal", "intSignal" and "derivSignal" variables
        finalSignal=propSignal+intSignal+derivSignal;
        break;         
    }
  }
}
