//child to controller
public class Integral extends Controller 
{
  //declaring instance variables
  private double kC;
  private double tauI;
  
  //constructors, copy constructors and clone methods
  public Integral()
  {
    this.kC=0;
    this.tauI=0.;
  }//end of default constructor  
  
  public Integral(double kC, double tauI)
  {
    this.kC=kC;
    this.tauI=tauI;
  }//end of constructor 
  
  public Integral (Integral copy)
  {
    this.kC=copy.kC;
    this.tauI=copy.tauI;    
  }//end copy constructor
  
  public Integral clone()
  {
    return new Integral(this);
  }//end clone method
  
  //mutator/accessor methods
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator for kC
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor for kC
  
  public void setTauI(double tauI)
  {
    this.tauI=tauI;
  }//end of mutator for tauI
 
  public double getTauI()
  {
    return this.tauI;
  }//end of accessor for tauI
  
  //concrete implementation for the method to get the integral controller output
  public double calculateSignal(double delx, double error, double previousError)
  {
    double integratedError=delx*error;
    return integratedError*this.kC/this.tauI;
  }
}