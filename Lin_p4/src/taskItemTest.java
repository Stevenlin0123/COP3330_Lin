import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new taskItem("Word", "Desc", "2021-02-31"));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new taskItem("", "Desc", "2021-01-01"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new taskItem("Word", "Desc", "2021-01-01"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new taskItem("Word", "Desc", "2021-01-01"));
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() { //fails
        taskItem a = new taskItem("Word", "Desc", "2021-02-01");
        assertThrows(IllegalArgumentException.class, () -> a.setDate("2021-02-31"));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        taskItem a = new taskItem("Word", "Desc", "2021-01-01");
        assertEquals("2021-09-09", a.setDate("2021-09-09"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() { //fails
        taskItem a = new taskItem("lol", "Desc", "2021-01-01");
        assertThrows(IllegalArgumentException.class, () -> a.setTaskTitle(""));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        taskItem a = new taskItem("Word", "Desc", "2021-01-01");
        assertEquals("NewWord", a.setTaskTitle("NewWord"));
    }
}