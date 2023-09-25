import java.util.ArrayList;

/**
 * The CeilingFan class represents a ceiling fan with varying speed levels and an ability to notify
 * its observers about its state changes. It implements the Subject interface, indicating it follows
 * the observer pattern.
 */
public class CeilingFan implements Subject {

    // Constants representing the speed levels of the ceiling fan.
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    // Current speed level of the fan.
    private int level;

    // Location where the ceiling fan is placed.
    private String location;

    // List to hold all observers that are observing this ceiling fan.
    private ArrayList<Observer> observers;

    /**
     * Constructor for the CeilingFan.
     * @param location The location where the fan is.
     */
    public CeilingFan(String location) {
        this.location = location;
        this.level = OFF; // Fan is initialized to OFF.
        observers = new ArrayList<>();
    }

    /**
     * Sets the ceiling fan to high speed.
     */
    public void high() {
        level = HIGH;
        System.out.println(location + " ceiling fan is on high");
        notifyObservers();
    }

    /**
     * Sets the ceiling fan to medium speed.
     */
    public void medium() {
        level = MEDIUM;
        System.out.println(location + " ceiling fan is on medium");
        notifyObservers();
    }

    /**
     * Sets the ceiling fan to low speed.
     */
    public void low() {
        level = LOW;
        System.out.println(location + " ceiling fan is on low");
        notifyObservers();
    }

    /**
     * Turns the ceiling fan off.
     */
    public void off() {
        level = OFF;
        System.out.println(location + " ceiling fan is off");
        notifyObservers();
    }

    /**
     * Returns the current speed level of the ceiling fan.
     * @return Current speed level.
     */
    public int getSpeed() {
        return level;
    }

    /**
     * Turns on the fan. If it is off, it will set the speed to low by default.
     * You can modify the default setting here if needed.
     */
    public void on() {
        if (level == OFF) {
            low();
        }
    }

    /**
     * Changes the speed of the fan to the next level.
     * If it's off, it goes to high; if on low, it goes to medium; and so on.
     */
    public void changeSpeed() {
        switch(level) {
            case OFF:
                high();
                break;
            case LOW:
                medium();
                break;
            case MEDIUM:
                high();
                break;
            case HIGH:
                off();
                break;
        }
    }

    // Methods related to the Observer Pattern:

    /**
     * Registers an observer to this subject.
     * @param o The observer to be registered.
     */
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes an observer from the list of observers.
     * @param o The observer to be removed.
     */
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * Notifies all the registered observers about a state change.
     */
    public void notifyObservers() {
        boolean isOn = level != OFF;
        for (Observer observer : observers) {
            observer.update(this, isOn);
        }
    }
}

