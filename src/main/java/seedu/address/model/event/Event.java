package seedu.address.model.event;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents an Event in the Event list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Event implements Comparable<Event> {
    // Identity fields
    private final EventName eventName;

    // Data fields
    private final Set<Role> roles;
    private final DateTime startDate;
    private final DateTime endDate;
    private final Location location;
    private final Description description;
    private final Set<Material> materials;
    private final Budget budget;

    /**
     * Every field must be present and not null.
     */
    public Event(EventName eventName, Set<Role> roles, DateTime startDate, DateTime endDate, Location location,
                 Description description, Set<Material> materials, Budget budget) {
        requireAllNonNull(eventName, roles, startDate, endDate, location, description, materials, budget);
        this.eventName = eventName;
        this.roles = roles;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.materials = materials;
        this.budget = budget;
    }

    public EventName getEventName() {
        return eventName;
    }
    /**
     * Returns an immutable Role set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }
    public DateTime getStartDate() {
        return startDate;
    }
    public DateTime getEndDate() {
        return endDate;
    }

    public Location getLocation() {
        return location;
    }
    public Description getDescription() {
        return description;
    }
    /**
     * Returns an immutable Material set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Material> getMaterials() {
        return Collections.unmodifiableSet(materials);
    }
    public Budget getBudget() {
        return budget;
    }
    /**
     * Returns true if both events have the same name.
     * This defines a weaker notion of equality between two events.
     */
    public boolean isSameEvent(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getEventName().equals(getEventName());
    }

    /**
     * Returns true if both events have the same identity and data fields.
     * This defines a stronger notion of equality between two events.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return eventName.equals(otherEvent.eventName)
                && roles.equals(otherEvent.roles)
                && startDate.equals(otherEvent.startDate)
                && endDate.equals(otherEvent.endDate)
                && location.equals(otherEvent.location)
                && description.equals(otherEvent.description)
                && materials.equals(otherEvent.materials)
                && budget.equals(otherEvent.budget);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(eventName, roles, startDate, endDate, location, description, materials, budget);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", eventName)
                .add("roles", roles)
                .add("startDate", startDate)
                .add("endDate", endDate)
                .add("location", location)
                .add("description", description)
                .add("materials", materials)
                .add("budget", budget)
                .toString();
    }

    /**
     * Compares two Event objects. This Event is lesser than the specified Event if start date is before the other.
     * If start dates are the same, this event is lesser than the specified Event if end date is before the other.
     *
     * @param otherEvent the object to be compared.
     * @return Integer where -1 represents lesser than, 0 represents equal, 1 represents greater than.
     */
    @Override
    public int compareTo(Event otherEvent) {
        if (startDate.dateAndTime.isBefore(otherEvent.startDate.dateAndTime)) {
            return -1;
        } else if (startDate.dateAndTime.equals(otherEvent.startDate.dateAndTime)) {
            if (endDate.dateAndTime.isBefore(otherEvent.endDate.dateAndTime)) {
                return -1;
            } else if (endDate.dateAndTime.isAfter(otherEvent.endDate.dateAndTime)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

}
