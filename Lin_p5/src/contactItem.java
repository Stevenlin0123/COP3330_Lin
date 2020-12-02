
public class contactItem {
  private String firstName; 
  private String lastName;
  private String number;
  private String email;
  
  public contactItem(String first, String last, String number, String email)
  {
	if(isContactValid(first, last, number, email))
	{
        this.firstName = first;
        this.lastName = last;
      
      
      if(isValidNumber(number))
      {
        this.number = number;
      }
      else
      {
        throw new IllegalArgumentException("WARNING: invalid number");
      }
      if(isEmailValid(email))
      {
    	 this.email = email;
      }
      else
      {
    	throw new IllegalArgumentException("Warning: invalid email");
      }
	} 
	else
		throw new IllegalArgumentException("Warning: contact not created");
  }
  
  
  public String getContactFirst() 
  {
    return this.firstName;
  }
  
  public String getContactLast()
  {
	return this.lastName;
  }

  public String getNumber() 
  {
    return this.number;
  }


  public String getEmail()
  {
    return this.email;
  }

  public void setFirst(String first)
  {
	this.firstName = first;
  }
  
  public void setLast(String last)
  {
	this.lastName = last;
  }

  public void setNumber(String num) 
  {
    if(isValidNumber(num))
    {
    	this.number = num;
    }
    else
    {
    	throw new IllegalArgumentException("WARNING: invalid number; contact not created");
    }
  }


  public void setEmail(String email)
  {
	 if(isEmailValid(email))
	 {
		 this.email = email;
	 }
	 else
	 {
		throw new IllegalArgumentException("WARNING: invalid email; contact not created");
	 }
  }

  private boolean isValidNumber(String num) {
    if(num.matches("\\d{3}[-]\\d{3}[-]\\d{4}") || num.length() == 0)
    {
    	return true;
    }
    return false;
  }
  
  private boolean isEmailValid(String email)
  {
	if(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") || email.length() == 0)
	{
		return true;
	}
	return false;
  }
  
  private boolean isContactValid(String first, String last, String num, String email)
  {
	if(first.length()!=0 || last.length()!=0)
		return true;
	else if(isValidNumber(num) && num.length()!=0)
		return true;
	else if(isEmailValid(email) && email.length()!=0)
		return true;
	else
		return false;
  }

}
