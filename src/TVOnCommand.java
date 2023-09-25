/**
 * Represents a command to turn on a TV.
 * Implements the Command interface, providing both execution and undo functionality.
 */
public class TVOnCommand implements Command {

    private TV tv;  // The TV instance the command will operate on

    /**
     * Constructs a TVOnCommand
     * @param tv The TV instance that this command will operate on.
     */
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    /**
     * Executes the command to turn on the TV.
     */
    @Override
    public void execute() {
        tv.on();
    }

    /**
     * Undoes the TV on command, effectively turning the TV off.
     */
    @Override
    public void undo() {
        tv.off();
    }
}

