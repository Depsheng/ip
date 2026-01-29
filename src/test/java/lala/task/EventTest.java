package lala.task;

import lala.exception.NoDescriptionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class EventTest {
    @Test
    public void constructor_validInput_success() throws NoDescriptionException {
        Event e = new Event("event career fair /from 29-01-2026 13:30 /to 29-01-2026 14:30");

        assertEquals("[E][ ] career fair (from: Jan 29 2026 13:30 to: Jan 29 2026 14:30)", e.getDescription());
    }

    @Test
    public void markDone_changesStatusInDescription() throws NoDescriptionException {
        Event e = new Event("event career fair /from 29-01-2026 13:30 /to 29-01-2026 14:30");

        e.set(true); // Task.set(boolean) in your code
        assertTrue(e.getDescription().contains("[X]"));
    }
}
