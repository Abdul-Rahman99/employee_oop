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
public class Seller extends Employee implements Serializable {
    
    public ArrayList<Bill> ShowBill()
    {
        Bill z = new Bill();
        return z.showBill();
    }
    
    public boolean DeleteBill(int id)
    {
        Bill z = new Bill();
        return z.deleteBill(id);
    }
    
     public Bill  SearchInBill(int id)
    {
        Bill z = new Bill();
        return z.searchinBill(id);
    }
    
     public void RemoveItem(int id)
    {
        Bill z = new Bill();
        z.removeItem(id);
    }
     
     public boolean login(String username , String password)
     {
         return username.equals("Milad") && password.equals("54321");
     }
}
