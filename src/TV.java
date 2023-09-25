import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Television (TV) device which can be turned on or off,
 * and have its input channel set. The TV also implements the Subject interface,
 * allowing observers to be notified of state changes.
 */
public class TV implements Subject {

    String location;                // Specifies the location of the TV
    int channel;                    // Stores the current channel number

    boolean isOn = false;           // Flag to track the current power state of the TV

    // A list of observers watching for changes in the TV's state
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructor initializes the TV with a specific location.
     *
     * @param location The location of the TV.
     */
    public TV(String location) {
        this.location = location;
    }

    /**
     * Checks if the TV is currently on.
     * @return true if the TV is on, false otherwise.
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Turns on the TV. If it's already on, no changes will be made.
     * Notifies observers about the state change.
     */
    public void on() {
        if (!isOn) {
            System.out.println("TV is on");
            isOn = true;
            notifyObservers();
        }
    }

    /**
     * Turns off the TV. If it's already off, no changes will be made.
     * Notifies observers about the state change.
     */
    public void off() {
        if (isOn) {
            System.out.println("TV is off");
            isOn = false;
            notifyObservers();
        }
    }

    /**
     * Sets the TV's input channel to a specified channel number.
     *
     * @param channelNumber The desired channel number to switch to.
     */
    public void setInputChannel(int channelNumber) {
        this.channel = channelNumber;
        System.out.println("Channel is set to " + channelNumber);
    }

    /**
     * Registers an observer to be notified of state changes in the TV.
     *
     * @param observer The observer to be added to the list of observers.
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers, so it will no longer
     * be notified of state changes in the TV.
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers of a state change in the TV.
     * Currently, observers are only notified of on/off changes.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, isOn);
        }
    }
}

