package utilities;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface JsonHandlerInterface {
    ArrayList<CartObject> ReadJSon();
    void WriteJsonToLocal(ArrayList<CartObject>y, String filename) throws URISyntaxException, IOException;
}
