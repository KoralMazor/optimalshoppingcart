package utilities;

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


}