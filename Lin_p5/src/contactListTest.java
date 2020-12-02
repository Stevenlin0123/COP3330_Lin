import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class contactListTest {

	@Test
	public void addingItemsIncreasesSize() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("pro", "", "", "himowdj@hotmail.com");
		a.addContact(b);
		a.addContact(c);
		assertEquals(2, a.size());
	}
	
	@Test
	public void editingItemsFailsWithAllBlankValues() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		a.addContact(b);
		assertThrows(IllegalArgumentException.class, ()-> new contactItem("", "", "", ""));
	}
	
	@Test
	public void editingItemsFailsWithInvalidIndex() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("hi", "", "", "");
		a.addContact(b);
		a.addContact(c);
		assertThrows(IndexOutOfBoundsException.class, ()-> a.replace(3, c));
	}
	
	@Test
	public void editingSucceedsWithBlankFirstName() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("", "a", "222-222-3333", "lmao@gmail.com");
		a.addContact(b);
		a.replace(0, c);
		assertEquals("", a.get(0).getContactFirst());
	}
	
	@Test
	public void editingSucceedsWithBlankLastName() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("xx", "", "222-222-3333", "lmao@gmail.com");
		a.addContact(b);
		a.replace(0, c);
		assertEquals("", a.get(0).getContactLast());
	}
	
	@Test
	public void editingSucceedsWithBlankPhone() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("xx", "hurry", "", "lmao@gmail.com");
		a.addContact(b);
		a.replace(0, c);
		assertEquals("", a.get(0).getNumber());
	}
	
	@Test
	public void editingSucceedsWithNonBlankValues() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("xx", "hurry", "172-000-1928", "lmao@gmail.com");
		a.addContact(b);
		a.replace(0, c);
		assertEquals("xx", a.get(0).getContactFirst());
		assertEquals("hurry", a.get(0).getContactLast());
		assertEquals("172-000-1928", a.get(0).getNumber());
		assertEquals("lmao@gmail.com", a.get(0).getEmail());
	}
	
	@Test
	public void newListIsEmpty() {
		contactList a = new contactList();
		assertEquals(0, a.size());
	}
	
	@Test
	public void removingItemsDecreasesSize() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("xx", "hurry", "172-000-1928", "lmao@gmail.com");
		a.addContact(b);
		a.addContact(c);
		a.removeContact(0);
		assertEquals(1, a.size());
	}
	
	@Test
	public void removingItemsFailsWithInvalidIndex() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("xx", "hurry", "172-000-1928", "lmao@gmail.com");
		a.addContact(b);
		a.addContact(c);
		assertThrows(IndexOutOfBoundsException.class, ()-> a.removeContact(3));
	}
	
	@Test
	public void savedContactListCanBeLoaded() {
		contactList a = new contactList();
		contactItem b = new contactItem("con", "Item", "444-444-4444", "hi@hotmail.com");
		contactItem c = new contactItem("xx", "hurry", "172-000-1928", "lmao@gmail.com");
		a.addContact(b);
		a.addContact(c);
		String file = "anotherexample.txt";
		a.write(file);
		a.read(file);
		assertEquals(c, a.get(1));
	}
}
