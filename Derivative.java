public class Derivative extends Controller 
{
  private double kC;
  private double tauD;
  
  public Derivative()
  {
    //super();
    this.kC=0;
    this.tauD=0.;
  }//end of default constructor  
   
  public Derivative(double kC, double tauD)
  {
    this.kC=kC;
    this.tauD=tauD;
  }//end of constructor 
  
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator 
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor
  
  public void setTauD(double tauD)
  {
    this.tauD=tauD;
  }//end of mutator 
 
  public double getTauD()
  {
    return this.tauD;
  }//end of accessor
  
  public double calculateSignal(double delx, double error, double previousError)
  {
    double derivedError=(error-previousError)/delx;
    return derivedError*this.kC*this.tauD;
  }
}