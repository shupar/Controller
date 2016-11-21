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
  
  public double calculateSignal(double delx, double error, double previousError)
  {
    return error*super.getKC();
  }
}