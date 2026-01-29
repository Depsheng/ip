package lala.task;

import lala.exception.NoDescriptionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DeadlineTest {
    @Test
    public void constructor_validInput_success() throws NoDescriptionException {
        Deadline dl = new Deadline("deadline lecture /by 16-10-2026 16:45");

        assertEquals("[D][ ] lecture (by: Oct 16 2026 16:45)", dl.getDescription());
    }

    @Test
    public void markDone_changesStatusInDescription() throws NoDescriptionException {
        Deadline dl = new Deadline("deadline lecture /by 16-10-2026 16:45");

        dl.set(true); // Task.set(boolean) in your code
        assertTrue(dl.getDescription().contains("[X]"));
    }
}
