import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class contactList {
  List<contactItem> contacts;
  
  public contactList() {
    contacts = new ArrayList<>();
  }
  
  public contactItem get(int i)
  {
    if(i<0)
    {
      throw new IllegalArgumentException("index must be positive (including 0)");
    }
    if(i > contacts.size())
    {
      throw new IndexOutOfBoundsException("index exceeds the size of Contact List");
    }
    return contacts.get(i);
  }
  
  
  
  public void removeContact(int i)
  {
	  contacts.remove(i);
  }
  
  public void replace(int i, contactItem data)
  {
	 try {
		 contacts.set(i, data);
	 }
	 catch(ArrayIndexOutOfBoundsException ex)
	 {
		System.out.println("Out of index, Unable to replace contact with new one");
	 }
  }

  public void addContact(contactItem data)
  {
    contacts.add(data);
  }

  public String number(contactItem data)
  {
	  return data.getNumber();
  }
  
  public int size()
  {
    return contacts.size();
  }
  
  public void read(String filename)
  {
	 try {
		 File obj = new File("\""+filename+"\"");
		 Scanner reader = new Scanner(obj);
		 while(reader.hasNextLine())
		 {
		   String first = reader.nextLine();
		   String last = reader.nextLine();
		   String num = reader.nextLine();
		   String email = reader.nextLine();
		   contactItem newtask = new contactItem(first, last, num, email);
		   contacts.add(newtask);
		 }
		 System.out.println("contact list have been loaded");
		 reader.close();
	 }
	 catch(FileNotFoundException ex)
	 {
		 System.out.println("File not found");
		 ex.printStackTrace();
	 }
  }
  

  public void write(String filename)
  {
    try(Formatter output = new Formatter(filename))
    {
      for(int i=0; i<contacts.size(); i++)
      {
        contactItem data = contacts.get(i);
        output.format("%s\n%s\n%s\n%s\n", data.getContactFirst(), data.getContactLast(), data.getNumber(), data.getEmail());
      }
      output.close();
    }
    catch(FileNotFoundException ex){
      
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }
  
  public void clear(contactList a)
  {
	for(int i=0; i<a.size(); i++)
	{
	  a.removeContact(0);
	}
  }
  
  public void viewContact()
  {
	for(int i=0; i<contacts.size(); i++)
	{
	  contactItem data = contacts.get(i);
	  System.out.println(i+") Name:"+data.getContactFirst()+" " + data.getContactLast());
	  System.out.println("Phone: " + data.getNumber());
	  System.out.println("Email: " + data.getEmail());
	}
  }
}
