import java.io.*;
import java.util.Random;

public class UsingRootFinding5
{
	public static final int numbhouses = 1500;		// Sets the number of houses present in the simulation
	public static final int numbdays = 5;			// Sets the number of days that the simulation will run
	//NOTE: This program is made to be run maximum for 5 days, as the randomness of it makes it significantly stray
	//      from a stable value. More on this in the report. The less the number of houses, the more it is accurate.

	/** Start of the main method here
		This main method is a rootfinding program which serves our optimization purpose
		The Root is the optimal pumping value PER HOUSE
		x1 is the root
	**/
	public static void main(String[] args)
	{
		double x1 = 50.0;
		double x2 = -5.0;
		double xMid = 0.0;
		double tolerance1 = 0.0000001;
		double tolerance2 = 0.0000001;

		double numbhousesdbl = (double) numbhouses; //casting these values as doubes so
		double numbdaysdbl = (double) numbdays;     //we can use stroeData method

		if(evaluatefunction(x2) * evaluatefunction(x1) < 0 )
		{
			do
			{
				xMid = 0.5 * (x2 + x1);

				if (evaluatefunction(xMid) != 0)
				{
					if ( evaluatefunction(xMid) * evaluatefunction(x2) < 0 )
					{
						x1 = xMid;
					}

					else
					{
						x2 = xMid;
					}

				}
				else
				{
					x1 = xMid;
					break;
				}
			}while ((Math.abs((x2 - x1) / Math.max(1, x2))) > tolerance1 && (Math.abs(evaluatefunction(x1))) > tolerance2);

			storeData(x1, numbdaysdbl, numbhousesdbl, 0.0);
			System.out.println("root at " + x1);
		}

		else
		{
			while (true)
			{

				if ((x1 < x2) && (evaluatefunction(x2) * evaluatefunction(x1) < 0))
				storeData(x1, numbdaysdbl, numbhousesdbl, 0.0);
					break;
			}

			do
			{
				xMid = 0.5 * (x2 + x1);

				if (evaluatefunction(xMid) != 0)
				{
					if ( evaluatefunction(xMid) * evaluatefunction(x2) < 0 )
					{
						x1 = xMid;
					}

					else
					{
						x2 = xMid;
					}
				}
				else
				{
					x1 = xMid;
					storeData(x1, numbdaysdbl, numbhousesdbl, 0.0);
					break;
				}

			}while ((Math.abs((x2 - x1) / Math.max(1, x2))) > tolerance1 && (Math.abs(evaluatefunction(x1)) > tolerance2));

	}
}

	public static double evaluatefunction(double pumping)
	{
		int currentday = 1;
		double Vtower = 0.0;
		int t = 0;
		int housecounter;
		double Vminimal = 1000000000, Vmaximal = -1000000000;

		while (currentday <= numbdays)
		{
			housecounter = 1;
			while (housecounter <= numbhouses)
			{
				Vtower = Vtower + pumping - houseConsume(t);
				housecounter++;
			}

			if (Vtower < Vminimal)
			{
				Vminimal = Vtower;
			}
			if (Vtower > Vmaximal)
			{
				Vmaximal = Vtower;
			}

			//System.out.println("Volume in tower:        " + Vtower);

			t++;
			if (t >= 24)
			{
				currentday++;
				t = 0;
			}
		}

		System.out.println(" Vmax: \t"+ Vmaximal + "\t Vmin: \t" +Vminimal);
		return Vminimal;
	}

	/** This method simulates water consumption per "humans present and active"
	according to what time of the day it is
	This method complements the houseConsume method */

	public static double humansAwake(double a, double t)
	{
		double V=0;

		if (4 <= t && t <= 13)		//from 5h to 14h
		{
			V = (a * 4.0) + 1.0;
		}

		if (14 <= t && t <= 23)		//from 15h to 24h
		{
			V = (a * 2.0) + 2.0;
		}
		return V;
	}
   /** 	This method is the core of the program
		It simulates the water consumption for a house
		for every hour of the day
		Input time of the day, returns water consummed during that hour
   */
	public static double houseConsume(int t)
	{


		double V = 0.0;
		Random rand = new Random();
		int n = rand.nextInt(10) + 1;
		int humansactive = 0;

		if (t==0)
		{  V = 2.5;
			if (n==1)
			V = V + 1.0;
		}
		else if (t==1)
		{  V = 2.5;
		if (n==1 || n==2)
			V = V + 1.0;
		}
		else if (t==2)
		{  V = 2.5;
			if (n==1 || n==2)
			V = V + 1.0;
		}
		else if (t==3)
		{  V = 2.5;
			if (n==1 || n==2 || n==3)
			V = V + 1.0;
		}
		else if (t==4)
		{  V = 5.0;
			if (n==1)
			V = V + 5.0;
		}
		else if (t==5)
		{  humansactive = 1;
			V = 3.5 + humansAwake(humansactive, t);

			if (n==1 || n==2)
			V = V + 2.0;
		}
		else if (t==6)
		{  humansactive = 3;
			V = 1.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3 || n==4)
			V = V + 2.0;
		}
		else if (t==7)
		{  humansactive = 4;
			V = 1.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3 || n==4 || n==5)
			V = V + 2.0;
		}
		else if (t==8)
		{  humansactive = 4;
			V = 1.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3 || n==4 || n==5)
			V = V + 2.0;
		}
		else if (t==9)
		{  humansactive = 3;
			V = 2.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3)
			V = V + 4.0;
		}
		else if (t==10)
		{  humansactive = 1;
			V = 8.5 + humansAwake(humansactive, t);

			if (n==1 || n==2)
			V = V + 2.0;
		}
		else if (t==11)
		{  humansactive = 0;
			V = 8.0 + humansAwake(humansactive, t);

			if (n==1)
			V = V + 5.0;
		}
		else if (t==12)
		{  humansactive = 0;
			V = 8.0 + humansAwake(humansactive, t);

			if (n==1)
			V = V + 5.0;
		}
	   	else if (t==13)
	  	 {  humansactive = 0;
			V = 8.5 + humansAwake(humansactive, t);

        	 if (n==1)
			V = V + 5.0;
		}
		else if (t==14)
	 	{  humansactive = 0;
			V = 9.0 + humansAwake(humansactive, t);

         	if (n==1)
			   V = V + 5.0;
	  	 }
	   	else if (t==15)
	   	{  humansactive = 1;
		  	V = 8.0 + humansAwake(humansactive, t);

         	if (n==1 || n==2)
		   	V = V + 2.0;
	   	}
	   	else if (t==16)
	   	{  humansactive = 3;
          	V = 5.0 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4)
			   V = V + 2.0;
	   	}
	   	else if (t==17)
	   	{  humansactive = 4;
		  	V = 3.5 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4 || n==5)
		   	V = V + 2.0;
	   	}
	   	else if (t==18)
	   	{  humansactive = 4;
		 	V = 3.5 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4 || n==5)
		   	V = V + 2.0;
	   	}
	   	else if (t==19)
	   	{  humansactive = 4;
          		V = 3.5 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4 || n==5)
		   	V = V + 2.0;
	   	}
	   	else if (t==20)
	   	{  humansactive = 4;
		  	V = 3.5 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4 || n==5)
		   	V = V + 2.0;
	   	}
	   	else if (t==21)
	   	{  humansactive = 4;
		  	V = 3.0 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4)
		   	V = V + 2.0;
	   	}
	   	else if (t==22)
	   	{  humansactive = 3;
		  	V = 3.5 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3 || n==4)
		   	V = V + 2.0;
	   	}
	   	else								//ends at t=23 as it starts at t=0, then 23 is the 24th hour
	   	{  humansactive = 2;
		  	V = 4.0 + humansAwake(humansactive, t);

         	if (n==1 || n==2 || n==3)
		   	V = V + 2.0;
	   	}
	   	return V*4;						// A multiplication by a factor of four is required
   }									// After inputing the data to fit perfectly the hourly consumption curve (see data collection)
									// We realised that the graph fit water consumption of a single person
									// Assuming a household of 4 persons perfectly fits the current water consumption data

/** This method will store the volume of the tower with respect to Time
	in a new file, and return an array of the Vtower values. To change
	what the method prints in a new file cange the variables in
	outputFile.printf(...), DO IT BOTH TIMES THOUGH*/
public static void storeData(double pumping, double numbdays, double numbhouses, double Vtower)
{
      //some parts copied from ZombiesStudentVersion

     String filename = "StoredData.txt";
     PrintWriter outputFile = null;
     try
     {
       outputFile = new PrintWriter(new FileOutputStream(filename,false));
     }
     catch(FileNotFoundException e)
     {
       System.out.println("File error.  Program aborted.");
       System.exit(0);
     }

     double currentday = 1.0;
     double t = 0.0;
     int tofday = (int) t;
     double housecounter;
     double Vminimal = 10000, Vmaximal = -10000;

     //store the initial values
     outputFile.printf("%.3f\t %.3f \n", t, Vtower);

     while (currentday <= numbdays)
 		{
 			housecounter = 1;
			while (housecounter <= numbhouses)
			{
				Vtower = Vtower + pumping - houseConsume(tofday);
				housecounter++;
			}

 			if (Vtower < Vminimal)
 			{
 				Vminimal = Vtower;
 			}
 			if (Vtower > Vmaximal)
 			{
 				Vmaximal = Vtower;
 			}
 			//System.out.println("Total volume in tower:        " + Vtower);

 			t++;
      			tofday++;

 			if (tofday >= 24)
 			{
 				currentday++;
 				tofday = 0;
 			}
       //store the vars
       	outputFile.printf("%.3f\t %.3f \n", t, Vtower);
 		}

 		System.out.println(" Vmax: \t"+ Vmaximal + "\t Vmin: \t" +Vminimal);

    	outputFile.close();

		Vtower = 0.0;

		if(Vminimal < 0)
		{
			storeData(pumping, numbdays, numbhouses, (Vtower + Math.abs(Vminimal)));
		}
		else
		{
		double towersize = Vmaximal - Vminimal;
		double towersizePerHouse = towersize / (double) numbhouses;

		System.out.println(" The optimal size of a water tower for " + (int) numbhouses + " houses is of:  " + towersize + " litres.");
		System.out.println(" This equals : " + towersizePerHouse + "L per house. ");
		}
	}

}//end of class
