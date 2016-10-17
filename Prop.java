public class Prop
{
  Scanner reader=new Scanner(System.in);
  
  private double kC;
  private double tau;
  private double theta;
  private double gain;
  
  public Prop()
  {
    this.kC = 0;
    this.tau = 0;
    this.theta = 0;
    this.gain = 0;
    
  } //end of default constructor
  
  public Prop(double kC, double tau, double theta, double gain)
  {
    this.kC=kC;
    this.tau = tau;
    this.theta = theta;
    this.gain = gain;
  }//end of constructor 
  
  public void setKC(double kC)
  {
    this.kC=kC;
  }//end of accesor 
 
  public double getKC()
  {
    return this.kC;
  }//end of mutator
  
   public void setTau(double tau)
  {
    this.tau=tau;
  }//end of accesor 
 
  public double getTau()
  {
    return this.tau;
  }//end of mutator
  
  public void setTheta(double theta)
  {
    this.theta=theta;
  }//end of accesor 
 
  public double getTheta()
  {
    return this.theta;
  }//end of mutator
  
  public void setGain(double gain)
  {
    this.gain=gain;
  }//end of accesor 
 
  public double getGain()
  {
    return this.gain;
  }//end of mutator
  
  //where do you want this and do we need to import scan or re initialize reader
  System.out.println("Please select the input signal you would like to impose on your system from the options below:");
  System.out.println("1. Step Change\n 2. Impulse\n 3. Sinusoidal wave");// check \n
  int signal=reader.nextInt();
  
  do{
    int signal = reader.nextInt();
    if (signal < 1 && signal > 3)
      System.out.println("Your selection must be a number from 1 to 3");
    } while (signal < 1 && signal > 4); 
    
    if(signal==1)
    {
      System.out.println("Please enter the initial steady state value of the controlled variable of your process:");
      double initialSS=reader.nextDouble();
      
      System.out.println("Please enter the magnitude of the step:");
      double magnitude=reader.nextDouble();
      
      stepChange(initialSS, magnitude);
      
      //send to step change sub function
    }
    else if (signal==2)
    {
      System.out.println("Please enter the magnitude of the impulsion:");
      double magnitude=reader.nextDouble();
      
      System.out.println("Please enter the time the impulsion will last for (in seconds):");//need to check all units throughout code
      double time=reader.nextDouble();//check input here
      
      //send to impulse fct
    }
    else if(signal==3)
    {
      System.out.println("Please enter the amplitude of the wave:");
      double amplitude=reader.nextDouble();
      
      System.out.println("Please enter the frequency of the wave:");
      double frequency=reader.nextDouble();   
    }
  
  public double stepChange(double initialSS, double magnitude)
  {
    double function;
    double t=0;
    double stop; //need to change this for loop, user specify??
    double output[][];//make output array
    double intervals;
    
    System.out.println("For how many seconds would you like to measure the output of the system? Measurements will be taken every second");
    double stop = reader.nextDouble();
    double output[][] = new double[intervals][2];
    
    for(int t=0; t=<stop;t++)
    {
      if(time < this.theta)
        outputArray[t][1] = initialSS;
        else if ( time >= this.theta)
        outputArray[t][1] = laplaceFunction(t); // does the function already add the initial SS value to it or do we add that here?
        // add file output once we learn how to do it
     
    }//end of loop   
  }// end of step change method
  
  public double laplaceFunction (double t, double magnitude)
  {
    return =(1-Math.exp(-t/(this.tau/(1+this.gain*this.kC))))*((1/(1+this.gain*this.kC))*magnitude);//check formula
  } // end of Laplace Function method
  
} //end of class
  