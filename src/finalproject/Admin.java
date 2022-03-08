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
public class Admin extends Employee implements Serializable{
   
    public boolean addAewemployee(String username,String password,int id,String phonenumber,
            double salary,String email,char gender,String addres,
            String DOB,String qualification,String DOJ)
    {
        Employee s = new Employee(username,password,id,phonenumber,salary,email,gender,addres,DOB,qualification,DOJ);
        return s.addEmployee();
    }
    
    public ArrayList<Employee> listemployee()
    {
        Employee s = new Employee();
        return s.list_employee();
    }
    
    public boolean DeleteEmployee(int id)
    {
        Employee s = new Employee();
        return s.delete_employee(id);
    }
    
     public boolean UpdateEmployee(Employee e)
    {
        Employee s = new Employee();
        return s.update_employee(s);
    }
     
     public Employee SearchEmployee(int id)
    {
        Employee s = new Employee();
        return s.searchEmployee(id);
    }
    
     public boolean login(String username , String password)
     {
         return username.equals("Milad") && password.equals("54321");
     }
     
     
   /* 
    private int getEmployeeIndex(int id) {
        for (int i = 0; i <ad_list.size(); i++) {
            if (ad_list.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }
    
    public Employee search_by_id(int id)
    {
        Employee temp = new Employee();
        loadFromFile();
        int index = getEmployeeIndex(id);
        if(index != -1){
       return ad_list.get(index);
        }
        else
        {
            return temp;
        }
    }
    
     public boolean delete_employee(int id)
    {
        loadFromFile();
        int index = getEmployeeIndex(id);
        if(index != -1){
        ad_list.remove(index);
       return commitToFile();
    }
        else
        {
            return false;
        }
        
    }
     
    
     public String list_employee()
    {
        String data ="";
        
        loadFromFile();
        for(int i =0;i<ad_list.size();i++)
        {
            data +="Username:"+ad_list.get(i).getUserName()+"  "+"Password:"+ad_list.get(i).getPassWord()+"Id:"+ad_list.get(i).getId()+"  "+"Phonenumber:"+ad_list.get(i).getPhoneNumber()+" "+"Salary:"+ad_list.get(i).getSalary()+" "+"Email:"+ad_list.get(i).getEmail()+"\n";
        }
        return data;
    }
     
    /*  public ArrayList<Employee> list_employee() {
        loadFromFile();
        return ad_list;
    }
    */
    
}
