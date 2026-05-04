package FinalProject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherViewController {

    @FXML private TextField zipField;
    @FXML private Label tempLabel;
    @FXML private Label windLabel;
    @FXML private Label windDirLabel;
    @FXML private Label humidityLabel;
    @FXML private Label pressureLabel;
    @FXML private Label conditionLabel;
    @FXML private Label errorLabel;
    @FXML private Label locationLabel;
    @FXML private ImageView imgDayOrNight;

    private final WeatherService weatherService = new WeatherService();

    @FXML
    private void onFetchWeather() {
        String zip = zipField.getText().trim();

        if (!zip.matches("[0-9]{5}(-[0-9]{4})?")) {
            errorLabel.setText("Invalid ZIP code. Must be 5 digits.");
            errorLabel.setOpacity(1.0);
            return;
        }

        try {
            WeatherData data = weatherService.getWeatherByZip(zip);

            tempLabel.setText(String.format("%.1f °F", data.getTemperatureFahrenheit()));
            windLabel.setText(String.format("%.1f mph", data.getWindSpeedMph()));
            windDirLabel.setText(data.getWindDirectionCompass());
            humidityLabel.setText(String.format("%.0f%%", data.getHumidity()));
            pressureLabel.setText(String.format("%.1f hPa", data.getPressure()));
            conditionLabel.setText(data.getConditionName());
            locationLabel.setText(data.getCity() + ", " + data.getState());

            setWeatherIcon(data);  // <-- set PNG icon

            errorLabel.setText("");
            errorLabel.setOpacity(0.0);

        } catch (Exception e) {
            errorLabel.setText("Error fetching weather. Check ZIP or network.");
            errorLabel.setOpacity(1.0);
        }
    }

    private void setWeatherIcon(WeatherData data) {
        String condition = data.getConditionName().toLowerCase();
        boolean day = data.getIsDay() == 1;

        String iconFile = "unknown.png";

        if (condition.contains("clear")) {
            iconFile = day ? "sunny.png" : "night.png";
        } else if (condition.contains("partly") || condition.contains("cloud")) {
            iconFile = "cloudy.png";
        } else if (condition.contains("fog")) {
            iconFile = "fog.png";
        } else if (condition.contains("drizzle")) {
            iconFile = "drizzle.png";
        } else if (condition.contains("rain")) {
            iconFile = "rain.png";
        } else if (condition.contains("snow")) {
            iconFile = "snow.png";
        } else if (condition.contains("thunder")) {
            iconFile = "storm.png";
        }

        Image img = new Image(
                getClass().getResource("/FinalProject/Images/" + iconFile).toString()
        );
        imgDayOrNight.setImage(img);
    }
}
