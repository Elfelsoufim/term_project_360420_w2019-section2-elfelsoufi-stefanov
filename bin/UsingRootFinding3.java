import java.util.Scanner;
import java.util.Random;

public class UsingRootFinding3
{
	public static final int numbhouses = 10;										// Sets the number of houses present in the simulation
	public static final int numbdays = 15;										// Sets the number of days that the simulation will run
	public static final double upperBound = (30 * numbhouses) + 100; 			// Sets a (reasonable) upperbound for the root finding
	public static final double lowerBound = 5 * numbhouses;						// Sets a (reasonable) lowerbound for the root finding
	public static final double tolerance = 0.0001;

	/** Start of the main method here
		This main method is a rootfinding program which serves our optimization purpose
		The Root is the optimal pumping value PER HOUSE !
	**/
	public static void main(String[] args)
	{
		double fx = 0, flower = 0, fupper = 0, root = 0;
		double midPoint = 0, upperPoint = 0, lowerPoint = 0;
		double froot = 0;
		int i = 0;
		upperPoint = upperBound;
		lowerPoint = lowerBound;


		while ((Math.abs(upperPoint) - Math.abs(lowerPoint)) >= tolerance)
		{

			System.out.println(" iteration # " + i);
			System.out.println(" xlower : " + lowerPoint);
			System.out.println(" xupper : " + upperPoint);


			midPoint = (upperPoint + lowerPoint ) / 2 ;

			fx = evaluatefunction(midPoint);
			fupper = evaluatefunction(upperPoint);
			flower = evaluatefunction(lowerPoint);

			if ( fx * fupper < 0)
				{
				lowerPoint = midPoint;
				}
			else
				{
				upperPoint = midPoint;
				fupper = evaluatefunction(upperPoint);
				}
			i++;
		}

		root = (upperPoint + lowerPoint ) / 2 ;
		froot = evaluatefunction(root);											// Once the root is found, rerun the simulation to check minimum and maximum values
		System.out.println(" Root is: " + root + " " + upperPoint);

	}


	public static double evaluatefunction(double pumping)
	{
		int currentday = 1;
		double Vcons = 0.0;
		double Vpumped=0.0;
		double Vtower;
		int t = 0;
		int housecounter;
		double Vminimal = 10000, Vmaximal = -1000;

		while (currentday <= numbdays)
		{
			housecounter = 1;
			while (housecounter <= numbhouses)
			{
				Vcons = Vcons + houseConsume(t);
				housecounter++;
				//System.out.println("Total volume consumed:   " + Vcons);   //I feel like removing this printline makes it faster
			}

			Vpumped = Vpumped + (pumping*numbhouses);   			// pumps "pumping"*number of houses litres per hour
			Vtower = Vpumped - Vcons;													//NOTE: since pumping represents the pumping power per house, multiplying it by the number of houses gives the total pumping power

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

		if (5 <= t && t <= 14)
		{
			V = (a * 4.0) + 1.0;
		}

		if (15 <= t && t <= 24)
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
			V = V + 1.0;
		}
		else if (t==1)
		{  V = 2.5;
		if (n==1 || n==2)        			//shows a 20% chance
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
	   else
	   {  humansactive = 2;
		  V = 4.0 + humansAwake(humansactive, t);

         if (n==1 || n==2 || n==3)
		   V = V + 2.0;
	   }
	   return V*4;												// A multiplication by a factor of four is required
   }															// After inputing the data to fit perfectly the hourly consumption curve (see data collection)
																// We realised that the graph fit water consumption of a single person
																// Assuming a household of 4 persons perfectly fits the current water consumption data

}
