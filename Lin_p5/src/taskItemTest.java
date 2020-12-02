import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class taskItemTest {

	@Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new taskItem("Word", "Desc", "2021-02-31"));
    }
	
    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new taskItem("", "Desc", "2021-01-01"));
    }
    
    @Test
    public void constructorSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new taskItem("Word", "Desc", "2021-01-01"));
    }
    
    @Test
    public void constructorSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new taskItem("Word", "Desc", "2021-01-01"));
    }
    
    @Test
    public void editingDescriptionSucceedWithExpectedValue() {
    	taskItem a = new taskItem("Word", "Desc", "2021-03-01");
    	a.setDescription("new desc");
    	assertEquals("new desc", a.getDescription());
    }
    
    @Test
    public void editingDueDateFailsWithInvalidDateFormat() { //fails
        taskItem a = new taskItem("Word", "Desc", "2021-02-01");
        assertThrows(IllegalArgumentException.class, () -> a.setDate("2021/02/20"));
    }
    
    @Test
    public void editingDueDateFailsWithInvalidYYYYMMDD() { //fails
        taskItem a = new taskItem("Word", "Desc", "2021-02-01");
        assertThrows(IllegalArgumentException.class, () -> a.setDate("2021-02-31"));
    }
    
    @Test
    public void editingDueDateSucceedWithExpectedValue() {
        taskItem a = new taskItem("Word", "Desc", "2021-01-01");
        a.setDate("2021-09-09");
        assertEquals("2021-09-09", a.getDate());
    }
    
    @Test
    public void editingTitleFailsWithEmptyString() { //fails
        taskItem a = new taskItem("lol", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> a.setTaskTitle(""));
    }
    
    @Test
    public void editingTitleSucceedWithExpectedValue() {
        taskItem a = new taskItem("Word", "Desc", "2021-01-01");
        a.setTaskTitle("NewWord");
        assertEquals("NewWord", a.getTaskTitle());
    }

}
