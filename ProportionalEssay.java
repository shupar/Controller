public class ProportionalEssay extends ControllerEssay 
{
  public ProportionalEssay()
  {
    super();
  }//end of default constructor  
   
  public ProportionalEssay(double kC)
  {
    super(kC);
  }//end of constructor 
  
  public double calculateSignal(double [] error)
  {
    for (int i=0; i<error.length; i++)
    return error*Kc;
  }
}