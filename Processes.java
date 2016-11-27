//parent to both processes
public abstract class Processes
  
{
  //methods to get disturbance as well as manipulated variable output
  public abstract double calculateReponseOfProcessDisturbance(double t1, double responseDisturbance, double delx, double fceOUT, double disturbance);
  public abstract double calculateReponseOfProcessManipulated(double t1, double responseManipulated, double delx, double fceOUT, double disturbance);
  //supporting methods to the two listed above
  public abstract double intialiseControlledVariable();
  public abstract double intialiseDisturbanceArray();
  public abstract void turnOnDisturbance(double magnitude);
  public abstract void turnOffDisturbance(double magnitude);

}