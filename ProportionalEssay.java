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
  
  
  public double calculateSignal(stepChange, kc,taui, taud, response);
  {
    double error=stepChange-response;
    return error*Kc;
  }
}