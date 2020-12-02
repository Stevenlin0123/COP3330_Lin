import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class contactItemTest {

	@Test
	public void creationFailsWithAllBlankValues(){
		assertThrows(IllegalArgumentException.class, ()-> new contactItem("", "", "", ""));
	}
	
	@Test
	public void creationSucceedsWithBlankEmail() {
		assertDoesNotThrow(()-> new contactItem("firstname", "lastname", "111-111-1111", ""));
		
	}
	
	@Test
	public void creationSucceedsWithBlankFirstName() {
		assertDoesNotThrow(()-> new contactItem("", "last", "222-222-2222", "lol@gmail.com"));
		
	}

	@Test
	public void creationSucceedsWithBlankLastName() {
		assertDoesNotThrow(()->new contactItem("first", "", "333-333-3333", "hi@yahoo.com"));
		
	}
	
	@Test
	public void creationSucceedsWithBlankPhone() {
		assertDoesNotThrow(()-> new contactItem("hi", "bye", "", "yello@gmail.com"));
	
	}
	
	@Test
	public void creationSucceedsWithNonBlankValues() {
		assertDoesNotThrow(()->new contactItem("contact", "Item", "444-444-4444", "hi@hotmail.com"));
		
	}
	
	@Test
	public void editingSucceedsWithBlankEmail() {
		contactItem a = new contactItem("contact", "Item", "444-444-4444", "hi@hotmail.com");
		a.setEmail("");
		assertEquals("", a.getEmail());
	}
	
	@Test
	public void editingSucceedsWithBlankFirstName() {
		contactItem a = new contactItem("contact", "Item", "444-444-4444", "hi@hotmail.com");
		a.setFirst("");
		assertEquals("", a.getContactFirst());
	}
	
	@Test
	public void editingSucceedsWithBlankLastName() {
		contactItem a = new contactItem("contact", "Item", "444-444-4444", "hi@hotmail.com");
		a.setLast("");
		assertEquals("", a.getContactLast());
	}
	
	@Test
	public void editingSucceedsWithBlankPhone() {
		contactItem a = new contactItem("contact", "Item", "444-444-4444", "hi@hotmail.com");
		a.setNumber("");
		assertEquals("", a.getNumber());
	}
	
	@Test
	public void editingSucceedsWithNonBlankValues() {
		contactItem a = new contactItem("contact", "Item", "444-444-4444", "hi@hotmail.com");
		a.setFirst("bye");
		a.setLast("jk");
		a.setNumber("824-221-3145");
		a.setEmail("coding101@gmail.com");
		assertEquals("bye", a.getContactFirst());
		assertEquals("jk", a.getContactLast());
		assertEquals("824-221-3145", a.getNumber());
		assertEquals("coding101@gmail.com", a.getEmail());
	}
	
	
}
