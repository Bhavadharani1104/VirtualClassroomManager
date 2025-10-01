
public class DisplayDevice implements Observer {
    private String deviceName;

    public DisplayDevice(String name) {
        this.deviceName = name;
    }

    @Override
    public void update(String message) {
        System.out.println(deviceName + " shows: " + message);
    }
}
