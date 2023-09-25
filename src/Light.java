import java.util.ArrayList;
import java.util.List;

/**
 * The Light class represents a simple light source that can be toggled on or off.
 * It follows the Subject role in the Observer design pattern, allowing it to
 * register, remove and notify observers (listeners) of its state changes.
 */
public class Light implements Subject {

    // A unique identifier for the light, for example, "livingRoom" or "main".
    private final String identifier;

    // Getter for the light's identifier.
    public String getIdentifier() {
        return identifier;
    }

    // Represents the current mode of the light.
    // Not utilized in the current implementation but kept for potential future use.
    private String mode;

    /**
     * Retrieves the current mode of the light.
     * @return the mode of the light.
     */
    public String getMode() {
        return mode;
    }

    // A flag to check whether the light is currently turned on or off.
    boolean isOn;

    // A list that holds all the observers which are interested in monitoring state changes of this light.
    private List<Observer> observers;

    /**
     * Constructs a new instance of the Light with a given identifier.
     * Initializes the list of observers.
     *
     * @param identifier The unique identifier for the light.
     */
    public Light(String identifier) {
        this.identifier = identifier;
        this.observers = new ArrayList<>();
    }

    /**
     * Turns the light on. If the light is already on, no action is taken.
     * After toggling, all registered observers are notified about this change.
     */
    public void on() {
        if (!isOn) {
            System.out.println("Light is ON");
            isOn = true;
            notifyObservers();
        }
    }

    /**
     * Turns the light off. If the light is already off, no action is taken.
     * After toggling, all registered observers are notified about this change.
     */
    public void off() {
        if (isOn) {
            System.out.println("Light is OFF");
            isOn = false;
            notifyObservers();
        }
    }

    /**
     * Adds an observer to the list of observers interested in monitoring this light's state changes.
     * @param observer The observer to be added.
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes a specific observer from the list, so it won't be notified of further state changes.
     *
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about a change in the light's state.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, isOn);
        }
    }
}
