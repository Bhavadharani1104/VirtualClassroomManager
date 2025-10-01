
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private String weather;

    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setWeather(String newWeather) {
        this.weather = newWeather;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update("Weather Update: " + weather);
        }
    }
}
