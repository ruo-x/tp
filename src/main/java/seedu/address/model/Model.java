package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.event.Event;
import seedu.address.model.volunteer.Volunteer;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Event> PREDICATE_SHOW_ALL_EVENTS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Volunteer> PREDICATE_SHOW_ALL_VOLUNTEERS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    //=========== Event Storage ================================================================================
    /**
     * Returns the user prefs' event storage file path.
     */
    Path getEventStorageFilePath();

    /**
     * Sets the user prefs' event storage file path.
     */
    void setEventStorageFilePath(Path eventStorageFilePath);

    /**
     * Replaces event storage data with the data in {@code eventStorage}.
     */
    void setEventStorage(ReadOnlyEventStorage eventStorage);

    /** Returns the EventStorage */
    ReadOnlyEventStorage getEventStorage();

    /**
     * Returns true if an event with the same identity as {@code event} exists in the event storage.
     */
    boolean hasEvent(Event event);

    /**
     * Deletes the given event.
     * The event must exist in the event storage.
     */
    void deleteEvent(Event target);

    /**
     * Adds the given event.
     * {@code event} must not already exist in the event storage.
     */
    void addEvent(Event event);

    /**
     * Replaces the given event {@code target} with {@code editedEvent}.
     * {@code target} must exist in the event storage.
     * The event identity of {@code editedEvent} must not be the same as another existing event in the event storage.
     */
    void setEvent(Event target, Event editedEvent);

    /**
     * Returns an unmodifiable view of the last shown event list.
     */
    ObservableList<Event> getLastShownEventList();

    /** Returns an unmodifiable view of the filtered event list */
    ObservableList<Event> getFilteredEventList();

    /**
     * Updates the filter of the filtered event list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredEventList(Predicate<Event> predicate);

    /**
     * Returns an unmodifiable view of the sorted event list.
     */
    ObservableList<Event> getSortedEventList();

    /** Returns an unmodifiable view of the event to display in the event window */
    ObservableList<Event> getEventToShowList();

    /**
     * Updates the filter of the eventToShow list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateEventToShowList(Predicate<Event> eventPredicate);

    //=========== Volunteer Storage ================================================================================
    /**
     * Returns the user prefs' volunteer storage file path.
     */
    Path getVolunteerStorageFilePath();

    /**
     * Sets the user prefs' volunteer storage file path.
     */
    void setVolunteerStorageFilePath(Path volunteerStorageFilePath);

    /**
     * Replaces volunteer storage data with the data in {@code volunteerStorage}.
     */
    void setVolunteerStorage(ReadOnlyVolunteerStorage volunteerStorage);

    /** Returns the VolunteerStorage */
    ReadOnlyVolunteerStorage getVolunteerStorage();

    /**
     * Returns true if a volunteer with the same identity as {@code volunteer} exists in the volunteer storage.
     */
    boolean hasVolunteer(Volunteer volunteer);

    /**
     * Deletes the given volunteer.
     * The volunteer must exist in the volunteer storage.
     */
    void deleteVolunteer(Volunteer target);

    /**
     * Adds the given volunteer.
     * {@code volunteer} must not already exist in the volunteer storage.
     */
    void addVolunteer(Volunteer volunteer);

    /**
     * Replaces the given volunteer {@code target} with {@code editedVolunteer}.
     * {@code target} must exist in the volunteer storage.
     * The volunteer identity of {@code editedVolunteer} must not be the same as another existing volunteer
     * in the volunteer storage.
     */
    void setVolunteer(Volunteer target, Volunteer editedVolunteer);

    /** Returns an unmodifiable view of the filtered volunteer list */
    ObservableList<Volunteer> getFilteredVolunteerList();

    /**
     * Updates the filter of the filtered volunteer list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredVolunteerList(Predicate<Volunteer> predicate);
}
