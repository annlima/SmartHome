import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

/**
 * SmartHomeCentral is a central command hub for a smart home.
 * It provides features like adding commands to a queue, executing commands,
 * undoing commands, and even a vacation mode where commands are executed on a timer.
 * This class implements the Singleton pattern, ensuring only one instance of the hub exists.
 */
public class SmartHomeCentral {

    // Singleton instance
    private static SmartHomeCentral instance;

    // Queue to handle delayed commands
    private Queue<Command> commandQueue;
    // Stack to keep track of executed commands for undo functionality
    private Stack<Command> executedCommands;
    // Queue for commands to be executed in vacation mode
    private Queue<Command> vacationCommands;

    // Timer for vacation mode commands
    private Timer vacationTimer;
    private Random rand = new Random();
    // Private constructor for the Singleton pattern
    private SmartHomeCentral() {
        commandQueue = new LinkedList<>();
        executedCommands = new Stack<>();
    }

    /**
     * Method to retrieve the Singleton instance.
     * @return the instance of SmartHomeCentral.
     */
    public static SmartHomeCentral getInstance() {
        if (instance == null) {
            instance = new SmartHomeCentral();
        }
        return instance;
    }

    /**
     * Adds a command to the command queue.
     * There's a simulated delay of 10 seconds before the command is executed.
     * @param command The command to be added.
     */
    public void addCommand(Command command) {
        commandQueue.add(command);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executeCommand();
    }

    /**
     * Executes the command from the queue.
     */
    public void executeCommand() {
        if (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
            executedCommands.push(command);
        }
    }

    /**
     * Undoes the last executed command.
     */
    public void undoLastCommand() {
        if (!executedCommands.isEmpty()) {
            Command command = executedCommands.pop();
            command.undo();
        }
    }

    /**
     * Starts the vacation mode. Commands will be executed periodically.
     */
    public void startVacationMode() {
        System.out.println("Iniciando modo vacaciones");
        // Restablish all the states to the original one
        for (Command command : executedCommands) {
            command.undo();
        }
        // Starts to execute all the commands that were executed
        vacationCommands = new LinkedList<>(executedCommands);

        scheduleVacationTask();
    }
    /**
     * Schedules the vacation tasks which includes executing commands on a timer.
     */
    private void scheduleVacationTask() {
        if (vacationTimer != null) {
            vacationTimer.cancel();
        }
        vacationTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea del TimerTask en ejecución");

                if (!vacationCommands.isEmpty()) {
                    Command nextCommand = vacationCommands.poll();
                    nextCommand.execute();
                    System.out.println("Se ejecutó la tarea " + nextCommand.toString());

                    // If the poll still have commands, the program prepare the next one
                    scheduleVacationTask();
                } else {
                    System.out.println("No hay más comandos para repetir en el modo vacaciones.");
                    stopVacationMode();  // If all the commands were used the vacation mode stops
                }
            }
        };
        int delay = 5000;  // 5 seconds
        vacationTimer.schedule(task, delay);
    }
    /**
     * Stops the vacation mode.
     */
    public void stopVacationMode() {
        if (vacationTimer != null) {
            vacationTimer.cancel();
            System.out.println("Modo vacaciones detenido.");
        }
    }

}



