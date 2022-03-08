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
public class Bill implements Serializable {
    
    private int billnumber;
    private String customerName;
    private int customerID;
    private String phonenumber;
    private String email;
    
    java.util.Date dt = new java.util.Date();
    ArrayList<Bill> bill_list = new ArrayList<>();
    FileManagerBinary fManger = new FileManagerBinary();
    String billFileName = "bill.bin";
    
    public Bill()
    {
        
    }
    
    public Bill(int billnumber,String customerName,int customerID,String phonenumber, String email)
    {
        this.billnumber = billnumber;
        this.customerName = customerName;
        this.customerID = customerID;
        this.phonenumber = phonenumber;
        this.email = email;
    }
    
    /*clothes array*/
    
    public void setBillNumber(int billnumber)
    {
        this.billnumber= billnumber;
    }
    
    public int getBillNumber()
    {
        return billnumber;
    }
   
    public void setCustomerName(String name)
    {
        this.customerName=name;
    }
    
    public String getCustomerName()
    {
        return customerName;
    }
    
    public void setCustomerID(int id)
    {
        this.customerID=id;
    }
    
    public int getCustomerID()
    {
        return customerID;
    }
    
    public void setPhoneNumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }
    
    public String getPhoneNumber()
    {
        return phonenumber;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public boolean commitToFile() 
    {
        return fManger.write(billFileName,bill_list);
    }
    
    public void loadFromFile() 
    {
        bill_list = (ArrayList<Bill>) fManger.read(billFileName);
    }
     
    public void makeBill()
    {
        loadFromFile();
        bill_list.add(this);
        commitToFile();
    }
    
    private int getProductIndex(int id) {
        for (int i = 0; i <bill_list.size(); i++) {
            if (bill_list.get(i).getBillNumber() == id) {
                return i;
            }
        }

        return -1;
    }
    
    public Bill searchinBill(int id)
    {
        Bill temp = new Bill();
        loadFromFile();
        int index = getProductIndex(id);
        if(index != -1){
       return bill_list.get(index);
        }
        else
        {
            return temp;
        }
    }
    
    public ArrayList<Bill> showBill() 
    {
        loadFromFile();
        return bill_list;
    }
    
    public boolean deleteBill(int id)
    {
        loadFromFile();
        int index = getProductIndex(id);
        if(index != -1){
        bill_list.remove(index);
       return commitToFile();
    }
        else
        {
            return false;
        }
        
    }
    
     public void removeItem(int id)
    {
        for (int i = 0; i < bill_list.size(); i++) {
            if (bill_list.get(i).getBillNumber() == id) {
                bill_list.remove(i);
            }
    }
    
}
}
    /*public void showBill()
    {   
        for (Object x : bill_list) {
            System.out.println(x.toString());
        }
    }*/
    /*
    public void deleteBill(int id)
    {
        for (int i = 0; i < bill_list.size(); i++) {
            if (bill_list.get(i).getBillNumber()== id) {
                bill_list.remove(i);
            }
    }
    }
    */
   
