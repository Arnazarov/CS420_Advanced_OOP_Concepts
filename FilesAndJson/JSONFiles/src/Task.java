import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Task {
    public static void main(String[] args){
        Task t = new Task();
        JsonObject doc = t.readJson("./resources/restaurant-data.json");
        Database db = new Database(doc);
        System.out.println(db.getRestaurant("Hometown BBQ"));
        System.out.println(db.getAvgReviews("Casa Enrique"));
    }

    public String readFile(String filename) {
        String data = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String s = reader.readLine();
            while (s != null) {
                data += s;
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return data;
    }
    public JsonObject readJson(String filename) {
        JsonObject content = (JsonObject) Jsoner.deserialize(readFile(filename), new JsonObject());
        return content;
    }
}