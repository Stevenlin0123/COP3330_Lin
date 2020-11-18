import java.util.Scanner;
import java.util.ArrayList;


public class App {
    
  private static Scanner in = new Scanner(System.in);
  
  private static taskList tasks;

  public App()
  {
    tasks = new taskList();
  }
  
  public static void main(String[] args) {
	  App m = new App();
	  m.mainMenu();
	
}
  
  private void mainMenu()
  {
	
    System.out.println("\nMain Menu");
    System.out.println("---------\n");
    System.out.println("1) create a new list");
    System.out.println("2) load an existing list");
    System.out.println("3) quit");
    int a = in.nextInt();
    
    if(a == 1)
    {
      System.out.println("new task list has been created");
      App m = new App();
      Operation();
    }
    else if(a == 2)
    {
      System.out.println("Enter the filename to load: ");
      in.nextLine();
      String filename = in.nextLine();
      tasks.read(filename);
      Operation();
    }
    else if(a == 3)
    {
      System.out.println("Bye Bye");
      System.exit(0);
    }
    else
    {
      System.out.println("Invalid option. Please choose another option");
      mainMenu();
    }
    
  }

  private void Operation() {
    System.out.println("\nList Operation Menu");
    System.out.println("---------\n");
    System.out.println("1) view the list");
    System.out.println("2) add an item");
    System.out.println("3) edit an item");
    System.out.println("4) remove an item");
    System.out.println("5) mark an item as completed");
    System.out.println("6) unmark an item as completed");
    System.out.println("7) save the current list");
    System.out.println("8) quit to the main menu");
    System.out.println("\n");
    int b = in.nextInt();

    if(b == 1)
    {
      System.out.println("Current Tasks");
      System.out.println("---------\n");
      tasks.view();
      Operation();
    }
    else if(b == 2)
    {
      processTaskDetails();
      Operation();
    }
    else if(b == 3)
    {
      System.out.println("Which task will you edit? ");
      int number = in.nextInt();
      replaceTaskDetails(number);
      Operation();
    }
    else if(b == 4)
    {
      System.out.println("Which task will you remove?");
      int index = in.nextInt();
      removeTaskItem(index);
      Operation();
    }
    else if(b == 5)
    {
      System.out.println("Which task will you mark as completed?");
      int ind = in.nextInt();
      mark(ind);
      Operation();
    }
    else if(b == 6)
    {
      System.out.println("Which task will you unmark as completed?");
      int hello = in.nextInt();
      unmark(hello);
      Operation();
    }
    else if(b == 7)
    {
      System.out.println("Enter the filename to save as: ");
      in.nextLine();
      String filename = in.nextLine();
      String filename2 = "\""+filename+"\"";
      writeTaskdata(filename2);
      for(int i=0; i<tasks.size(); i++)
      {
    	tasks.remove(i);
      }
      Operation();
    }
    else if(b == 8)
    {
      mainMenu();
    }
    else
    {
      System.out.println("Error. Please try another option");
      Operation();
    }
    

  }
  
  private void writeTaskdata(String filename)
  {
    tasks.write(""+filename+"");
    System.out.println("task list has been saved");
  }

  private taskItem processTaskDetails()
  {
    taskItem data = getTaskDetail();

    storeTaskItem(data);
	return data; 
  }
  
  private taskItem replaceTaskDetails(int i)
  {
    taskItem data = editTaskItem(i);

    tasks.replace(i,data);
	return data; 
  }
  
  private void mark(int i)
  {
	 try {
		 tasks.get(i).setComplete(true);
	  }
	  catch(IndexOutOfBoundsException ex)
	  {
		System.out.println("The index you chose was not valid");
	  }
  }

  private void unmark(int i)
  {
	try {
		tasks.get(i).setComplete(false);
	  }
	  catch(IndexOutOfBoundsException ex)
	  {
		System.out.println("The index you chose was not valid");
	  }
  }

  private void storeTaskItem(taskItem data)
  {
    tasks.add(data);
  }
  
  private void removeTaskItem(int i)
  {
	  try {
	  tasks.remove(i);
	  }
	  catch(IndexOutOfBoundsException ex)
	  {
		System.out.println("The index you chose was not valid");
	  }
  }
  
  private taskItem editTaskItem(int i)
  {
	taskItem newTask = null;
    while(true)
    {
      try{
          String title = newgetTitle(i);

          String description = newgetDescription(i);
          
          String date = newgetDueDate(i);

          newTask = new taskItem(title, description, date);
          break;
      }
      catch(InvalidTitleException ex)
      {
        System.out.println("Warning: your title is invalid");
      }
      catch(InvalidDateException ex)
      {
        System.out.println("Warning: your date is invalid");
      }
    }
    return newTask;
  }

  private taskItem getTaskDetail()
  {
    taskItem details = null;
    while(true)
    {
      try{
          String title = getTitle();

          String description = getDescription();
          
          String date = getDueDate();

          details = new taskItem(title, description, date);
          break;
      }
      catch(InvalidTitleException ex)
      {
        System.out.println("Warning: your title is invalid");
      }
      catch(InvalidDateException ex)
      {
        System.out.println("Warning: your date is invalid");
      }
    }
    return details;
  }
 
  private String getTitle()
  {
    System.out.println("Task title: ");
    in.nextLine();
    return in.nextLine();
  }

  private String getDescription()
  {
    System.out.println("Task description: ");
    return in.nextLine();
  }

  private String getDueDate()
  {
    System.out.println("Task due date (YYYY-MM-DD): ");
    return in.nextLine();
  }

  private String newgetTitle(int i)
  {
    System.out.println("Enter a new title for task "+i+": ");
    in.nextLine();
    return in.nextLine();
  }

  private String newgetDescription(int i)
  {
    System.out.println("Enter a new description for task" +i+": ");
    return in.nextLine();
  }

  private String newgetDueDate(int i)
  {
    System.out.println("Enter a new task due date (YYYY-MM-DD) for task"+i+": ");
    return in.nextLine();
  }
  
}

class InvalidTitleException extends IllegalArgumentException{
  public InvalidTitleException(String msg)
  {
    super(msg);
  }
}

class InvalidDateException extends IllegalArgumentException{
  public InvalidDateException(String msg)
  {
    super(msg);
  }

}