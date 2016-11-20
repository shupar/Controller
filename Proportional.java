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
  
  public Proportional(Proportional copy)
  {
    super(copy);
  }//end of copy constructor
  
  public Proportional clone()
  {
    return new Proportional(this);
  }//end of clone method
  
  public double calculateSignal(double delx, double error, double previousError)
  {
    return error*super.getKC();
  }
}