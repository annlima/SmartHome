/**
 * The Subject interface represents the "Subject" component within the Observer pattern.
 * This pattern is used to create a one-to-many dependency between objects such that
 * when one object changes state, all its dependents (observers) are notified and updated automatically.
 * The Subject maintains a list of observers and provides mechanisms to add, remove,
 * and notify these observers of state changes.
 */
public interface Subject {

    /**
     * Registers an observer to be notified of state changes.
     * @param observer The observer to be added to the list of observers.
     */
    void registerObserver(Observer observer);

    /**
     * Removes an observer from the list, so that it no longer receives state change notifications.
     * @param observer The observer to be removed from the list of observers.
     */
    void removeObserver(Observer observer);

    /**
     * Notifies all registered observers of a state change.
     */
    void notifyObservers();
}

