/**
 * Represents a command to set a Stereo system's mode to DVD.
 * Implements the Command interface to provide concrete execution and undo functionalities.
 */
public class StereoSetDVDCommand implements Command {

    private Stereo stereo;   // The stereo system that this command will operate on
    private String prevMode; // Keeps track of the previous mode before the change
    private int prevVolume;  // Keeps track of the previous volume level before the change

    /**
     * Constructor initializes the command with a specific Stereo.
     *
     * @param stereo The stereo system that this command will operate on.
     */
    public StereoSetDVDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * Executes the command to set the stereo's mode to DVD.
     * Before doing so, it saves the current mode and volume so that these can be
     * used to revert back to the original settings if undo() is called.
     */
    @Override
    public void execute() {
        prevMode = stereo.getMode();
        prevVolume = stereo.getVolume();
        stereo.setDVD();
    }

    /**
     * Undoes the command by reverting the stereo's mode and volume back to their original settings.
     * Uses the saved previous mode and volume to determine which settings to revert to.
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
    // Restore the previous volume
        stereo.setVolume(prevVolume);
    }
}
