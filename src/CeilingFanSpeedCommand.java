/**
 * CeilingFanSpeedCommand is a concrete implementation of the Command interface.
 * This command changes the speed of a CeilingFan and provides an undo functionality
 * to revert back to the previous speed setting.
 */
public class CeilingFanSpeedCommand implements Command {

    // Holds a reference to the CeilingFan object this command operates on.
    private CeilingFan ceilingFan;

    // Used to store the previous speed setting of the fan in case the undo operation is invoked.
    private int prevSpeed;

    /**
     * Constructor for the CeilingFanSpeedCommand.
     *
     * @param ceilingFan The CeilingFan object this command will operate on.
     */
    public CeilingFanSpeedCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    /**
     * Executes the command, changing the speed of the ceiling fan.
     * It also saves the current speed setting before making the change
     * to facilitate the undo operation.
     */
    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.changeSpeed();
    }

    /**
     * Provides undo functionality, reverting the ceiling fan's speed
     * back to its previous setting.
     */
    @Override
    public void undo() {
        switch (prevSpeed) {
            case CeilingFan.OFF:
                ceilingFan.off();
                break;
            case CeilingFan.LOW:
                ceilingFan.low();
                break;
            case CeilingFan.MEDIUM:
                ceilingFan.medium();
                break;
            case CeilingFan.HIGH:
                ceilingFan.high();
                break;
        }
    }
}
