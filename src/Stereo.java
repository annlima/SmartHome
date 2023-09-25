import java.util.ArrayList;
import java.util.List;
/**
 * Represents a Stereo system, providing functionality to control its
 * power state, input mode, volume, and radio frequency.
 * The Stereo class also implements the Observable part of the Observer pattern
 * allowing other objects to monitor its state.
 */
public class Stereo {

    private String location;  // Represents where the stereo is located
    private int volume;       // Represents the current volume level of the stereo
    private String mode;      // Represents the mode (CD, DVD, Radio, Off) of the stereo
    private float frequency;  // Represents the current frequency if radio mode is selected
    private boolean isOn;  // A flag to track the current power state of the Stereo

    // A list of observers monitoring the state of the Stereo
    private List<Observer> observers = new ArrayList<>();

    /**
     * Constructor that initializes the location of the stereo.
     * @param location The location of the stereo system.
     */
    public Stereo(String location) {
        this.location = location;
        this.isOn = false;
    }

    /**
     * Adds an observer to the list of observers.
     * @param observer The observer to be added.
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Same functionality as addObserver, can be removed to avoid redundancy.
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     * @param observer The observer to be removed.
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about the state change.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, isOn);
        }
    }

    // Turns the stereo on and notifies observers about the change
    public void on() {
        isOn = true;
        System.out.println(location + " stereo is on");
        notifyObservers();
    }

    // Turns the stereo off and notifies observers about the change
    public void off() {
        isOn = false;
        System.out.println(location + " stereo is off");
        notifyObservers();
    }

    // Sets the stereo's mode to CD
    public void setCD() {
        System.out.println(location + " stereo is set for CD input");
    }

    // Sets the stereo's mode to DVD
    public void setDVD() {
        System.out.println(location + " stereo is set for DVD input");
    }

    /**
     * @return The current radio frequency.
     */
    public float getFrequency() {
        return this.frequency;
    }

    /**
     * Sets the stereo's mode to Radio and tunes to the specified frequency.
     *
     * @param frequency The radio frequency to tune to.
     */
    public void setRadio(float frequency) {
        this.mode = "Radio";
        if (frequency < 1) {
            System.out.println(location + " Frecuencia no permitida");
            return;
        }
        this.frequency = frequency;
        System.out.println(location + " stereo is set for Radio with frequency: " + frequency);
    }

    /**
     * @return The current volume level of the stereo.
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Sets the volume to the specified level.
     * If the specified volume is out of range, it's set to the closest boundary.
     *
     * @param volume The volume level to set.
     */
    public void setVolume(int volume) {
        if (volume < 1) {
            this.volume = 1;
        } else if (volume > 11) {
            this.volume = 11;
        } else {
            this.volume = volume;
        }
        System.out.println(location + " stereo volume is set to " + this.volume);
    }
    public String getLocation() {
        return location;
    }
    /**
     * @return The current mode of the stereo.
     */
    public String getMode() {
        return mode;
    }
}
