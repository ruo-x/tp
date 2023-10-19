package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.Event;

/**
 * Controller for the pop-up window showing details of an event.
 */
public class EventWindow extends UiPart<Stage> {
    private static final Logger logger = LogsCenter.getLogger(EventWindow.class);
    private static final String FXML = "EventWindow.fxml";
    @FXML
    private Label eventMessage;

    /**
     * Creates a new EventWindow.
     * @param root Stage to use as the root of the EventWindow.
     */
    public EventWindow(Stage root) {
        super(FXML, root);
        eventMessage.setText("Currently no events to show.");
    }

    /**
     * Creates a new EventWindow.
     */
    public EventWindow() {
        this(new Stage());
    }

    public void setEventToShow(Event event) {
        eventMessage.setText(formatContents(event));
    }

    /**
     * Formats information of event to be displayed to the user.
     * @param event The event to display to user.
     * @return Formatted string with all information of the event.
     */
    public String formatContents(Event event) {
        if (event == null) {
            return "Currently no events to show.";
        }

        return "Name of event: \n"
                + event.getEventName().name + "\n\n"
                + "Date and time: \n"
                + event.getDateAndTime().toString() + "\n\n"
                + "Location: \n"
                + event.getLocation().location + "\n\n"
                + "Roles needed: \n"
                + event.getRoles().toString() + "\n\n"
                + "Materials and logistics needed (if any): \n"
                + event.getMaterials().toString() + "\n\n"
                + "Budget (if any): \n"
                + event.getBudget().budget + "\n\n"
                + "Description: \n"
                + event.getDescription().description;
    }

    /**
     * Shows the event window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.info("Showing event window");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the event window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the event window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the event window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}
