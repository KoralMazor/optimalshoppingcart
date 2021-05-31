package utilities;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface JsonHandlerInterface {
    ArrayList<CartObject> ReadJSon();
    String ReadFromFile();
    boolean WriteToFile(String input);
    boolean WriteToFile(ArrayList<CartObject> array);
    String ObjectToStinrg(ArrayList<CartObject> array);
}
