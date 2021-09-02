import java.io.*;
import java.util.*;
public class CartDetails {
    String item_name;
    String desc;
    String photo;
    int food_id;
    int price;
    int offer_price;
    int amount;
    int qty;
    CartDetails(){
        
    }
    CartDetails( String item_name,String desc,String photo,int food_id,
            int price,int offer_price,int amount,int qty){
        this.item_name=item_name;
        this.desc=desc;
        this.photo=photo;
        this.food_id=food_id;
        this.price=price;
        this.offer_price=offer_price;
        this.amount=amount;
        this.qty=qty;
    }
    public int getQty(){
        return this.qty;
    }
     public void setQty( int qty){
            this.qty=qty;
    }
    public String getItemName(){
        return this.item_name;
    }
     public void setItemName( String item_name){
            this.item_name=item_name;
    }
    
    public String getDesc(){
        return this.desc;
    }
     public void setDesc( String desc){
            this.desc=desc;
    }
    public String getPhoto(){
        return this.photo;
    }
     public void setPhoto( String photo){
            this.photo=photo;
    }
    public void setFoodId( int food_id){
            this.food_id=food_id;
    }
    public int getFoodId(){
        return this.food_id;
    }
    public void setPrice( int price){
            this.price=price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setOfferPrice( int offer_price){
            this.offer_price=offer_price;
    }
    public int getOfferPrice(){
        return this.offer_price;
    }
    public void setAmount( int amount){
            this.amount=amount;
    }
    public int getAmount(){
        return this.amount;
    }
                    
}
