import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class taskList {
  List<taskItem> tasks;
  
  public taskList() {
    tasks = new ArrayList<>();
  }
  
  public taskItem get(int i)
  {
    if(i<0)
    {
      throw new IllegalArgumentException("index must be positive (including 0)");
    }
    if(i > tasks.size())
    {
      throw new IndexOutOfBoundsException("index exceeds the size of TaskList");
    }
    return tasks.get(i);
  }
  
  
  
  public void remove(int i)
  {
	  tasks.remove(i);
  }
  
  public void replace(int i, taskItem data)
  {
	 try {
		 tasks.set(i, data);
	 }
	 catch(ArrayIndexOutOfBoundsException ex)
	 {
		System.out.println("Out of index, Unable to replace task with new one");
	 }
  }

  public void add(taskItem data)
  {
    tasks.add(data);
  }
  
  public boolean completed(taskItem data)
  {
	return data.getComplete();
  }

  public String description(taskItem data)
  {
	  return data.getDescription();
  }
  
  public int size()
  {
    return tasks.size();
  }
  
  public void read(String filename)
  {
	 try {
		 File obj = new File("\""+filename+"\"");
		 Scanner reader = new Scanner(obj);
		 while(reader.hasNextLine())
		 {
		   String dueDate = reader.next();
		   String title = reader.next();
		   String desc = reader.next();
		   taskItem newtask = new taskItem(title, desc, dueDate);
		   tasks.add(newtask);
		 }
		 System.out.println("task list have been loaded");
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
      for(int i=0; i<tasks.size(); i++)
      {
        taskItem data = tasks.get(i);
        output.format("%s %s %s", data.getDate(), data.getTaskTitle(), data.getDescription());
      }
      output.close();
    }
    catch(FileNotFoundException ex){
      
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }
  
  
  
  public void view()
  {
	for(int i=0; i<tasks.size(); i++)
	{
	  taskItem data = tasks.get(i);
	  if(data.getComplete())
		  System.out.println(i+") *** ["+data.getDate()+"] " + data.getTaskTitle()+ ": "+data.getDescription());
	  else
		  System.out.println(i+") ["+data.getDate()+"] " + data.getTaskTitle()+ ": "+data.getDescription());
	}
  }
}
