import java.util.Scanner;
import java.util.Random;

public class HouseConsume
{
   public static double houseConsume(int t)
   {
	   double V = 0.0;  
	   Random rand = new Random();
	   int n = rand.nextInt(10) + 1;   //can make 10% gaps btw chances
	   
	   if (t==0)
	   { if (n==1)        // shows a 10% chance
		   V = 5.0;
	   }
	   else if (t==1)
	   { if (n==1 || n==2)        //shows a 20% chance
		   V = 5.0;               //do the rest accordingly with real life data
	   }
	   else if (t==2)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==3)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==4)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==5)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==6)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==7)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==8)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==9)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==10)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==11)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==12)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==13)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==14)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==15)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==16)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==17)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==18)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==19)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==20)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==21)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==22)
	   { if (n==1)
		   V = 5.0;
	   }
	   else if (t==23)
	   { if (n==1)
		   V = 5.0;
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
		  
		  Vpumped = Vpumped + 10.0;   //pumps 10 litres per hour
		  Vtower = Vpumped - Vcons;
		  System.out.println("Total volume in tower:        " + Vtower);
		  
		  t++;
		  
		  if (t==24)
		  {
			  currentday++;
			  t = 0;
		  }
	  }
	  
      System.out.println("Total volume consumed:   " + Vcons);
	 //there is still lots of work to be done here, this is just a very crude version of what it's supposed to be
   }
}
