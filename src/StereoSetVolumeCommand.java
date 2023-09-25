/**
 * Represents a command to set a Stereo system's volume to a specific level.
 * Implements the Command interface to provide concrete execution and undo functionalities.
 */
public class StereoSetVolumeCommand implements Command {

    private Stereo stereo;           // The stereo system that this command will operate on
    private int volume;              // The desired volume level that we want to set
    private int prevVolume;         // Keeps track of the previous volume level before the change
    private boolean isPrevVolumeSet = false;  // Flag to determine if prevVolume was set

    /**
     * Constructor initializes the command with a specific Stereo and desired volume level.
     *
     * @param stereo The stereo system that this command will operate on.
     * @param volume The desired volume level that we want to set.
     */
    public StereoSetVolumeCommand(Stereo stereo, int volume) {
        this.stereo = stereo;
        this.volume = volume;
    }

    /**
     * Executes the command to set the stereo's volume to the desired level.
     * Before doing so, it saves the current volume so that it can be
     * used to revert back to the original volume level if undo() is called.
     */
    @Override
    public void execute() {
        prevVolume = stereo.getVolume();  // Store the current volume before changing it
        isPrevVolumeSet = true;  // Indicate that prevVolume was set
        stereo.setVolume(volume);
    }

    /**
     * Undoes the command by reverting the stereo's volume back to its original setting.
     * Uses the saved previous volume level to determine the setting to revert to.
     */
    @Override
    public void undo() {
        if (isPrevVolumeSet) {
            stereo.setVolume(prevVolume);  // Restore the previous volume level
        } else {
            System.err.println("Error: prevVolume no ha sido establecido. No se puede deshacer.");
        }
    }
}
