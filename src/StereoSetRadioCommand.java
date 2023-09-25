/**
 * Represents a command to set a Stereo system's mode to Radio with a specific station frequency.
 * Implements the Command interface to provide concrete execution and undo functionalities.
 */
public class StereoSetRadioCommand implements Command {

    private Stereo stereo;           // The stereo system that this command will operate on
    private float station;           // The radio station frequency that we want to set
    private float prevFrequency;     // Keeps track of the previous frequency before the change
    private String prevMode;         // Keeps track of the previous mode before the change
    private int prevVolume;          // Keeps track of the previous volume level before the change

    /**
     * Constructor initializes the command with a specific Stereo and desired station frequency.
     *
     * @param stereo The stereo system that this command will operate on.
     * @param station The radio station frequency that we want to set.
     */
    public StereoSetRadioCommand(Stereo stereo, float station) {
        this.stereo = stereo;
        this.station = station;
    }

    /**
     * Executes the command to set the stereo's mode to Radio and tunes to the desired station frequency.
     * Before doing so, it saves the current mode, frequency, and volume so that these can be
     * used to revert back to the original settings if undo() is called.
     */
    @Override
    public void execute() {
        prevMode = stereo.getMode();
        prevFrequency = stereo.getFrequency();  // Assuming the getFrequency() method is available in the Stereo class
        prevVolume = stereo.getVolume();
        stereo.setRadio(station);
    }

    /**
     * Undoes the command by reverting the stereo's mode, frequency, and volume back to their original settings.
     * Uses the saved previous mode, frequency, and volume to determine which settings to revert to.
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
                stereo.setRadio(prevFrequency);  // Using the previously saved frequency
                break;
            case "Off":
            default:
                stereo.off();
                break;
        }
        stereo.setVolume(prevVolume);
    }
}
