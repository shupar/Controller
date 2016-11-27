//parent to each controller action
public abstract class Controller
{  
  //abstract controller method to calculate the controller output signal  
  public abstract double calculateSignal(double delx, double error, double previousError);//(response)
   
} //end of class
  