import java.util.ArrayList;
public class Hottub {
    boolean on;
    int temperature;
    private ArrayList<Observer> observers;
    public Hottub() {
        observers = new ArrayList<>();
    }
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, on);  // Here we are sending the Hottub object and its state (on or off).
        }
    }
    public void on() {
        on = true;
        System.out.println("Hottub is on");
        notifyObservers();
    }

    public void off() {
        on = false;
        notifyObservers();
    }

    public void bubblesOn() {
        if (on) {
            System.out.println("Hottub is bubbling!");
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void heat() {
        temperature = 105;
        System.out.println("Hottub is heating to a steaming 105 degrees");
    }

    public void cool() {
        temperature = 15;
        System.out.println("Hottub is cooling to 15 degrees");
    }

}
