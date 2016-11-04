public class PropIntDeriv extends PropInt
{  
  private double tauD;
  
  public PropIntDeriv(double kC, double tauI, double tauD)
  {
    super(kC, tauI);
    this.tauD=tauD;
  }//end of constructor
  
  public void setTauD(double tauD)
  {
    this.tauD=tauD;
  }//end of accesor 
 
  public double getTauD()
  {
    return this.tauD;
  }//end of mutator
}