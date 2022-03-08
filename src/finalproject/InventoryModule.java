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
public class InventoryModule extends Employee implements Serializable{
    
    public boolean addProduct(int stock_id,String type,double price,String category,int quantity)
    {
        Product p = new Product(stock_id,type,price,category,quantity);
        return p.add_product();
    }
    
    public ArrayList<Product> listProduct()
    {
        Product a = new Product();
        return a.list_product();
    }
    
    public boolean DeleteProduct(int id)
    {
        Product a = new Product();
        return a.delete_product(id);
    }
    
     public boolean UpdateProduct(Product v)
    {
        Product a = new Product();
        return a.update_product(a);
    }
     
     public int SearchProduct(int id)
    {
        Product a = new Product();
        return a.search_product(id);
    }
     
}
    
   
     
     
     

