public class Proportional extends Controller
{
  public Proportional()
  {
    super();
  }//end of default constructor  
   
  public Proportional(double kC)
  {
    super(kC);
  }//end of constructor 
  
  
  public double calculateSignal(stepChange, kc,taui, taud, response);
  {
    double error=stepChange-response;
    return error*Kc;
  }
}