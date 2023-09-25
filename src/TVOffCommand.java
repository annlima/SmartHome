
/**
 * Represents a command to turn off a TV.
 * Implements the Command interface, providing an execution and undo functionality.
 */
public class TVOffCommand implements Command {

    private TV tv;  // The TV instance the command will operate on

    /**
     * Constructs a TVOffCommand.
     * @param tv The TV instance that this command will operate on.
     */
    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    /**
     * Executes the command to turn off the TV.
     */
    @Override
    public void execute() {
        tv.off();
    }

    /**
     * Undoes the TV off command, effectively turning the TV on.
     */
    @Override
    public void undo() {
        tv.on();
    }
}
