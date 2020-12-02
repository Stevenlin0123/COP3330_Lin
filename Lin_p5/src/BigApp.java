import java.util.Scanner;
import java.util.ArrayList;
import java.lang.reflect.Method; 

public class BigApp {
	
	
	private static Scanner in = new Scanner(System.in);
	


	public BigApp() {
		
	}

	public static void main(String arg[]) {
		BigApp c = new BigApp();
		c.selectApp();
		
	}
	

	
    void selectApp()
	{
		System.out.println("Select Your Application");
	    System.out.println("-----------------------\n");
	    System.out.println("1) task list");
	    System.out.println("2) contact list");
	    System.out.println("3) quit");
	    System.out.println();
	    System.out.print(">");
	    int a = in.nextInt();
	    
	    if(a == 1)
	    {
	      System.out.println("new task list has been created");
	      taskApp m = new taskApp();
	      m.mainMenu();
	    }
		
	    if(a == 2)
	    {
	    	System.out.println("new contact list has been created");
	    	contactApp e = new contactApp();
	    	e.contactmainMenu();
	    }
	    if(a == 3)
	    {
	    	System.out.println("Bye Bye");
	    	System.exit(0);
	    }
	    else
	    {
	      System.out.println("Invalid option. Please choose another option");
	      selectApp();
	    }
	}
    
}