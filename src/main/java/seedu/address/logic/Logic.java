package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyEventStorage;
import seedu.address.model.ReadOnlyVolunteerStorage;
import seedu.address.model.event.Event;
import seedu.address.model.volunteer.Volunteer;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the EventStorage.
     *
     * @see seedu.address.model.Model#getVolunteerStorage()
     */
    ReadOnlyEventStorage getEventStorage();

    /** Returns an unmodifiable view of the filtered list of events. */
    ObservableList<Event> getFilteredEventList();

    /**
     * Returns an unmodifiable view of the sorted list of all events.
     */
    ObservableList<Event> getSortedEventList();

    /** Returns an unmodifiable view of the event to display in event window */
    ObservableList<Event> getEventToShowList();

    /**
     * Returns the user prefs' event storage file path.
     */
    Path getEventStorageFilePath();

    /**
     * Returns the VolunteerStorage.
     *
     * @see seedu.address.model.Model#getVolunteerStorage()
     */
    ReadOnlyVolunteerStorage getVolunteerStorage();

    /** Returns an unmodifiable view of the filtered list of volunteers */
    ObservableList<Volunteer> getFilteredVolunteerList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getVolunteerStorageFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);
}
