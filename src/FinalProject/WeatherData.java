package FinalProject.FinalProject;

public class WeatherData {

    private final double temperatureCelsius;
    private final double windSpeedKph;
    private final double windDirectionDegrees;
    private final double humidity;
    private final double pressure;
    private final int weatherCode;
    private final int isDay;

    private final String city;
    private final String state;

    public WeatherData(double temperatureCelsius, double windSpeedKph, double windDirectionDegrees, int isDay, int weatherCode, double humidity, double pressure, String city, String state) {
        this.temperatureCelsius = temperatureCelsius;
        this.windSpeedKph = windSpeedKph;
        this.windDirectionDegrees = windDirectionDegrees;
        this.isDay = isDay;
        this.weatherCode = weatherCode;
        this.humidity = humidity;
        this.pressure = pressure;
        this.city = city;
        this.state = state;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public double getTemperatureFahrenheit() {
        return temperatureCelsius * 9.0 / 5.0 + 32.0;
    }

    public double getWindSpeedKph() {
        return windSpeedKph;
    }

    public double getWindSpeedMph() {
        return windSpeedKph * 0.621371;
    }

    public double getWindDirectionDegrees() {
        return windDirectionDegrees;
    }

    public String getWindDirectionCompass() {
        String[] dirs = {"N","NE","E","SE","S","SW","W","NW"};
        int index = (int) Math.round(((windDirectionDegrees % 360) / 45.0)) % 8;
        return dirs[index];
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public int getIsDay() {
        return isDay;
    }

    public String getConditionName() {
        int code = weatherCode;
        if (code == 0) return "Clear sky";
        if (code == 1 || code == 2 || code == 3) return "Partly cloudy";
        if (code == 45 || code == 48) return "Fog";
        if (code == 51 || code == 53 || code == 55) return "Drizzle";
        if (code == 61 || code == 63 || code == 65) return "Rain";
        if (code == 71 || code == 73 || code == 75) return "Snow";
        if (code == 95 || code == 96 || code == 99) return "Thunderstorm";
        return "Unknown";
    }

    public String getSuggestedIcon() {
        int code = weatherCode;
        boolean day = isDay == 1;

        if (code == 0) return day ? "☀️" : "🌙";
        if (code == 1 || code == 2 || code == 3) return day ? "⛅" : "☁️";
        if (code == 45 || code == 48) return "🌫️";
        if (code == 51 || code == 53 || code == 55) return "🌦️";
        if (code == 61 || code == 63 || code == 65) return "🌧️";
        if (code == 71 || code == 73 || code == 75) return "❄️";
        if (code == 95 || code == 96 || code == 99) return "⛈️";
        return "❔";
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
