package utilities;

import java.util.ArrayList;

public class CartObject implements CartObjectInterface{
        String Name;
        String Type;
        double Price;
        double Weight;

       public CartObject(String name ,String type , double price,double weight){
               this.Name = name;
               this.Type = type;
               this.Price = price;
               this.Weight = weight;
     }
     public void setName(String name){ this.Name = name; }
     public void setType(String type){ this.Type = type; }
     public void setPrice(double price){ this.Price = price; }
     public void setWeight(double weight){ this.Weight = weight; }

     public String getName(){ return this.Name; }
     public String getType(){ return this.Type; }
     public double getPrice(){ return this.Price; }
     public double getWeight(){ return this.Weight; }

     public String toJsonString(ArrayList<CartObject> array){
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

}