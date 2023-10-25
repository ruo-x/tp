package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.Event;
import seedu.address.model.volunteer.Volunteer;

/**
 * Represents the in-memory model of the eventStorage and volunteerStorage data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final VolunteerStorage volunteerStorage;
    private final EventStorage eventStorage;
    private final UserPrefs userPrefs;
    private final FilteredList<Volunteer> filteredVolunteers;
    private final FilteredList<Event> filteredEvents;
    private SortedList<Event> sortedEvents;
    private final FilteredList<Event> eventToShowList;

    private ObservableList<Event> lastShownEventList;

    /**
     * Initializes a ModelManager with the given eventStorage, volunteerStorage and userPrefs.
     */
    public ModelManager(ReadOnlyEventStorage eventStorage, ReadOnlyVolunteerStorage volunteerStorage,
                        ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(volunteerStorage, eventStorage, userPrefs);

        logger.fine("Initializing with volunteer storage: " + volunteerStorage + " and user prefs " + userPrefs);
        logger.fine("Initializing with event storage: " + eventStorage + " and user prefs " + userPrefs);

        this.eventStorage = new EventStorage(eventStorage);
        this.volunteerStorage = new VolunteerStorage(volunteerStorage);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredEvents = new FilteredList<>(this.eventStorage.getEventList());
        filteredVolunteers = new FilteredList<>(this.volunteerStorage.getVolunteerList());
        eventToShowList = new FilteredList<>(this.eventStorage.getEventList());
        sortedEvents = new SortedList<>(this.eventStorage.getEventList());
        lastShownEventList = null;
    }

    public ModelManager() {
        this(new EventStorage(), new VolunteerStorage(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getVolunteerStorageFilePath() {
        return userPrefs.getVolunteerStorageFilePath();
    }

    @Override
    public Path getEventStorageFilePath() {
        return userPrefs.getEventStorageFilePath();
    }

    @Override
    public void setVolunteerStorageFilePath(Path volunteerStorageFilePath) {
        requireNonNull(volunteerStorageFilePath);
        userPrefs.setVolunteerStorageFilePath(volunteerStorageFilePath);
    }

    @Override
    public void setEventStorageFilePath(Path eventStorageFilePath) {
        requireNonNull(eventStorageFilePath);
        userPrefs.setEventStorageFilePath(eventStorageFilePath);
    }

    //=========== Event Storage ================================================================================
    @Override
    public void setEventStorage(ReadOnlyEventStorage eventStorage) {
        this.eventStorage.resetData(eventStorage);
    }

    @Override
    public ReadOnlyEventStorage getEventStorage() {
        return eventStorage;
    }

    @Override
    public boolean hasEvent(Event event) {
        requireNonNull(event);
        return eventStorage.hasEvent(event);
    }

    @Override
    public void deleteEvent(Event target) {
        eventStorage.removeEvent(target);
    }
    @Override
    public void addEvent(Event event) {
        eventStorage.addEvent(event);
        updateFilteredEventList(PREDICATE_SHOW_ALL_EVENTS);
    }

    @Override
    public void setEvent(Event target, Event editedEvent) {
        requireAllNonNull(target, editedEvent);

        eventStorage.setEvent(target, editedEvent);
    }

    //=========== Volunteer Storage ================================================================================

    @Override
    public void setVolunteerStorage(ReadOnlyVolunteerStorage volunteerStorage) {
        this.volunteerStorage.resetData(volunteerStorage);
    }

    @Override
    public ReadOnlyVolunteerStorage getVolunteerStorage() {
        return volunteerStorage;
    }

    @Override
    public boolean hasVolunteer(Volunteer volunteer) {
        requireNonNull(volunteer);
        return volunteerStorage.hasVolunteer(volunteer);
    }

    @Override
    public void deleteVolunteer(Volunteer target) {
        volunteerStorage.removeVolunteer(target);
    }

    @Override
    public void addVolunteer(Volunteer volunteer) {
        volunteerStorage.addVolunteer(volunteer);
        updateFilteredVolunteerList(PREDICATE_SHOW_ALL_VOLUNTEERS);
    }

    @Override
    public void setVolunteer(Volunteer target, Volunteer editedVolunteer) {
        requireAllNonNull(target, editedVolunteer);

        volunteerStorage.setVolunteer(target, editedVolunteer);
    }

    //=========== Filtered Event List Accessors =============================================================

    @Override
    public ObservableList<Event> getLastShownEventList() {
        return lastShownEventList;
    }

    /**
     * Returns an unmodifiable view of the list of {@code Event} backed by the internal list of
     * {@code versionedEventStorage}
     */
    @Override
    public ObservableList<Event> getFilteredEventList() {
        return filteredEvents;
    }

    @Override
    public void updateFilteredEventList(Predicate<Event> predicate) {
        requireNonNull(predicate);
        filteredEvents.setPredicate(predicate);
        eventToShowList.setPredicate(predicate);
        lastShownEventList = filteredEvents;
    }

    @Override
    public SortedList<Event> getSortedEventList() {
        sortedEvents = filteredEvents.filtered(PREDICATE_SHOW_ALL_EVENTS).sorted(Event::compareTo);
        lastShownEventList = sortedEvents;
        return sortedEvents;
    }

    /**
     * Returns an unmodifiable view of the list of {@code Event} backed by the internal list of
     * {@code versionedEventStorage}
     */
    @Override
    public FilteredList<Event> getEventToShowList() {
        return eventToShowList;
    }

    @Override
    public void updateEventToShowList(Predicate<Event> eventPredicate) {
        requireNonNull(eventPredicate);
        eventToShowList.setPredicate(eventPredicate);
    }

    //=========== Filtered Volunteer Storage Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Volunteer} backed by the internal list of
     * {@code versionedVolunteerStorage}
     */
    @Override
    public ObservableList<Volunteer> getFilteredVolunteerList() {
        return filteredVolunteers;
    }

    @Override
    public void updateFilteredVolunteerList(Predicate<Volunteer> predicate) {
        requireNonNull(predicate);
        filteredVolunteers.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModelManager)) {
            return false;
        }

        ModelManager otherModelManager = (ModelManager) other;
        return volunteerStorage.equals(otherModelManager.volunteerStorage)
                && eventStorage.equals(otherModelManager.eventStorage)
                && userPrefs.equals(otherModelManager.userPrefs)
                && filteredVolunteers.equals(otherModelManager.filteredVolunteers)
                && filteredEvents.equals(otherModelManager.filteredEvents)
                && eventToShowList.equals(otherModelManager.eventToShowList);
    }

}
