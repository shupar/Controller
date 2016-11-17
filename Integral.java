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

  public Integral(Integral copy)
  {
    super(copy);
    this.tauI=copy.tauI;
  }//end of copy constructor
  
  public Integral clone()
  {
    return new Integral(this);
  }//end of clone method
  
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
    return integratedError*super.getKC()/this.tauI;
  }
}