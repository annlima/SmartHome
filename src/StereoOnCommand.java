/**
 * Represents a command to turn on a Stereo system.
 * Implements the Command interface to provide concrete execution and undo functionalities.
 */
public class StereoOnCommand implements Command {

    private Stereo stereo;  // The stereo system that this command will operate on

    /**
     * Constructor initializes the command with a specific Stereo.
     * @param stereo The stereo system that this command will operate on.
     */
    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * Executes the command to turn on the stereo system.
     */
    @Override
    public void execute() {
        stereo.on();
    }

    /**
     * Undoes the command by turning the stereo system off.
     */
    @Override
    public void undo() {
        stereo.off();
    }
}
