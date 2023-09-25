/**
 * CeilingFanOnCommand is a concrete implementation of the Command interface.
 * This command is responsible for turning on a CeilingFan and provides an undo
 * functionality to turn it back off.
 */
public class CeilingFanOnCommand implements Command {

    // Holds a reference to the CeilingFan object this command operates on.
    private CeilingFan ceilingFan;

    /**
     * Constructor for the CeilingFanOnCommand.
     *
     * @param ceilingFan The CeilingFan object this command will operate on.
     */
    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * Executes the command, turning on the ceiling fan.
     */
    @Override
    public void execute() {
        ceilingFan.on();
    }

    /**
     * Provides undo functionality, turning the ceiling fan back off.
     */
    @Override
    public void undo() {
        ceilingFan.off();
    }
}
