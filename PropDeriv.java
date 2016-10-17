public class PropDeriv extends Prop
{  
  private double tauD;
  
  public PropDeriv(double kC, double tauD)
  {
    super(kC);
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