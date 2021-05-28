package utilities;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonHandler {

    // Where we stores our parsed json.
    static ArrayList<CartObject> CartArray = new ArrayList<>();

    // This function reads the json file from resources and then parsers it to an Cart Object.
    public static  ArrayList<CartObject>   ReadJSon() {
        String tmp = null;
        try {
            tmp = readFileFromResources("food.json");
            JSONObject jsonObj = new JSONObject(tmp);
            JSONArray fruits = jsonObj.getJSONArray("fruits");
            JSONArray vegetables = jsonObj.getJSONArray("vegetables");
            JSONObject tmpObj;
            CartObject cartObject;
            System.out.println("fruits:\n");
            for(int i=0;i<fruits.length();i++){
                cartObject = new CartObject();
                cartObject.Name = fruits.getJSONObject(i).get("name").toString();
                cartObject.Price = fruits.getJSONObject(i).getDouble("price");
                cartObject.Weight = fruits.getJSONObject(i).getDouble("weight");
                cartObject.Type = "fruit";
                CartArray.add(cartObject);
            }
            for(int i=0;i<vegetables.length();i++){
                cartObject = new CartObject();
                cartObject.Name = vegetables.getJSONObject(i).get("name").toString();
                cartObject.Price = vegetables.getJSONObject(i).getDouble("price");
                cartObject.Weight = vegetables.getJSONObject(i).getDouble("weight");
                cartObject.Type = "vegetable";
                CartArray.add(cartObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CartArray;
    }
    public static JSONObject WriteJSON(CartObject CartArray) {
       /// TO DO : A function that converts a CartObject to an JsonObject.
        return null;
    }

    // Helps to read json file from resources.
    private static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        URL resource = JsonHandler.class.getClassLoader().getResource(filename);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
    }
}
