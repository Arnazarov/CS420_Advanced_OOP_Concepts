import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";
    HttpsURLConnection connection;

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception
    {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL(baseUrl+"i="+ingredients);
            connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            reader.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        JsonObject doc = (JsonObject) Jsoner.deserialize(responseContent.toString(), new JsonObject());

        return doc;
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {
        //Getting the things ready to connect to the web
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL(baseUrl+"q="+dish);
            connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            //int status = connection.getResponseCode();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }

            reader.close();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        JsonObject doc = (JsonObject) Jsoner.deserialize(responseContent.toString(), new JsonObject());

        return doc;
    }


    public String formatRecipeAsString(JsonObject doc){
        String results = "";
        JsonArray recipes = (JsonArray) doc.get("results");
        for (int i = 0; i < recipes.size(); i++) {
            JsonObject recipe = (JsonObject) recipes.get(i);
            results += (String) recipe.get("title") + "\n";
            results += (String) recipe.get("href") + "\n";
            results += (String) recipe.get("ingredients") + "\n";
        }
        return results;
    }

    public void saveRecipes(String text, String outfile){
        try (FileOutputStream fos = new FileOutputStream(outfile);
             DataOutputStream dos = new DataOutputStream(fos);) {

            dos.writeChars(text);

        }  catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
