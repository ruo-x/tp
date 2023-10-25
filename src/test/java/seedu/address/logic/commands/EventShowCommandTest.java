package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showEventAtIndex;
import static seedu.address.testutil.TypicalEvents.getTypicalEventStorage;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;
import static seedu.address.testutil.TypicalVolunteers.getTypicalVolunteerStorage;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.eventcommands.EventShowCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.event.Event;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code EventShowCommand}.
 */
public class EventShowCommandTest {

    private Model model = new ModelManager(getTypicalEventStorage(), getTypicalVolunteerStorage(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Event eventToShow = model.getFilteredEventList().get(INDEX_FIRST.getZeroBased());
        EventShowCommand eventShowCommand = new EventShowCommand(INDEX_FIRST);

        CommandResult expectedCommandResult =
                new CommandResult(
                        String.format(EventShowCommand.MESSAGE_SHOW_EVENT_SUCCESS,
                                eventToShow.getEventName().eventName),
                        false, false, true, false);

        ModelManager expectedModel = new ModelManager(model.getEventStorage(), model.getVolunteerStorage(),
                new UserPrefs());

        Predicate<Event> predicateShowEvent = e -> e.equals(eventToShow);
        expectedModel.updateEventToShowList(predicateShowEvent);

        assertCommandSuccess(eventShowCommand, model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredEventList().size() + 1);
        EventShowCommand eventShowCommand = new EventShowCommand(outOfBoundIndex);

        assertCommandFailure(eventShowCommand, model, Messages.MESSAGE_INVALID_EVENT_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showEventAtIndex(model, INDEX_FIRST);

        Event eventToShow = model.getFilteredEventList().get(INDEX_FIRST.getZeroBased());
        EventShowCommand eventShowCommand = new EventShowCommand(INDEX_FIRST);

        CommandResult expectedCommandResult = new CommandResult(
                String.format(EventShowCommand.MESSAGE_SHOW_EVENT_SUCCESS,
                    eventToShow.getEventName().eventName),
                false, false, true, false);

        Model expectedModel = new ModelManager(model.getEventStorage(), model.getVolunteerStorage(), new UserPrefs());

        Predicate<Event> predicateShowEvent = e -> e.equals(eventToShow);
        expectedModel.updateEventToShowList(predicateShowEvent);

        showEventAtIndex(expectedModel, INDEX_FIRST);

        assertCommandSuccess(eventShowCommand, model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showEventAtIndex(model, INDEX_FIRST);

        Index outOfBoundIndex = INDEX_SECOND;
        // ensures that outOfBoundIndex is still in bounds of iVolunteer list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getEventStorage().getEventList().size());

        EventShowCommand eventShowCommand = new EventShowCommand(outOfBoundIndex);

        assertCommandFailure(eventShowCommand, model, Messages.MESSAGE_INVALID_EVENT_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        EventShowCommand showFirstEventCommand = new EventShowCommand(INDEX_FIRST);
        EventShowCommand showSecondEventCommand = new EventShowCommand(INDEX_SECOND);

        // same object -> returns true
        assertTrue(showFirstEventCommand.equals(showFirstEventCommand));

        // same values -> returns true
        EventShowCommand showFirstEventCommandCopy = new EventShowCommand(INDEX_FIRST);
        assertTrue(showFirstEventCommand.equals(showFirstEventCommandCopy));

        // different types -> returns false
        assertFalse(showFirstEventCommand.equals(1));

        // null -> returns false
        assertFalse(showFirstEventCommand.equals(null));

        // different volunteer -> returns false
        assertFalse(showFirstEventCommand.equals(showSecondEventCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        EventShowCommand eventShowCommand = new EventShowCommand(targetIndex);
        String expected = EventShowCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, eventShowCommand.toString());
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoEvent(Model model) {
        model.updateFilteredEventList(p -> false);

        assertTrue(model.getFilteredEventList().isEmpty());
    }

}
