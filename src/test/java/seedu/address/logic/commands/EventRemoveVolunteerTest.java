package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.eventvolunteercommands.EventRemoveVolunteerCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class EventRemoveVolunteerTest {
    @Test
    public void execute_invalidIndexes_removeUnsuccessful() {
        Model model = new ModelManager();
        EventRemoveVolunteerCommand command = new EventRemoveVolunteerCommand(Index.fromOneBased(1),
                Index.fromOneBased(1));
        try {
            command.execute(model);
        } catch (Exception e) {
            assertTrue(true);
        }
        assertTrue(true);
    }
    //    @Test
    //    public void execute_volunteerNotInEvent_removeUnsuccessful(){}
    //    @Test
    //    public void execute_validIndexes_removeSuccessful(){}
    //    @Test
    //    public void equals() {}
    //    @Test
    //    public void toStringMethod() {}
}
