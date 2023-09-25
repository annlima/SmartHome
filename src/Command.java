/**
 * The Command interface represents the command design pattern.
 * This pattern is used to encapsulate a request as an object,
 * allowing for parameterization of clients with different requests,
 * queuing of requests, and logging of the operations. It also provides support
 * for undoable operations.
 */
public interface Command {

    /**
     * Executes the command. This method should encapsulate the action associated
     * with the specific command.
     */
    public void execute();

    /**
     * Reverts the action performed by the execute method, essentially providing
     * an undo functionality for the command.
     */
    public void undo();
}
