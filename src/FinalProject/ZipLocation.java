package FinalProject;

public class ZipLocation {

    private final double latitude;
    private final double longitude;
    private final String city;
    private final String state;

    public ZipLocation(double latitude, double longitude, String city, String state) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
