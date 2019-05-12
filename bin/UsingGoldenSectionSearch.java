import java.util.Scanner;
import java.util.Random;

public class UsingGoldenSectionSearch
{
	/** Start of the main method 
	**/
	public static final double upperBound = 100;              // Input formula here
	public static final double lowerBound = 2;
	public static final double tolerance = 0.001; 
	public static final double Gpoint = 0.38197;
 
	public static void main(String[] args) 
	{ 
		double fx = 0, flower = 0, fupper = 0, root = 0;                      // Input a method here
		double midPoint = 0, upperPoint = 0, lowerPoint = 0;  
  
		Scanner kb = new Scanner(System.in); 
 
		upperPoint = upperBound;
		lowerPoint = lowerBound;
		int i = 0;
 
		while (((Math.abs(upperPoint)) - (Math.abs(lowerPoint))) >= tolerance) 
		{ 
   
			System.out.println(" iteration # " + i);
			System.out.println(" xlower : " + lowerPoint);
			System.out.println(" xupper : " + upperPoint); 
   
			double midPointB = lowerPoint + Gpoint * ( upperPoint - lowerPoint );
			double midPointD = upperPoint - Gpoint * ( upperPoint - lowerPoint );
   
			System.out.println(" b : " + midPointB);
			System.out.println(" d: " + midPointD);
   
			double fxB = evaluatefunction(midPointB);               // Do for A & B
			double fxD = evaluatefunction(midPointD);
			fupper = evaluatefunction(upperPoint);
			flower = evaluatefunction(lowerPoint);
   
			System.out.println(" fb: " + fxB);
			System.out.println(" fd: " + fxD);
   
			double x = 0;
			if ( (upperPoint - midPointB) > (midPointB - lowerPoint) )  
			{
				x = midPointB + Gpoint * (upperPoint - midPointB);
				fx = evaluatefunction(x);
    
				if ( fxD > fxB ) 
				{
					upperPoint = x;
				}
				else 
				{
					lowerPoint = midPointB;
					midPointB = x; 
				}
    
			}
			else 
			{
				x = midPointB - Gpoint * (upperPoint - midPointB);
				fx = evaluatefunction(x);
    
				if ( fxB > fxD )
				{
					upperPoint = midPointB;
					midPointB = x;
				}
				else 
				{
					lowerPoint = x;
				}
			}
   
			i++; 
		}
  
		root = (upperPoint + lowerPoint ) / 2 ;
		System.out.println(" Root is: " + root);

	}	

   
	public static double evaluatefunction(double pumping)
	{
		int currentday = 1;
		int numbdays = 1;
		double Vcons = 0.0;
		double Vpumped=0.0;
		double Vtower;
		int t = 0;
		int housecounter;
		int numbhouses = 1;
		double Vminimal = 10000;
	
		while (currentday <= numbdays)
		{
			housecounter = 1;
			while (housecounter <= numbhouses)
			{
				Vcons = Vcons + houseConsume(t);
				housecounter++;
				System.out.println("Total volume consumed:   " + Vcons);
			}
			
			Vpumped = Vpumped + (4*pumping);   //pumps "pumping"*4 litres per hour
			Vtower = Vpumped - Vcons;
			if (Vtower < Vminimal)
			{
				Vminimal = Vtower;
			}
			System.out.println("Total volume in tower:        " + Vtower);
		  
			t++;
		  
			if (24 < t)
			{
				currentday++;
				t = 0;
			}
		}
	  
		System.out.println("Total volume consumed:   " + Vcons);
		
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
   
	public static double houseConsume(int t)
	{
		double V = 0.0;  
		Random rand = new Random();
		int n = rand.nextInt(10) + 1;   //can make 10% gaps btw chances
		int humansactive = 0;
		
		if (t==0)
		{  V = 2.5;
			if (n==1)      		  // shows a 10% chance
			V = V + 1.0;
		}
		else if (t==1)
		{  V = 2.5;
		if (n==1 || n==2)        			//shows a 20% chance
			V = V + 1.0;		 //do the rest accordingly with real life data
		}
		else if (t==2)
		{  V = 2.5;
			if (n==1 || n==2)
			V = V + 1.0;
		}
		else if (t==3)   				// Till here done
		{  V = 2.5;
			if (n==1 || n==2 || n==3)
			V = V + 1.0;
		}
		else if (t==4)                    // To do AFTER
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
	   else if (t==23)
	   {  humansactive = 2;
		  V = 4.0 + humansAwake(humansactive, t);
		  
         if (n==1 || n==2 || n==3)
		   V = V + 2.0;
	   }
	   else if (t==24)
	   {  humansactive = 1;
		  V = 2.5 + humansAwake(humansactive, t);
		  
         if (n==1 || n==2)
	       V = V + 2.0;
	   }
	   return V*4;
   }
}
