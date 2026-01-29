package lala.task;

import lala.exception.NoDescriptionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ToDoTest {
    @Test
    public void constructor_validInput_success() throws NoDescriptionException {
        ToDo todo = new ToDo("todo read book");

        assertEquals("[T][ ] read book", todo.getDescription());
    }

    @Test
    public void markDone_changesStatusInDescription() throws NoDescriptionException {
        ToDo todo = new ToDo("todo read book");

        todo.set(true); // Task.set(boolean) in your code
        assertTrue(todo.getDescription().contains("[X]"));
    }
}
