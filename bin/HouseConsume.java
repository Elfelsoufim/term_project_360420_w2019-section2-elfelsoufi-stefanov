import java.util.Scanner;
import java.util.Random;

public class HouseConsume2
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
   
   public static void main(String[] args)
   {
	  int currentday = 1;
	  int numbdays;
	  double Vcons = 0.0;
	  double Vpumped=0.0;
	  double Vtower;
	  int t = 0;
	  int housecounter;
	  int numbhouses;
	  
	  Scanner jack = new Scanner(System.in);
	  
	  System.out.println("Hello, enter the number of days");
	  
	  numbdays = jack.nextInt();

      System.out.println("Please enter the number of houses:");
	  
	  numbhouses = jack.nextInt();

	  while (currentday <= numbdays)
	  {
		  housecounter = 1;
		  while (housecounter <= numbhouses)
		  {
		     Vcons = Vcons + houseConsume(t);
			 housecounter++;
			 System.out.println("Total volume consumed:   " + Vcons);
		  }
		  
		  Vpumped = Vpumped + (4*12.0);   //pumps 12*4 litres per hour
		  Vtower = Vpumped - Vcons;
		  System.out.println("Total volume in tower:        " + Vtower);
		  
		  t++;
		  
		  if (24 < t)
		  {
			  currentday++;
			  t = 0;
		  }
	  }
	  
      System.out.println("Total volume consumed:   " + Vcons);
	 //Water consumption simulation done! 
	 //To do : Add comments
   }
}
