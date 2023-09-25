/**
 * The GarageDoorDownCommand class serves as a concrete implementation of the Command interface.
 * This command is responsible for closing a GarageDoor and offers an undo
 * function to open it back.
 */
public class GarageDoorDownCommand implements Command {

    // Holds a reference to the GarageDoor object that this command operates on.
    private GarageDoor garageDoor;

    /**
     * Constructor for the GarageDoorDownCommand.
     * @param garageDoor The GarageDoor object that this command will operate on.
     */
    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    /**
     * Executes the command, which results in the closing of the garage door.
     */
    @Override
    public void execute() {
        garageDoor.down();
    }

    /**
     * Provides undo functionality, which will open the garage door back.
     */
    @Override
    public void undo() {
        garageDoor.up();
    }
}
