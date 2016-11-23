public class Integral extends Controller 
{
  private double kC;
  private double tauI;
  
  public Integral()
  {
    //super();
    this.kC=0;
    this.tauI=0.;
  }//end of default constructor  
   
  public Integral(double kC, double tauI)
  {
    this.kC=kC;
    this.tauI=tauI;
  }//end of constructor 
  
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator 
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor
  
  public void setTauI(double tauI)
  {
    this.tauI=tauI;
  }//end of mutator 
 
  public double getTauI()
  {
    return this.tauI;
  }//end of accessor
  
  public double calculateSignal(double delx, double error, double previousError)
  {
    double integratedError=delx*error;
    return integratedError*this.kC/this.tauI;
  }
}