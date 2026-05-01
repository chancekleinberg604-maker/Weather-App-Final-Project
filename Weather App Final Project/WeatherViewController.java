package FinalProject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WeatherViewController {

    @FXML private TextField zipField;
    @FXML private Label tempLabel;
    @FXML private Label windLabel;
    @FXML private Label windDirLabel;
    @FXML private Label humidityLabel;
    @FXML private Label pressureLabel;
    @FXML private Label conditionLabel;
    @FXML private Label iconLabel;
    @FXML private Label errorLabel;
    @FXML private Label locationLabel;

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
            iconLabel.setText(data.getSuggestedIcon());
            locationLabel.setText(data.getCity() + ", " + data.getState());

            errorLabel.setText("");
            errorLabel.setOpacity(0.0);

        } catch (Exception e) {
            errorLabel.setText("Error fetching weather. Check ZIP or network.");
            errorLabel.setOpacity(1.0);
        }
    }
}
