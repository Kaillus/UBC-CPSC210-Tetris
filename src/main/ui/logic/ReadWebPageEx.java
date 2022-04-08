package ui.logic;

//shamelessly quoting from: http://zetcode.com/articles/javareadwebpage/

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.*;

public class ReadWebPageEx {

    private static String getStuff() {
        String weatherQuery = "http://api.openweathermap.org/data/2.5/weather?id=5911606&APPID=";
        String apiKey = "f509e27e7964150e48e270515be09715";
        return weatherQuery + apiKey;
    }

    private static String readString(Reader rd) throws IOException {

        int line;
        StringBuilder sb = new StringBuilder();

        while ((line = rd.read()) != -1) {

            sb.append((char) line);
        }

        return sb.toString();


    }

    private static JSONObject parseInput(String url) throws IOException, JSONException {

        JSONObject json;

        try (InputStream io = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(io, Charset.forName("UTF-8")));
            String jsonText = readString(rd);
            json = new JSONObject(jsonText);
        }

        return json;
    }

    private static String processString(String string) {
        String weather = string;
        if (weather.equals("Clouds")) {
            weather = "Cloudy";
        } else if (weather.equals("Thunderstorm")) {
            weather = "Thunderstorming";
        } else if (weather.equals("Drizzle")) {
            weather = "Drizzling";
        } else if (weather.equals("Clear")) {
            //
        } else if (weather.substring(string.length() - 1).equals("e")) {
            weather = weather.replaceAll("e$", "y");
        } else if (weather.substring(string.length() - 1).equals("g")) {
            weather = weather.replaceAll("g$", "gy");
        } else {
            weather = weather + "y";
        }

        return weather.toLowerCase();
    }

    public static String fetchString() {
        try {
            JSONObject obj = parseInput(getStuff());

            JSONArray arr = obj.getJSONArray("weather");
            String weather = processString(arr.getJSONObject(0).getString("main"));

            String string = "Play Tetris while it's ";
            String string2 = " outside!";
            return string + weather + string2;
        } catch (IOException e) {
            return "Tetris: IOException";
        } catch (JSONException j) {
            return "Tetris: JSONException";
        }

    }
}