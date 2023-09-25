/**
 * CeilingFanOffCommand is a concrete implementation of the Command interface.
 * This command is responsible for turning off a CeilingFan and provides an undo
 * functionality to turn it back on.
 */
public class CeilingFanOffCommand implements Command {

    // Holds a reference to the CeilingFan object this command operates on.
    private CeilingFan ceilingFan;

    /**
     * Constructor for the CeilingFanOffCommand.
     *
     * @param ceilingFan The CeilingFan object this command will operate on.
     */
    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * Executes the command, turning off the ceiling fan.
     */
    @Override
    public void execute() {
        ceilingFan.off();
    }

    /**
     * Provides undo functionality, turning the ceiling fan back on.
     */
    @Override
    public void undo() {
        ceilingFan.on();
    }
}
