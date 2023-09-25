/**
 * Represents a command to set a Stereo system's mode to CD.
 * Implements the Command interface to provide concrete execution and undo functionalities.
 */
public class StereoSetCDCommand implements Command {

    private Stereo stereo;   // The stereo system that this command will operate on
    private String prevMode; // Keeps track of the previous mode before the change
    /**
     * Constructor initializes the command with a specific Stereo.
     * @param stereo The stereo system that this command will operate on.
     */
    public StereoSetCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    /**
     * Executes the command to set the stereo's mode to CD.
     * Before doing so, it saves the current mode so that it can be used to revert
     * back to the original mode if undo() is called.
     */
    @Override
    public void execute() {
        prevMode = stereo.getMode();
        stereo.setCD();
    }
    /**
     * Undoes the command by reverting the stereo's mode back to its original mode.
     * Uses the saved previous mode to determine which mode to revert to.
     */
    @Override
    public void undo() {
        if (prevMode == null) {
            System.err.println("Error: prevMode es null. No se puede deshacer.");
            return;
        }
        switch (prevMode) {
            case "CD":
                stereo.setCD();
                break;
            case "DVD":
                stereo.setDVD();
                break;
            case "Radio":
                // Aquí, estamos asumiendo una frecuencia predeterminada, por ejemplo, 88.0
                stereo.setRadio(88.0f);
                break;
            case "Off":
            default:
                stereo.off();
                break;
        }
    }
}
