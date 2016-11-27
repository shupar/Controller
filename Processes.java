
public abstract class Processes
  
{
  public abstract double calculateReponseOfProcessDisturbance(double t1, double responseDisturbance, double delx, double fceOUT, double disturbance);
  public abstract double calculateReponseOfProcessManipulated(double t1, double responseManipulated, double delx, double fceOUT, double disturbance);
  public abstract double intialiseControlledVariable();
  public abstract double intialiseDisturbanceArray();
  public abstract void turnOnDisturbance(double magnitude);
  public abstract void turnOffDisturbance(double magnitude);

}