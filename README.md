    🌦️ Weather Lookup App
The Weather Lookup App is a JavaFX application that retrieves and displays real‑time weather information based on a user‑provided ZIP code. It combines a modern, visually appealing interface with live 
data from two public APIs. When a ZIP code is entered, the app automatically determines the corresponding city and state, fetches the current weather conditions for that location, and presents everything 
in a clean, organized layout. This project demonstrates practical Java concepts including API integration, JSON parsing, JavaFX UI design, and event‑driven programming.

✨ Features
- 🌡️ Current Temperature displayed in Fahrenheit

- 💨 Wind Speed and Direction, including compass labels (N, NE, E, etc.)

- 🌤️ Weather Condition descriptions (Clear Sky, Rain, Snow, Fog, etc.)

- 🕒 Day/Night Indicator based on the location’s local time

- 📍 City and State Lookup from the ZIP code using Zippopotam.us

- 💧 Humidity and Atmospheric Pressure readings

- 🎭 Weather Icon Emoji that matches the current conditions

- 🎨 Modern JavaFX UI with a styled weather card and background

- ⚠️ Error Handling for invalid ZIP codes or network issues

📦 Prerequisites
Before running the application, make sure you have:

1. Java 21 or later installed

2. JavaFX SDK downloaded and added to your project

3. Internet access, since the app fetches live data from APIs

4. A Java IDE such as IntelliJ IDEA or Eclipse (recommended)

▶️ How to Run the Application
1. Clone or download the project folder.

2. Open it in your IDE of choice.

3. Make sure JavaFX is added to your run configuration using VM options similar to:
Code
--module-path "path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml

4. Run the MainApplication class.

5. Enter any valid U.S. ZIP code and click Submit to view the weather.

🧠 Technologies Used
- JavaFX for the graphical user interface

- FXML for UI layout structure

- HTTP Networking via HttpURLConnection

- JSON Parsing using the org.json library

- Open‑Meteo API for weather data

- Zippopotam.us API for ZIP → location conversion
