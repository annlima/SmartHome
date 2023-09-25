/**
 * The GarageLightOffCommand class is a concrete implementation of the Command interface.
 * This command is intended to turn off the light of a GarageDoor object
 * and also provides an undo capability to turn it back on.
 */
public class GarageLightOffCommand implements Command {

    // Holds a reference to the GarageDoor object that this command operates on.
    private GarageDoor garageDoor;

    /**
     * Constructor for the GarageLightOffCommand.
     * @param garageDoor The GarageDoor object whose light this command will operate on.
     */
    public GarageLightOffCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /**
     * Executes the command, resulting in the deactivation of the light in the garage door.
     */
    @Override
    public void execute() {
        garageDoor.lightOff();
    }

    /**
     * Implements the undo functionality, which turns on the garage door light.
     */
    @Override
    public void undo() {
        garageDoor.lightOn();
    }
}
