import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import java.math.BigDecimal;

public class Database {
    JsonObject document;

    public Database(JsonObject data){
        this.document = data;
    }

    public JsonObject getRestaurant(String name){
        JsonArray restaurants = (JsonArray) this.document.get("restaurants");
        for (int i = 0; i < restaurants.size(); i++){
            JsonObject result = (JsonObject) restaurants.get(i);
            String nameRestaurant = (String) result.get("name");
            if (nameRestaurant.equals(name))
                return result;
        }

        return null;
    }

    public double getAvgReviews(String name){
        JsonArray restaurants = (JsonArray) this.document.get("restaurants");
        double avg = 0;
        for (int i = 0; i < restaurants.size(); i++){
            JsonObject result = (JsonObject) restaurants.get(i);
            String nameRestaurant = (String) result.get("name");
            if (nameRestaurant.equals(name)) {
                JsonArray reviews = (JsonArray) result.get("reviews");
                for (int j = 0; j < reviews.size(); j++) {
                    JsonObject review = (JsonObject) reviews.get(j);
                    avg += ((BigDecimal)review.get("rating")).doubleValue();
                }
                avg = avg / reviews.size();
            }
        }
        return avg;
    }
}
