package Tests;

import org.junit.Test;
import utilities.CartObject;
import utilities.JsonHandler;

import java.util.ArrayList;

public class JsonAndDataTest {
    static ArrayList<CartObject> CartArray = new ArrayList<>();
    JsonHandler jsonHandler = new JsonHandler();

    public JsonAndDataTest(){
        startTest();
    }
    @Test
    void startTest(){
        System.out.println("# New object through contractor");
        new CartObject("test","test",1.2,1);
        System.out.println("# Read json from file");
        CartArray = jsonHandler.ReadJSon();
        System.out.println("# Convert json to string.");
        System.out.println(jsonHandler.ObjectToStinrg(CartArray));
    }
}
