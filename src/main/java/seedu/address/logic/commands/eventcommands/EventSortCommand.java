package seedu.address.logic.commands.eventcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Temporarily sorts all events by their date and time, in ascending order.
 */
public class EventSortCommand extends Command {
    public static final String COMMAND_WORD = "esort";

    public static final String MESSAGE_SUCCESS = "Sorted all events by their date and time, in ascending order";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SUCCESS, false, false, false, true);
    }
}
