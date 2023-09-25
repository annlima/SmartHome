/**
 * The GarageLightOnCommand class is a concrete implementation of the Command interface.
 * This command is designed to turn on the light of a GarageDoor object 
 * and provides an undo capability to turn it back off.
 */
public class GarageLightOnCommand implements Command {

    // Holds a reference to the GarageDoor object that this command operates on.
    private GarageDoor garageDoor;

    /**
     * Constructor for the GarageLightOnCommand.
     * @param garageDoor The GarageDoor object whose light this command will operate on.
     */
    public GarageLightOnCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /**
     * Executes the command, leading to the activation of the light in the garage door.
     */
    @Override
    public void execute() {
        garageDoor.lightOn();
    }

    /**
     * Implements the undo functionality, which results in turning off the garage door light.
     */
    @Override
    public void undo() {
        garageDoor.lightOff();
    }
}
