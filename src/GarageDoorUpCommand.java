/**
 * The GarageDoorUpCommand class serves as a concrete implementation of the Command interface.
 * This command is designed to open a GarageDoor and provides an undo
 * capability to close it back.
 */
public class GarageDoorUpCommand implements Command {

    // Holds a reference to the GarageDoor object that this command operates on.
    private GarageDoor garageDoor;

    /**
     * Constructor for the GarageDoorUpCommand.
     *
     * @param garageDoor The GarageDoor object that this command will operate on.
     */
    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /**
     * Executes the command, leading to the opening of the garage door.
     */
    @Override
    public void execute() {
        garageDoor.up();
    }

    /**
     * Implements the undo functionality, resulting in the closing of the garage door.
     */
    @Override
    public void undo() {
        garageDoor.down();
    }
}
