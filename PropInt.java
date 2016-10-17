public class PropInt extends Prop
{  
  private double tauI;
  
  public PropInt(double kC, double tauI)
  {
    super(kC);
    this.tauI=tauI;
  }//end of constructor
  
  public void setTauI(double tauI)
  {
    this.tauI=tauI;
  }//end of accesor 
 
  public double getTauI()
  {
    return this.tauI;
  }//end of mutator
}
  