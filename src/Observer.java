/**
 * The Observer interface represents the "Observer" component within the Observer pattern.
 * In this pattern, the Observer objects register themselves with a Subject to receive
 * notifications about state changes. When the Subject's state changes, it notifies
 * all registered Observers by calling their update method.
 *
 * The Observer pattern is used to create a one-to-many dependency between objects such that
 * when one object (Subject) changes state, all its dependents (Observers) are notified and updated automatically.
 */
public interface Observer {

    /**
     * This method is called whenever the observed object (Subject) is changed.
     * Each observer implementation should decide how it wants to react to these changes.
     *
     * @param subject The subject (or observable object) that has changed.
     * @param arg Additional data or argument related to the update.
     */
    void update(Object subject, Object arg);
}


