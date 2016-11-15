public class Integral extends Controller 
{
  private double tauI;
  
  public Integral()
  {
    super();
    this.tauI=0.;
  }//end of default constructor  
   
  public Integral(double kC, double tauI)
  {
    super(kC);
    this.tauI=tauI;
  }//end of constructor 
  
  public void setTauI(double tauI)
  {
    this.tauI=tauI;
  }//end of mutator 
 
  public double getTauI()
  {
    return this.tauI;
  }//end of accessor
  
  public double calculateSignal(double step, double error, double previousError)
  {
    double integratedError=step*error;
    return integratedError*super.getKC()/this.tauI;
  }
}