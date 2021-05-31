package utilities;

import java.util.ArrayList;

public interface CartObjectInterface {
    void setName(String name);
    void setType(String type);
    void setPrice(double price);
    void setWeight(double weight);
    String getName();
    String getType();
    double getPrice();
    double getWeight();
    public String toJsonString(ArrayList<CartObject> array);
}
