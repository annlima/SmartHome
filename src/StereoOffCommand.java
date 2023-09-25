/**
 * Represents a command to turn off a Stereo system.
 * Implements the Command interface to provide concrete execution and undo functionalities.
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;  // The stereo system that this command will operate on

    /**
     * Constructor initializes the command with a specific Stereo.
     * @param stereo The stereo system that this command will operate on.
     */
    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * Executes the command to turn off the stereo system.
     */
    @Override
    public void execute() {
        stereo.off();
    }

    /**
     * Undoes the command by turning the stereo system on.
     */
    @Override
    public void undo() {
        stereo.on();
    }
}
