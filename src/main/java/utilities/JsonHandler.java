package utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonHandler implements JsonHandlerInterface {
    static String FRUIT = "fruit";
    static String VEGETABLE = "vegetable";
    static String NAME = "name";
    static String PRICE = "price";
    static String WEIGHT = "weight";

    static String FileName = "DataSource.txt";
    static String FilePath = "d:/";
    // Where we stores our parsed json.
    static ArrayList<CartObject> CartArray = new ArrayList<>();

    // This function reads the json file from resources and then parsers it to an Cart Object.
    @Override
    public ArrayList<CartObject> ReadJSon() {
        String tmp = null;
        tmp = ReadFromFile ();
        if(tmp!=null) {
            try {
                JSONObject jsonObj = new JSONObject(tmp);
                JSONArray fruits = jsonObj.getJSONArray(FRUIT);
                JSONArray vegetables = jsonObj.getJSONArray(VEGETABLE);
                CartObject cartObject;

                for (int i = 0; i < fruits.length(); i++) {
                    cartObject = new CartObject(
                            fruits.getJSONObject(i).get(NAME).toString(),
                            FRUIT,
                            fruits.getJSONObject(i).getDouble(PRICE),
                            fruits.getJSONObject(i).getDouble(WEIGHT)
                    );
                    CartArray.add(cartObject);

                }

                for (int i = 0; i < vegetables.length(); i++) {
                    cartObject = new CartObject(
                            vegetables.getJSONObject(i).get(NAME).toString(),
                            VEGETABLE,
                            vegetables.getJSONObject(i).getDouble(PRICE),
                            vegetables.getJSONObject(i).getDouble(WEIGHT)
                    );
                    CartArray.add(cartObject);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return CartArray;
    }

    @Override
    public String ReadFromFile(){
        String s = null;
        try{
            File fe=new File(FilePath+FileName);
            FileInputStream fis=new FileInputStream(fe);
            byte data[]=new byte[fis.available()];
            fis.read(data);
            fis.close();
            s = new String(data);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    @Override
    public boolean WriteToFile(String input) {
        try (FileOutputStream fos = new FileOutputStream(FilePath + FileName)) {
            byte[] mybytes = input.getBytes();
            fos.write(mybytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean WriteToFile(ArrayList<CartObject> array) {
        String s = ObjectToStinrg(array);
        try (FileOutputStream fos = new FileOutputStream(FilePath + FileName)) {
            byte[] mybytes = s.getBytes();
            fos.write(mybytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public String ObjectToStinrg(ArrayList<CartObject> array){
        String s = "{";
        s+="  \n" +
                "  \"fruit\" : [";
        for(int i=0;i<array.size();i++){
            if(array.get(i).Type=="fruit"){
                s+="    {\n" +
                        "      \"name\" : "+"\""+array.get(i).Name+"\""+",\n" +
                        "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
                        "      \"weight\":"+array.get(i).Weight+",\n" +
                        "      \"price\" :"+array.get(i).Price+"\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s += "],";
        s+="  \"vegetable\" : [";
        for(int i=0;i<array.size();i++){
            if(array.get(i).Type.equals("vegetable")){
                s+="    {\n" +
                        "      \"name\" : "+"\""+array.get(i).Name+"\""+",\n" +
                        "      \"image\" : \"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/265px-Red_Apple.jpg\",\n" +
                        "      \"weight\":"+array.get(i).Weight+",\n" +
                        "      \"price\" :"+array.get(i).Price+"\n" +
                        "    }," ;
            }
        }
        s = s.substring(0, s.length() - 1);
        s+="  \n  ]\n" +
                "}";
        return s;
    }



    /* // Graveyard , where functions goes to die.


    // Helps to read json file from resources.
    private static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        URL resource = JsonHandler.class.getClassLoader().getResource(filename);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
        }


    public void WriteJsonToLocal(ArrayList<CartObject> cartArray,String filename) throws URISyntaxException, IOException {
        String thing = "Text to write to the file";
        String dir = JsonHandler.class.getClassLoader().getResource("food.json").toString();
        OutputStream os = new FileOutputStream(dir);
        final PrintStream printStream = new PrintStream(os);
        printStream.println(thing);
        printStream.close();
        System.out.println("wrote.");
        }

     */

    }
