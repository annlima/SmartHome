/**
 * The LightOffCommand class serves as a concrete implementation of the Command interface.
 * This command is designed to turn off a Light object and provides an undo
 * capability to turn it back on.
 */
public class LightOffCommand implements Command {

    // Holds a reference to the Light object that this command operates on.
    private Light light;

    /**
     * Constructor for the LightOffCommand.
     * @param light The Light object that this command will operate on.
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * Executes the command, leading to the turning off of the light.
     */
    @Override
    public void execute() {
        light.off();
    }

    /**
     * Implements the undo functionality, which results in turning on the light.
     */
    @Override
    public void undo() {
        light.on();
    }
}
