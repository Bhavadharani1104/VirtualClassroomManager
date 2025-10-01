
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        station.addObserver(new DisplayDevice("Mobile App"));
        station.addObserver(new DisplayDevice("Smart Watch"));
        station.addObserver(new DisplayDevice("TV Display"));

        station.setWeather("Sunny");
        station.setWeather("Rainy");
    }
}
