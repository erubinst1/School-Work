import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherForecast {
    public static void main(String[] args){
        try {

            //default inputs
            double latitude = 39.168804;
            double longitude = -86.536659;
            String tempUnit = "fahrenheit";
            String precipUnit = "inches";
            String windUnit = "mph";

            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]);
            }
            System.out.println();

            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "--latitude":
                        if (i + 1 < args.length) latitude = Double.parseDouble(args[++i]);
                        else throw new IllegalArgumentException("Missing value for --latitude");
                        break;
                    case "--longitude":
                        if (i + 1 < args.length) longitude = Double.parseDouble(args[++i]);
                        else throw new IllegalArgumentException("Missing value for --longitude");
                        break;
                    case "--tempUnit":
                        if (i + 1 < args.length) {
                            tempUnit = args[++i].equalsIgnoreCase("C") ? "celsius" : "fahrenheit";
                        } else throw new IllegalArgumentException("Missing value for --tempUnit");
                        break;
                    case "--precipUnit":
                        if (i + 1 < args.length) {
                            precipUnit = args[++i].equalsIgnoreCase("in") ? "inches" : "millimeters";
                        } else throw new IllegalArgumentException("Missing value for --precipUnit");
                        break;
                    case "--windUnit":
                        if (i + 1 < args.length) {
                            String unit = args[++i].toLowerCase();
                            switch (unit) {
                                case "mph":
                                    windUnit = "mph";
                                    break;
                                case "km/h":
                                    windUnit = "km/h";
                                    break;
                                case "m/s":
                                    windUnit = "m/s";
                                    break;
                                case "knots":
                                    windUnit = "knots";
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid value for --windUnit");
                            }
                        } else throw new IllegalArgumentException("Missing value for --windUnit");
                        break;
                    default:
                        System.err.println("Warning: Unknown argument: " + args[i]);
                }
            }

            String baseUrl = "https://api.open-meteo.com/v1/forecast?";

            //default api url
            //https://api.open-meteo.com/v1/forecast?latitude=39.168804&longitude=-86.536659
            // &hourly=temperature_2m,relative_humidity_2m,apparent_temperature,precipitation_probability,precipitation,cloud_cover
            // &daily=temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum
            // &temperature_unit=fahrenheit
            // &wind_speed_unit=mph
            // &precipitation_unit=inch
            // &timezone=EST

            String hourly = "temperature_2m,relative_humidity_2m,apparent_temperature,precipitation_probability,precipitation,cloud_cover";
            String daily = "temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum";

            String timezone = "auto";

            StringBuilder urlBuilder = new StringBuilder(baseUrl);
            urlBuilder.append("latitude=").append(latitude)
                    .append("&longitude=").append(longitude)
                    .append("&hourly=").append(hourly)
                    .append("&daily=").append(daily)
                    .append("&temperature_unit=").append(tempUnit)
                    .append("&wind_speed_unit").append(windUnit)
                    .append("&precipitation_unit").append(precipUnit)
                    .append("&timezone=").append(timezone);


            HttpURLConnection connection = (HttpURLConnection) new URL(urlBuilder.toString()).openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JsonElement jsonElement = JsonParser.parseString(response.toString());

                JsonObject jsonObject = jsonElement.getAsJsonObject();
                JsonObject hourlyData = jsonObject.getAsJsonObject("hourly");
                JsonObject dailyData = jsonObject.getAsJsonObject("daily");
                JsonArray timeArray = hourlyData.getAsJsonArray("time");

                //daily
                JsonArray tempMin = dailyData.getAsJsonArray("temperature_2m_min");
                JsonArray tempMax = dailyData.getAsJsonArray("temperature_2m_max");
                JsonArray sunrise = dailyData.getAsJsonArray("sunrise");
                JsonArray sunset = dailyData.getAsJsonArray("sunset");
                JsonArray precipitationSum = dailyData.getAsJsonArray("precipitation_sum");

                //hourly
                JsonArray temps = hourlyData.getAsJsonArray("temperature_2m");
                JsonArray relativeHumid = hourlyData.getAsJsonArray("relative_humidity_2m");
                JsonArray apparentTemp = hourlyData.getAsJsonArray("apparent_temperature");
                JsonArray precipitationProb = hourlyData.getAsJsonArray("precipitation_probability");
                JsonArray precip = hourlyData.getAsJsonArray("precipitation");
                JsonArray cloudCover = hourlyData.getAsJsonArray("cloud_cover");

                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:");

                System.out.println("7-Day Forecast for (" + latitude + ", " + longitude + ") in " + tempUnit + ", " + precipUnit + ", " + windUnit +":");

                for(int i = 0; i < 7; i++){
                    String time = timeArray.get(i * 24).getAsString();
                    LocalDateTime dateTime = LocalDateTime.parse(time, inputFormatter);
                    String formattedDate = dateTime.format(outputFormatter);
                    double tempMinimum = tempMin.get(i).getAsDouble();
                    double tempMaximum = tempMax.get(i).getAsDouble();
                    String sunriseTime = sunrise.get(i).getAsString().substring(formattedDate.length());
                    String sunsetTime = sunset.get(i).getAsString().substring(formattedDate.length());
                    double totalPrecipitation = precipitationSum.get(i).getAsDouble();


                    System.out.println("Forecast for " + formattedDate);
                    System.out.println("\t" + "Temperature Minimum: " + tempMinimum + "°F, Temperature Maximum: " + tempMaximum + "°F");
                    System.out.println("\t" + "Sunrise: " + sunriseTime + ", Sunset: " + sunsetTime);
                    System.out.println("\t" + "Total Precipitation: " + totalPrecipitation + " in");

                    System.out.println();

                    for (int j = 0; j <= 21; j += 3) {
                        int hourlyIndex = i * 24 + j;
                        if (hourlyIndex < temps.size()) {
                            double temperature = temps.get(hourlyIndex).getAsDouble();
                            double apparentTemperature = apparentTemp.get(hourlyIndex).getAsDouble();
                            double cloudCoverage = cloudCover.get(hourlyIndex).getAsDouble();
                            double relativeHumidity = relativeHumid.get(hourlyIndex).getAsDouble();
                            double precipitationProbability = precipitationProb.get(hourlyIndex).getAsDouble();
                            double precipitation = precip.get(hourlyIndex).getAsDouble();

                            LocalDateTime hourTime = dateTime.plusHours(j);
                            String formattedHour = hourTime.format(DateTimeFormatter.ofPattern("HH:mm"));
                            System.out.println("\t" + formattedHour + ": " + temperature + "°F" + ", feels like " + apparentTemperature + "°F");
                                System.out.println("\t\t" + "Cloud Coverage: " + cloudCoverage + "%, Humidity: " + relativeHumidity +
                                                   "%, Precipitation Probability: " + precipitationProbability + "%, Precipitation: " + precipitation + " in");

                        }
                    }
                }
            } else {
                throw new RuntimeException("Failed to connect. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Error initializing program: " + e.getMessage());
        }
    }
}
