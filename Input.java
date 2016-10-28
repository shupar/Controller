import java.util.*; //i survived :')

public class Input
{
  public static void main (String[] args)
  {
    Scanner reader = new Scanner(System.in);
    /*int selection = 0;
    System.out.println("What kind of input signal will you be sending to your system?");
    System.out.println("1. Step Change");
    System.out.println("2. Impulse");
    System.out.println("3. Wave Function");
    selection = reader.nextInt();
    System.out.println("You selected "+selection);*/
    
    System.out.println("You will now need to enter the parameters for the first order approximation of your process. Please enter your gain (K value): ");
    double kC=reader.nextDouble();
    
    System.out.println("Please enter the time constant for your process");
    double tau = reader.nextDouble();
    
    System.out.println("Does your process have a dead time if so, enter its value (in seconds) here, if not enter 0");
    double theta = reader.nextDouble();
       
    System.out.println("Select your controller");
    System.out.println("1. Proportional");
    System.out.println("2. PI");
    System.out.println("3. PD");
    System.out.println("4. PID");
    
    do{
    int controllerChoice = reader.nextInt();
    if (controllerChoice < 1 && controllerChoice > 4)
      System.out.println("Your selection must be a number from 1 to 4");
    } while (controllerChoice < 1 && controllerChoice > 4);
        
    if (controllerChoice == 1)
    {
      System.out.println("Select the Kc value for your proportional controller");
      double kCP = reader.nextDouble();
      Prop pController = new Prop(kCP);
         
    } else if(controllerChoice == 2)
    {
      System.out.println("Select the Kc value for your PI controller");
      double kCP = reader.nextDouble();
      System.out.println("Select the tau I value for your PI controller");
      double tauI = reader.nextDouble();
    } else if(controllerChoice == 3)
    {
      System.out.println("Select the Kc value for your PD controller");
      double kCP = reader.nextDouble();
      System.out.println("Select the tau D value for your PD controller");
      double tauD = reader.nextDouble(); 
    } else if(controllerChoice == 4)
    {
      System.out.println("Select the Kc value for your PID controller");
      double kCP = reader.nextDouble();
      System.out.println("Select the tau I value for your PID controller");
      double tauI = reader.nextDouble();
      System.out.println("Select the tau D value for your PID controller");
      double tauD = reader.nextDouble();
    } 
    
    
     
   
     
    
    
                         
    reader.close();
    
  } //End of main method  
  
} // End of class