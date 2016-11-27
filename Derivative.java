//child to controller
public class Derivative extends Controller 
{
  //declaring instance variables
  private double kC;
  private double tauD;
  
  //contructor methods and copy contructor and clone method:
  public Derivative()
  {
    this.kC=0;
    this.tauD=0.;
  }//end of default constructor  
   
  public Derivative(double kC, double tauD)
  {
    this.kC=kC;
    this.tauD=tauD;
  }//end of constructor 
  
  public Derivative (Derivative copy)
  {
    this.kC=copy.kC;
    this.tauD=copy.tauD;
  }//end copy constructor
  
  public Derivative clone()
  {
    return new Derivative(this);    
  }//end clone method
  
  //mutator/accessor methods:
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator for kC
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor for kC
  
  public void setTauD(double tauD)
  {
    this.tauD=tauD;
  }//end of mutator for tauD
 
  public double getTauD()
  {
    return this.tauD;
  }//end of accessor for tauD
  
  //concrete implementation for the method to calculate the derivative controller output
  public double calculateSignal(double delx, double error, double previousError)
  {
    double derivedError=(error-previousError)/delx;
    return derivedError*this.kC*this.tauD;
  }
}