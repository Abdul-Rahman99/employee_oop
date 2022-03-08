/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.Employee.emp_list;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nehas
 */
public class MarktingModule extends Employee implements Serializable{
    
    
    
  public void creatNewReport(int id , String description , String suggestion)
     {
         Report n = new Report(id , description , suggestion);
         n.make_report();
     }
  
  public boolean DeleteReport(int id)
    {
        Report n = new Report();
        return n.delete_report(id);
    }
    
     public boolean UpdateReport(int oldId,Report e)
    {
        Report n = new Report();
        return n.updateReport(oldId, n);
    }
     
     public int SearchReport(int id)
    {
        Report n = new Report();
        return n.searchReport(id);
    }
    
     public ArrayList<Report> ShowReport() {
       Report n = new Report();
       return n.show_report();
    }
     
       
  public void creatOffer(int quantity , double price , int discount)
     {
         Offers x = new Offers(quantity ,price , discount);
         x.makeoffer(quantity, price, discount);
     }
  
  public ArrayList<Offers> showOffer()
    {
        Offers x = new Offers();
        return x.show_offer();
    }
     
     
     
  
}
