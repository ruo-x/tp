package seedu.address.logic.commands.eventcommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;

/**
 * Shows additional information of a particular event.
 */
public class EventShowCommand extends Command {
    public static final String COMMAND_WORD = "eshow";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Shows additional details of event identified by the index number used in the displayed event list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SHOW_EVENT_SUCCESS = "Showing event: %1$s";

    private final Index targetIndex;

    public EventShowCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Event> lastShownList = model.getFilteredEventList();

        // If target index does not exist
        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EVENT_DISPLAYED_INDEX);
        }

        Event eventToShow = lastShownList.get(targetIndex.getZeroBased());

        return new CommandResult(String.format(MESSAGE_SHOW_EVENT_SUCCESS, eventToShow.getEventName().name),
                false,
                false,
                true,
                eventToShow);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EventShowCommand)) {
            return false;
        }

        EventShowCommand otherEventShowCommand = (EventShowCommand) other;
        return targetIndex.equals(otherEventShowCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
