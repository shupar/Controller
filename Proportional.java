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
  
  public double calculateSignal(double step, int index, double[] error)
  {
    return error[index]*getKC();
  }
}