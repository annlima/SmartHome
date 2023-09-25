/**
 * Represents a command to set the input channel of a TV.
 * Implements the Command interface, providing both execution and undo functionality.
 */
public class TVSetInputChannelCommand implements Command {

    private TV tv;              // The TV instance the command will operate on
    private int previousChannel; // The channel previously set before executing the command
    private int newChannel;      // The channel to set when the command is executed

    /**
     * Constructs a TVSetInputChannelCommand with an specific channel
     * @param tv         The TV instance that this command will operate on.
     * @param newChannel The channel to set when the command is executed.
     */
    public TVSetInputChannelCommand(TV tv, int newChannel) {
        this.tv = tv;
        this.newChannel = newChannel;
    }

    /**
     * Executes the command to set the TV to the specified channel.
     * Also keeps a record of the previous channel to be used in the undo operation.
     */
    @Override
    public void execute() {
        previousChannel = tv.channel;  // Store the previous channel for the undo operation.
        tv.setInputChannel(newChannel);
    }

    /**
     * Undoes the set channel command, reverting the TV to its previous channel.
     */
    @Override
    public void undo() {
        tv.setInputChannel(previousChannel);  // Restore the previous channel.
        System.out.println("Channel is set back to " + previousChannel);
    }
}
