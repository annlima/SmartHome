/**
 * The LivingroomLightOnCommand class is a concrete implementation of the Command interface.
 * Specifically, this command is designed to turn on the light in a living room, represented by a Light object.
 * Additionally, it provides an undo functionality to revert the light to its previous state (off).
 */
public class LivingroomLightOnCommand implements Command {

    // Holds a reference to the Light object this command will operate on.
    private Light light;

    /**
     * Constructor for the LivingroomLightOnCommand.
     *
     * @param light The Light object representing the living room light that this command will control.
     */
    public LivingroomLightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * Executes the command, resulting in the activation of the living room light.
     * A message is also printed to the console to indicate the ongoing action.
     */
    @Override
    public void execute() {
        System.out.println("Turning on living room light...");
        light.on();
    }

    /**
     * Implements the undo functionality, which deactivates the living room light.
     * Additionally, a message is printed to the console to describe the undo action.
     */
    @Override
    public void undo() {
        System.out.println("Undoing action: turning off living room light...");
        light.off();
    }
}
