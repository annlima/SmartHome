/**
 * The LightOnCommand class serves as a concrete implementation of the Command interface.
 * This command is designed to turn on a Light object and provides an undo
 * capability to turn it back off.
 */
public class LightOnCommand implements Command {

    // Holds a reference to the Light object that this command operates on.
    private Light light;

    /**
     * Constructor for the LightOnCommand.
     *
     * @param light The Light object that this command will operate on.
     */
    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * Executes the command, resulting in turning on the light.
     */
    @Override
    public void execute() {
        light.on();
    }

    /**
     * Provides undo functionality, which will turn off the light.
     */
    @Override
    public void undo() {
        light.off();
    }
}
