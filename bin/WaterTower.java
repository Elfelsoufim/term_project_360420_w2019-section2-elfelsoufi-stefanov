import java.util.Scanner;
import java.util.Random;

public class WaterTower
{
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
	   return V;
   }
   
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
   
   /** Start of the main method 
   **/
   public static void main(String[] args)
   {
	  double trial = 1000; 
	  double minima = 100;
	  int housecounter;
	  int numbhouses;
	  int numbdays;
	  
	  Scanner jack = new Scanner(System.in);
	  
	  System.out.println("Hello, enter the number of days");
	  
	  numbdays = jack.nextInt();

	  System.out.println("Please enter the number of houses:");
		
	  numbhouses = jack.nextInt();
	  
	  for (double d = 8.0; d <= 15; d+= 0.25)
	  {
		double Vdiff = 0;
	    double averagediff = 0;
	    int ctr = 1;
	    
		int currentday = 1;
		
		double Vcons = 0.0;
		double Vpumped=0.0;
		double Vtower;
		int t = 0;
		

		while (currentday <= numbdays)
		{
			housecounter = 1;
			while (housecounter <= numbhouses)
			{
				Vcons = Vcons + houseConsume(t);
				housecounter++;
				System.out.println("Total volume consumed:   " + Vcons);
			}
		  
			Vpumped = Vpumped + (d*numbhouses);   //pumps d litres per hour
			Vtower = Vpumped - Vcons;
			System.out.println("Total volume in tower:        " + Vtower);
			
			while ( Vtower <= 0 )                                      /** Fix this loop **/
			{
				Vtower = 11100;                         				/** Somehow make it stop and do another trial, with another value of d **/
				 
			}
			
		    Vdiff = Vdiff + Vtower;
			
			ctr++; 
			t++;
		  
			if (24 < t)
			{
				currentday++;
				t = 0;
			}
		}
	    
		System.out.println("Total volume consumed:   " + Vcons); 
		 
		averagediff = Vdiff / ctr;
        
        if ( averagediff < minima)
		{
			minima = averagediff;
		    trial = d;
		}
		else 
		{
			minima = minima;
		    trial = trial;
		}
		System.out.println(" Best average difference is : " + minima);
		System.out.println(" Best average pumping value : " + d + " liters per hour ");
	  }
	  
   } /** This is a work in progress ! **/ 
}
