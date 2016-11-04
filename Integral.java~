public class Integral extends Controller implements ResponseSolver
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
  
  public double calculateSignal(double error)
  {
    return 0.;
    //fix: get kC value from Controller and use numerical method to solve integral
  }
}