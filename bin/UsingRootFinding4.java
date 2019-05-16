import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import org.math.plot.*;
import org.math.plot.plotObjects.*;
import java.util.Arrays;
import java.util.Random;

public class UsingRootFinding4
{
	public static final int numbhouses = 1000;															// Sets the number of houses present in the simulation
	public static final int numbdays = 10000;																// Sets the number of days that the simulation will run
	public static final double upperBound = (30 * numbhouses) + 100; 			// Sets a (reasonable) upperbound for the root finding
	public static final double lowerBound = 5 * numbhouses;								// Sets a (reasonable) lowerbound for the root finding
	public static final double tolerance = 0.0001;

	/** Start of the main method here
		This main method is a rootfinding program which serves our optimization purpose
		The Root is the optimal pumping value PER HOUSE !
	**/
	public static void main(String[] args) 
	{
		double x1 = 0;
		double x2 = 0;
		double xMid = 0;
		double tolerance1 = 0.00001;
		double tolerance2 = 0.00001;
		double numbhousesdbl = (double) numbhouses;
			double numbdaysdbl = (double) numbdays;
			double[] Voltower;
			double sum1 = 0.0;
			double sum2 = 1.0;
			double trendline;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("x1 should be smaller than x2, and f(x) opposite signs. don't input the acutal roots.\nNumber x1: ");
		x1 = sc.nextDouble();
		System.out.println("Number x2: ");
		x2 = sc.nextDouble();
		
		while (x2 <= x1)
		{
			System.out.println("no try again");
			System.out.println("x1 should be smaller than x2, and f(x) opposite signs. don't input the acutal roots.\nNumber x1: ");
			x1 = sc.nextDouble();
			System.out.println("Number x2: ");
			x2 = sc.nextDouble();
		}
		
		
		if(f(x2) * f(x1) < 0 )
		{
			do
			{
				xMid = 0.5 * (x2 + x1);
				
				if (f(xMid) != 0)
				{
					if ( f(xMid) * f(x2) < 0 )
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
			}while ((Math.abs((x2 - x1) / Math.max(1, x2))) > tolerance1 && (Math.abs(f(x1))) > tolerance2);
			
			Voltower = storeData(x1, numbdaysdbl, numbhousesdbl);
			System.out.println("root at " + x1);
		}
		
		else
		{
			while (true)
			{
				System.out.println("no try again");
				System.out.println("x1 should be smaller than x2, and f(x) opposite signs. don't input the acutal roots.\nNumber x1: ");
				x1 = sc.nextDouble();
				System.out.println("Number x2: ");
				x2 = sc.nextDouble();
				
				if ((x1 < x2) && (f(x2) * f(x1) < 0)) 
					break;
			}
			
			do
			{
				xMid = 0.5 * (x2 + x1);
				
				if (f(xMid) != 0)
				{
					if ( f(xMid) * f(x2) < 0 )
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
				
			}while ((Math.abs((x2 - x1) / Math.max(1, x2))) > tolerance1 && (Math.abs(f(x1)) > tolerance2));
			
			System.out.println("root at " + x1);
			double froot = f(x1);
			System.out.println("root at: " + x1);
		}
	
		//for (int j = 0; j< Voltower.length; j++)
		//{
		//	sum1 = sum1 + Voltower[j];
		//	System.out.println(sum1);
		//}

		//for(int k = 1; k<Voltower.length; k++)
		//{
		//	sum2 = k*sum2;
		//}
		//trendline = sum1/sum2;

		//System.out.println("trendline is: " + trendline);
		//System.out.println("array length  " + Voltower.length);
    }


	public static double f(double pumping)
	{
		int currentday = 1;
		double Vcons = 0.0;
		double Vpumped = 0.0;
		double Vtower = 0;
		int t = 0;
		int housecounter;
		double Vminimal = 1000000000, Vmaximal = -1000000000;

		while (currentday <= numbdays)
		{
			housecounter = 1;
			while (housecounter <= numbhouses)
			{
				Vcons = Vcons + houseConsume(t);
				housecounter++;
				//System.out.println("Total volume consumed:   " + Vcons);
			}

			Vpumped = Vpumped + (pumping*numbhouses);   			// pumps (pumping)*(number of houses) litres per hour
			Vtower = Vpumped - Vcons;													// Again, this will result in an pumping power per house optimal value NO IT DOES NOT
							//NOTE: since pumping is PER HOUSE in main method, pumping*numbhouses is the total pumping power

			if (Vtower < Vminimal)
			{
				Vminimal = Vtower;
			}
			if (Vtower > Vmaximal)
			{
				Vmaximal = Vtower;
			}
			System.out.println("Volume in tower:        " + Vtower);

		//	if (Vtower < 0)
		//	{
			//	Vminimal = Vtower;
			//	return Vminimal;
			//}

			t++;

			if (t >= 24)
			{
				currentday++;
				t = 0;
			}
		}

		System.out.println("Total volume consumed:   " + Vcons);
		System.out.println(" Vmax: \t"+ Vmaximal + "\t Vmin: \t" +Vminimal);

		return Vminimal;
	}

	/** This method simulates water consumption per "humans present and active"
	according to what time of the day it is */

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
		int n = rand.nextInt(10) + 1;   	//can make 10% gaps btw chances
		int humansactive = 0;

		if (t==0)
		{  V = 2.5;
			if (n==1)      		 			 // shows a 10% chance
			V = V + 1.0/2;
		}
		else if (t==1)
		{  V = 2.5;
		if (n==1 || n==2)        			//shows a 20% chance
			V = V + 1.0/2;
		}
		else if (t==2)
		{  V = 2.5;
			if (n==1 || n==2)
			V = V + 1.0/2;
		}
		else if (t==3)
		{  V = 2.5;
			if (n==1 || n==2 || n==3)
			V = V + 1.0/2;
		}
		else if (t==4)
		{  V = 5.0;
			if (n==1)
			V = V + 5.0/2;
		}
		else if (t==5)
		{  humansactive = 1;
			V = 3.5 + humansAwake(humansactive, t);

			if (n==1 || n==2)
			V = V + 2.0/2;
		}
		else if (t==6)
		{  humansactive = 3;
			V = 1.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3 || n==4)
			V = V + 2.0/2;
		}
		else if (t==7)
		{  humansactive = 4;
			V = 1.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3 || n==4 || n==5)
			V = V + 2.0/2;
		}
		else if (t==8)
		{  humansactive = 4;
			V = 1.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3 || n==4 || n==5)
			V = V + 2.0/2;
		}
		else if (t==9)
		{  humansactive = 3;
			V = 2.5 + humansAwake(humansactive, t);

			if (n==1 || n==2 || n==3)
			V = V + 4.0/2;
		}
		else if (t==10)
		{  humansactive = 1;
			V = 8.5 + humansAwake(humansactive, t);

			if (n==1 || n==2)
			V = V + 2.0/2;
		}
		else if (t==11)
		{  humansactive = 0;
			V = 8.0 + humansAwake(humansactive, t);

			if (n==1)
			V = V + 5.0/2;
		}
		else if (t==12)
		{  humansactive = 0;
			V = 8.0 + humansAwake(humansactive, t);

			if (n==1)
			V = V + 5.0/2;
		}
	   else if (t==13)
	   {  humansactive = 0;
		  V = 8.5 + humansAwake(humansactive, t);

         if (n==1)
		   V = V + 5.0/2;
	   }
	   else if (t==14)
	   {  humansactive = 0;
		  V = 9.0 + humansAwake(humansactive, t);

         if (n==1)
		   V = V + 5.0/2;
	   }
	   else if (t==15)
	   {  humansactive = 1;
		  V = 8.0 + humansAwake(humansactive, t);

         if (n==1 || n==2)
		   V = V + 2.0/2;
	   }
	   else if (t==16)
	   {  humansactive = 3;
          V = 5.0 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4)
		   V = V + 2.0/2;
	   }
	   else if (t==17)
	   {  humansactive = 4;
		  V = 3.5 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4 || n==5)
		   V = V + 2.0/2;
	   }
	   else if (t==18)
	   {  humansactive = 4;
		  V = 3.5 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4 || n==5)
		   V = V + 2.0/2;
	   }
	   else if (t==19)
	   {  humansactive = 4;
          V = 3.5 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4 || n==5)
		   V = V + 2.0/2;
	   }
	   else if (t==20)
	   {  humansactive = 4;
		  V = 3.5 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4 || n==5)
		   V = V + 2.0/2;
	   }
	   else if (t==21)
	   {  humansactive = 4;
		  V = 3.0 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4)
		   V = V + 2.0/2;
	   }
	   else if (t==22)
	   {  humansactive = 3;
		  V = 3.5 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3 || n==4)
		   V = V + 2.0/2;
	   }
	   else																					//ends at t=23 as it starts at t=0, then 23 is the 24th hour
	   {  humansactive = 2;
		  V = 4.0 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3)
		   V = V + 2.0/2;
	   }
	   return V*4;												// A multiplication by a factor of four is required
   }															// After inputing the data to fit perfectly the hourly consumption curve (see data collection)
																// We realised that the graph fit water consumption of a single person
																// Assuming a household of 4 persons perfectly fits the current water consumption data

		/** This method will store the volume of the tower with respect to Time
				in a new file, and return an array of the Vtower values. To change
				what the method prints in a new file cange the variables in
				outputFile.printf(...), DO IT BOTH TIMES THOUGH*/
		public static double[] storeData(double pumping, double numbdays, double numbhouses)
		{
			//1. open the file
      //copy pasted from ZombiesStudentVersion

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

     //2.The calculation
     double currentday = 1.0;
     double Vcons = 0.0;
     double Vpumped = 0.0;
     double Vtower = 50.0;		//changed to 50, maybe we should have more, depending on variation btw maxima and minima
     double t = 0.0;
     double tofday = t;
     int housecounter;
     double Vminimal = 10000, Vmaximal = -10000;

		 double[] Voltower = new double[(int) (24 * numbdays)];
		 int i = 0;

     //store the initial values
     outputFile.printf("%.3f\t %.3f \n", t, Vtower);

     while (currentday <= numbdays)
 		{
 			housecounter = 1;
 			while (housecounter <= numbhouses)
 			{
 				Vcons = Vcons + houseConsume((int) tofday);
 				housecounter++;
 			}

 			Vpumped = Vpumped + (pumping*numbhouses);   			// pumps "pumping"*number of houses litres per hour
 			Vtower = Vpumped - Vcons;													//NOTE: since pumping represents the pumping power per house, multiplying it by the number of houses gives the total pumping power

			//store in array
			Voltower[i] = Vtower;

 			if (Vtower < Vminimal)
 			{
 				Vminimal = Vtower;
 			}
 			if (Vtower > Vmaximal)
 			{
 				Vmaximal = Vtower;
 			}
 			System.out.println("Total volume in tower:        " + Vtower);

 			t++;
      tofday++;
			i++;

 			if (tofday >= 24)
 			{
 				currentday++;
 				tofday = 0;
 			}
       //store the vars
       outputFile.printf("%.3f\t %.3f \n", t, Vtower);
 		}

 		System.out.println("Total volume consumed:   " + Vcons);
 		System.out.println(" Vmax: \t"+ Vmaximal + "\t Vmin: \t" +Vminimal);

     outputFile.close();

		 return Voltower;
		}
}
