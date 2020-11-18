import java.text.ParseException;
import java.text.SimpleDateFormat;

public class taskItem {
  private String title; 
  private String description;
  private String dueDate;
  private boolean complete;
  
  public taskItem(String title, String description, String dueDate)
  {
	  this.complete = false;
      if(isTitleValid(title))
      {
        this.title = title;
      }
      else
      {
        throw new IllegalArgumentException("Warning: title must be at least 1 character long; task not created");  
      }
      this.description = description;
      if(isValidDate(dueDate))
      {
        this.dueDate = dueDate;
      }
      else
      {
        throw new IllegalArgumentException("WARNING: invalid due date; task not created");
      }
  }
  
  
  public String getTaskTitle() 
  {
    return this.title;
  }

  public String getDescription() 
  {
    return this.description;
  }


  public String getDate()
  {
    return this.dueDate;
  }

  public String setTaskTitle(String title) 
  {
	if(isTitleValid(title))
		return this.title = title;
	else
		throw new IllegalArgumentException("Warning: title must be at least 1 character long; task not created");
  }

  public String setDescription(String desc) 
  {
    return this.description = desc;
  }


  public String setDate(String date)
  {
	 if(isValidDate(date))
	 {
		 return this.dueDate = date;
	 }
	 else
	 {
		throw new IllegalArgumentException("WARNING: invalid due date; task not created");
	 }
  }
  
  private boolean isTitleValid(String title)
  {
    return title.length() > 0;
  }

  public boolean getComplete()
  {
	return this.complete;
  }

  private boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } 
    catch (ParseException pe) {
      return false;
    }
    return true;
  }


  public boolean setComplete(boolean i) 
  {
	if(this.complete != i)
		return this.complete = i;
	else
		System.out.println("Cannot change status");
	return i;
  }

}
