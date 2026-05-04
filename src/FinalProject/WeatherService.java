package FinalProject.FinalProject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    public WeatherData getWeatherByZip(String zip) throws Exception {

        ZipLocation location = getLatLongFromZip(zip);

        String urlString = String.format(
                "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f"
                        + "&current_weather=true&hourly=relativehumidity_2m,pressure_msl",
                location.getLatitude(), location.getLongitude()
        );

        JSONObject json = getJson(urlString);

        JSONObject current = json.getJSONObject("current_weather");

        double tempC = current.getDouble("temperature");
        double windKph = current.getDouble("windspeed");
        double windDir = current.getDouble("winddirection");
        int isDay = current.getInt("is_day");
        int weatherCode = current.getInt("weathercode");

        JSONObject hourly = json.getJSONObject("hourly");
        JSONArray times = hourly.getJSONArray("time");
        JSONArray humidityArr = hourly.getJSONArray("relativehumidity_2m");
        JSONArray pressureArr = hourly.getJSONArray("pressure_msl");

        String currentTime = current.getString("time");
        int index = findTimeIndex(times, currentTime);

        double humidity = humidityArr.getDouble(index);
        double pressure = pressureArr.getDouble(index);

        return new WeatherData(
                tempC,
                windKph,
                windDir,
                isDay,
                weatherCode,
                humidity,
                pressure,
                location.getCity(),
                location.getState()
        );
    }

    private int findTimeIndex(JSONArray times, String target) {
        for (int i = 0; i < times.length(); i++) {
            if (times.getString(i).equals(target)) {
                return i;
            }
        }
        return 0;
    }

    private ZipLocation getLatLongFromZip(String zip) throws Exception {
        String urlString = "https://api.zippopotam.us/us/" + zip;

        JSONObject json = getJson(urlString);
        JSONObject place = json.getJSONArray("places").getJSONObject(0);

        double lat = Double.parseDouble(place.getString("latitude"));
        double lon = Double.parseDouble(place.getString("longitude"));
        String city = place.getString("place name");
        String state = place.getString("state abbreviation");

        return new ZipLocation(lat, lon, city, state);
    }

    private JSONObject getJson(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return new JSONObject(response.toString());
    }
}
