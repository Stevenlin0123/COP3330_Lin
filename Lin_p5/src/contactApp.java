import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class contactApp {
    
  private static Scanner in = new Scanner(System.in);
  
  private static contactList contacts;

  public contactApp()
  {
    contacts = new contactList();
  }
  
  void contactmainMenu()
  {
	
    System.out.println("\nMain Menu");
    System.out.println("---------\n");
    System.out.println("1) create a new list");
    System.out.println("2) load an existing list");
    System.out.println("3) quit");
    System.out.println();
    System.out.print(">");
    int a = in.nextInt();
    
    if(a == 1)
    {
      System.out.println("new contact list has been created");
      contactApp m = new contactApp();
      contactOperation();
    }
    else if(a == 2)
    {
      System.out.println("Enter the filename to load: ");
      in.nextLine();
      String filename = in.nextLine();
      contacts.read(filename);
      contactOperation();
    }
    else if(a == 3)
    {
      BigApp back = new BigApp();
      back.selectApp();
    }
    else
    {
      System.out.println("Invalid option. Please choose another option");
      contactmainMenu();
    }
    
  }

  private void contactOperation() {
    System.out.println("\nList Operation Menu");
    System.out.println("---------\n");
    System.out.println("1) view the list");
    System.out.println("2) add an item");
    System.out.println("3) edit an item");
    System.out.println("4) remove an item");
    System.out.println("5) save the current list");
    System.out.println("6) quit to the main menu");
    System.out.println("\n");
    System.out.println();
    System.out.print(">");
    int b = in.nextInt();

    if(b == 1)
    {
      System.out.println("Current Tasks");
      System.out.println("---------\n");
      contacts.viewContact();
      contactOperation();
    }
    else if(b == 2)
    {
      processContactDetails();
      contactOperation();
    }
    else if(b == 3)
    {
      System.out.println("Which contact will you edit? ");
      int number = in.nextInt();
      replaceContactDetails(number);
      contactOperation();
    }
    else if(b == 4)
    {
      System.out.println("Which contact will you remove?");
      int index = in.nextInt();
      removeContactItem(index);
      contactOperation();
    }
    else if(b == 5)
    {
      System.out.println("Enter the filename to save as: ");
      in.nextLine();
      String filename = in.nextLine();
      String filename2 = "\""+filename+"\"";
      writeContactdata(filename2);
      for(int i=0; i<contacts.size(); i++)
      {
    	removeContactItem(i);
      }
      removeContactItem(0);
      
      contactOperation();
    }
    else if(b == 6)
    {
      contactmainMenu();
    }
    else
    {
      System.out.println("Error. Please try another option");
      contactOperation();
    }
    

  }
  
  private void writeContactdata(String filename)
  {
    contacts.write(""+filename+"");
    System.out.println("contact list has been saved");
  }

  private contactItem processContactDetails()
  {
    contactItem data = getContactDetail();

    storeContactItem(data);
	return data; 
  }
  
  private contactItem replaceContactDetails(int i)
  {
    contactItem data = editContactItem(i);

    contacts.replace(i,data);
	return data; 
  }

  private void storeContactItem(contactItem data)
  {
    contacts.addContact(data);
  }
  
  private void removeContactItem(int i)
  {
	  try {
	  contacts.removeContact(i);
	  }
	  catch(IndexOutOfBoundsException ex)
	  {
		System.out.println("The index you chose was not valid");
		contactOperation();
	  }
  }
  
  private contactItem editContactItem(int i)
  {
	contactItem newContact = null;
    while(true)
    {
      try{
          String first = newgetFirst(i);

          String last = newgetLast(i);
          
          String num = newgetNumber(i);
          
          String email = newgetEmail(i);

          newContact = new contactItem(first, last, num, email);
          break;
      }
      catch(InvalidNameException ex)
      {
        System.out.println("Warning: your title is invalid");
      }
      catch(InvalidNumberException ex)
      {
        System.out.println("Warning: your number is invalid");
      }
      catch(InvalidEmailException ex)
      {
        System.out.println("Warning: your email is invalid");
      }
      continue;
    }
    return newContact;
  }

  private contactItem getContactDetail()
  {
    contactItem details = null;
    while(true)
    {
      try{
          String first = getFirst();

          String last = getLast();
          
          String num = getNumber();
          
          String email = getEmail();

          details = new contactItem(first, last, num, email);
          break;
      }
      catch(InvalidNameException ex)
      {
        System.out.println("Warning: your name is invalid");
        contactmainMenu();
      }
      catch(InvalidNumberException ex)
      {
        System.out.println("Warning: your number is invalid");
        contactmainMenu();
      }
      catch(InvalidEmailException ex)
      {
    	System.out.println("Warning: your email is invalid");
    	contactmainMenu();
      }
      continue;
    }
    return details;
  }
 
  private String getFirst()
  {
    System.out.print("First Name: ");
    in.nextLine();
    return in.nextLine();
  }

  private String getLast()
  {
    System.out.print("Last Name: ");
    return in.nextLine();
  }

  private String getNumber()
  {
    System.out.print("Phone Number (xxx-xxx-xxxx): ");
    return in.nextLine();
  }

  private String getEmail()
  {
	System.out.print("Email address (x@y.z): ");
	return in.nextLine();
  }
  
  private String newgetFirst(int i)
  {
    System.out.print("Enter a new first name for contact "+i+": ");
    in.nextLine();
    return in.nextLine();
  }

  private String newgetLast(int i)
  {
    System.out.print("Enter a new last name for contact " +i+": ");
    return in.nextLine();
  }

  private String newgetNumber(int i)
  {
    System.out.print("Enter a new phone number (xxx-xxx-xxx) for contact "+i+": ");
    return in.nextLine();
  }
  
  private String newgetEmail(int i)
  {
    System.out.print("Enter a new email address (x@y.z) for contact "+i+": ");
    return in.nextLine();
  }
  
  
}

class InvalidNameException extends IllegalArgumentException{
  public InvalidNameException(String msg)
  {
    super(msg);
  }
}

class InvalidNumberException extends IllegalArgumentException{
	  public InvalidNumberException(String msg)
	  {
	    super(msg);
	  }
	}

class InvalidEmailException extends IllegalArgumentException{
  public InvalidEmailException(String msg)
  {
    super(msg);
  }

}