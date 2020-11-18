import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class taskListTest {
	
	@Test
	public void addingTaskItemsIncreasesSize()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		tasks.add(a);
		assertEquals(1, tasks.size());
	}
	
	@Test
	public void completingTaskItemChangesStatus()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		tasks.add(a);
		a.setComplete(true);
		assertEquals(true, tasks.completed(a));
	}
	
	@Test
	public void completingTaskItemFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		int i=1;
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		tasks.add(a);
		assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(i).getComplete());
	}
	
	@Test
	public void editingTaskItemChangesValues()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi","hi", "2020-01-01");
		tasks.add(a);
		taskItem replacing = new taskItem("she", "she", "2020-02-02");
		tasks.replace(0, replacing);
		assertEquals(replacing, tasks.get(0));
	}
	
	@Test
	public void editingTaskItemDescriptionChangesValue()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi","hi", "2020-01-01");
		tasks.add(a);
		assertEquals("hello", a.setDescription("hello"));
	}
	
	@Test
	public void editingTaskItemDescriptionFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi","hi", "2020-01-01");
		taskItem b = new taskItem("hi", "hello", "2020-01-01");
		tasks.add(a);
		assertThrows(IndexOutOfBoundsException.class, ()-> tasks.replace(1, b));	
	}
	
	@Test
	public void editingTaskItemDueDateChangesValue()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		taskItem b = new taskItem("hi", "hi", "2020-02-02");
		tasks.add(a);
		tasks.replace(0, b);
		assertEquals("2020-02-02", tasks.get(0).getDate());
	}
	
	@Test
	public void editingTaskItemDueDateFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		taskItem b = new taskItem("hi", "hi", "2020-02-02");
		tasks.add(a);
		assertThrows(IndexOutOfBoundsException.class, ()-> tasks.replace(1, b));
	}
	
	@Test
	public void editingTaskItemTitleChangesValue()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		taskItem b = new taskItem("hello", "hi", "2020-01-01");
		tasks.add(a);
		tasks.replace(0, b);
		assertEquals("hello", tasks.get(0).getTaskTitle());
	}
	
	@Test
	public void editingTaskItemTitleFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		taskItem b = new taskItem("hello", "hi", "2020-01-01");
		tasks.add(a);
		assertThrows(IndexOutOfBoundsException.class, ()-> tasks.replace(1, b));
	}
	
	@Test
	public void gettingTaskItemDescriptionFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		tasks.add(a);	
		assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getDescription());
	}
	
	@Test
	public void gettingTaskItemDescriptionSucceedsWithValidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		tasks.add(a);	
		assertEquals("hey", tasks.get(0).getDescription());
	}
	
	@Test
	public void gettingTaskItemDueDateFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		tasks.add(a);	
		assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getDate());
	}
	
	@Test
	public void gettingTaskItemDueDateSucceedsWithValidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		tasks.add(a);	
		assertEquals("2020-01-01", tasks.get(0).getDate());
	}
	
	@Test
	public void gettingTaskItemTitleFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		tasks.add(a);	
		assertThrows(IndexOutOfBoundsException.class,()-> tasks.get(1).getTaskTitle());
	}
	
	@Test
	public void gettingTaskItemTitleSucceedsWithValidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hey", "2020-01-01");
		tasks.add(a);	
		assertEquals("hi", tasks.get(0).getTaskTitle());
	}
	
	@Test
	public void newTaskListIsEmpty()
	{
		taskList tasks = new taskList();
		assertEquals(0, tasks.size());
	}
	
	@Test
	public void removingTaskItemsDecreasesSize()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("first", "hey", "2020-01-01");
		taskItem b = new taskItem("second", "hey", "2020-01-01");
		taskItem c = new taskItem("third", "hey", "2020-01-01");
		tasks.add(a);	
		tasks.add(b);
		tasks.add(c);
		tasks.remove(2);
		assertEquals(2, tasks.size());
	}
	
	@Test
	public void removingTaskItemsFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("first", "hey", "2020-01-01");
		taskItem b = new taskItem("second", "hey", "2020-01-01");
		taskItem c = new taskItem("third", "hey", "2020-01-01");
		tasks.add(a);	
		tasks.add(b);
		tasks.add(c);
		assertThrows(IndexOutOfBoundsException.class,()-> tasks.remove(3));
	}
	
	@Test
	public void savedTaskListCanBeLoaded()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("first", "hey", "2020-01-01");
		taskItem b = new taskItem("second", "hey", "2020-01-01");
		tasks.add(a);	
		tasks.add(b);
		tasks.write("example.txt");
		tasks.read("example.txt");
		assertEquals(a, tasks.get(0));
	}
	
	@Test
	public void uncompletingTaskItemChangesStatus()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		tasks.add(a);
		a.setComplete(true);
		assertEquals(false, tasks.get(0).setComplete(false));
	}
	
	@Test
	public void uncompletingTaskItemFailsWithInvalidIndex()
	{
		taskList tasks = new taskList();
		taskItem a = new taskItem("hi", "hi", "2020-01-01");
		tasks.add(a);
		a.setComplete(true);
		assertThrows(IndexOutOfBoundsException.class, ()-> tasks.get(1).setComplete(false));
	}
}