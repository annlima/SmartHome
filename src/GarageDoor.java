import java.util.List;
import java.util.ArrayList;

/**
 * The GarageDoor class represents a garage door with its own light,
 * and has the ability to notify its observers about its state changes.
 * It implements the Subject interface, indicating it follows the observer pattern.
 */
public class GarageDoor implements Subject {

    // Location where the garage door is situated.
    private String location;

    // List of observers that are observing the state of this garage door.
    private List<Observer> observers = new ArrayList<>();

    // Flag indicating whether the garage door is open.
    public boolean isDoorOpen = false;

    // Flag indicating whether the garage door light is on.
    public boolean isLightOn = false;

    /**
     * Constructor for the GarageDoor.
     * @param location The location where the garage door is situated.
     */
    public GarageDoor(String location) {
        this.location = location;
    }

    /**
     * @return true if the door is open, false otherwise.
     */
    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    /**
     * @return true if the light is on, false otherwise.
     */
    public boolean isLightOn() {
        return isLightOn;
    }

    /**
     * Opens the garage door if it's not already open.
     */
    public void up() {
        if (!isDoorOpen) {
            System.out.println(location + " garage Door is Up");
            isDoorOpen = true;
            notifyObserversDoorState();
        }
    }

    /**
     * Closes the garage door if it's not already closed.
     */
    public void down() {
        if (isDoorOpen) {
            System.out.println(location + " garage Door is Down");
            isDoorOpen = false;
            notifyObserversDoorState();
        }
    }

    /**
     * Turns on the garage door light if it's not already on.
     */
    public void lightOn() {
        if (!isLightOn) {
            System.out.println(location + " garage light is on");
            isLightOn = true;
            notifyObserversLightState();
        }
    }

    /**
     * Turns off the garage door light if it's not already off.
     */
    public void lightOff() {
        if (isLightOn) {
            System.out.println(location + " garage light is off");
            isLightOn = false;
            notifyObserversLightState();
        }
    }

    /**
     * Notifies all observers about the change in the light's state.
     */
    private void notifyObserversLightState() {
        for (Observer observer : observers) {
            observer.update(this, new Object[]{ "light", isLightOn });
        }
    }

    /**
     * Notifies all observers about the change in the door's state.
     */
    private void notifyObserversDoorState() {
        for (Observer observer : observers) {
            observer.update(this, new Object[]{ "door", isDoorOpen });
        }
    }

    // Methods related to the Observer Pattern:

    /**
     * This overridden method is intentionally left empty.
     * Use notifyObserversLightState() or notifyObserversDoorState()
     * for specific state notifications.
     */
    @Override
    public void notifyObservers() {
        // Intentionally empty
    }

    /**
     * Registers an observer to this subject.
     *
     * @param observer The observer to be registered.
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
