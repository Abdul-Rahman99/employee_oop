/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nehas
 */
public class Offers implements Serializable{
    
    FileManagerBinary fManger = new FileManagerBinary();
    String offerFileName = "offers.bin";
    ArrayList<Offers> off_list = new ArrayList<>();
    private int discount;
    private double price;
    private int quantity;
    public Offers()
    {
        
    }
    public Offers(int discount,double price,int quantity)
    {
        this.discount=discount;
        this.price=price;
        this.quantity=quantity;
        
    }
    
    
    
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    public int getDiscount()
    {
        return discount;
    }
    public void setPrice(double price)
    {
        this.price=price;  
    }
    
    public double getPrice()
    {
        return price;
    }
    public void setQuantity (int quantity)
    {
        this.quantity=quantity;
    }
    public int getQuantity()
    {
        return quantity;
    }
        public boolean commitToFile()
    {
        return fManger.write(offerFileName,off_list);
    }
    
    public void loadFromFile()
    {
       off_list =(ArrayList<Offers>) (ArrayList<Offers>) fManger.read(offerFileName);
    }
    public double makeoffer(int x, double z,int y )
    {  
        loadFromFile();
       x=this.getQuantity();
       z=this.getPrice();
       y=this.getDiscount();
        /*this.setQuantity(x);
        this.setDiscount(y);
        this.setPrice(z); */
        if(x>12)
        {
            z=z*(y/100);
            off_list.add(this);
            commitToFile();
            
        }
        return -1;
    }
      public ArrayList<Offers> show_offer() {
        loadFromFile();
        return off_list;
      }
}
    
