public class Derivative extends Controller 
{
  private double tauD;
  
  public Derivative()
  {
    super();
    this.tauD=0.;
  }//end of default constructor  
   
  public Derivative(double kC, double tauD)
  {
    super(kC);
    this.tauD=tauD;
  }//end of constructor 
  
  public void setTauD(double tauD)
  {
    this.tauD=tauD;
  }//end of mutator 
 
  public double getTauD()
  {
    return this.tauD;
  }//end of accessor
  
  public double calculateSignal(double step, int index, double[] error)
  {
    if (index == 0)
      derivedError = 0;
    double derivedError=(error[index]-error[index-1])/step;
    return derivedError*getKC()*this.tauD;
  }
}