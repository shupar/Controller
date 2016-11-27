//child to controller
public class Proportional extends Controller
{
  //declaring instance variable
  private double kC;
  
  //constructors and clone method
  public Proportional()
  {
    this.kC=0;
  }//end of default constructor  
   
  public Proportional(double kC)
  {
    this.kC=kC;
  }//end of constructor 
  
  public Proportional (Proportional copy)
  {
    this.kC=copy.kC;
  }//end of copy constructor
  
  public Proportional clone()
  {
    return new Proportional(this);
  }//end clone method
  
  //mutators/accessor methods:
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator for kC
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor for kC
  
  //concrete implementation for the proportional controller output
  public double calculateSignal(double delx, double error, double previousError)
  {
    return error*this.kC;
  }
}