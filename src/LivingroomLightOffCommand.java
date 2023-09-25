/**
 * The LivingroomLightOffCommand class is a concrete implementation of the Command interface.
 * This command is tailored to turn off the light of a living room, represented by a Light object.
 * Additionally, it offers an undo capability to revert the light to its previous state (on).
 */
public class LivingroomLightOffCommand implements Command {

    // Holds a reference to the Light object that this command operates on.
    private Light light;

    /**
     * Constructor for the LivingroomLightOffCommand.
     *
     * @param light The Light object representing the living room light that this command will operate on.
     */
    public LivingroomLightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * Executes the command, which results in the deactivation of the living room light.
     * It also prints a message to the console indicating the ongoing action.
     */
    @Override
    public void execute() {
        System.out.println("Turning off living room light...");
        light.off();
    }

    /**
     * Implements the undo functionality, which reactivates the living room light.
     * It also prints a message to the console indicating the undo action.
     */
    @Override
    public void undo() {
        System.out.println("Undoing action: turning on living room light...");
        light.on();
    }
}

