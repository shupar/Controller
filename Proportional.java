public class Proportional extends Controller implements ResponseSolver
{
  public Proportional()
  {
    super();
  }//end of default constructor  
   
  public Proportional(double kC)
  {
    super(kC);
  }//end of constructor 
  
  public double calculateSignal(double error)
  {
    return 0.;
    //fix: get kC value from Controller and multiply by error and return that value to main
  }
}