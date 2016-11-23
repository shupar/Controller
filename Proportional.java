public class Proportional extends Controller
{
  private double kC;
  
  public Proportional()
  {
    //super();
    this.kC=0;
  }//end of default constructor  
   
  public Proportional(double kC)
  {
    this.kC=kC;
  }//end of constructor 
  
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator 
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor
  
  public double calculateSignal(double delx, double error, double previousError)
  {
    return error*this.kC;
  }
}