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
public class Employee implements Serializable{
    private String username;
    private String password;
    private int id;
    private String phonenumber;
    private double salary;
    private String email;
    private char gender;
    private String addres;
    private String DOB;
    private String qualification;
    private String DOJ;

    public static ArrayList<Employee> emp_list = new ArrayList<>();
    FileManagerBinary fManger = new FileManagerBinary();
    private String employeeFileName = "employee.bin";
    public Employee()
    {
        
    }
    
    public Employee(String username,String password,int id,String phonenumber,double salary,String email,char gender,String addres,String DOB,String qualification,String DOJ)
    {
        this.username = username;
        this.password =password;
        this.id = id;
        this.phonenumber = phonenumber;
        this.salary = salary;
        this.email = email;
        this.gender = gender;
        this.addres = addres;
        this.DOB = DOB;
        this.qualification = qualification;
        this.DOJ = DOJ;
    }
    
     public void setUserName(String username)
    {
        this.username = username;
    }
    public String getUserName()
    {
        return username;
    }
    
    public void setPassWord(String password)
    {
        this.password = password;
    }
    public String getPassWord()
    {
        return password;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    
    public void setPhoneNumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }
    public String getPhoneNumber()
    {
        return phonenumber;
    }
    
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    public double getSalary()
    {
        return salary;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return email;
    }
    
    public void setGender(char gender)
    {
        this.gender = gender;
    }
    public char getGender()
    {
        return gender;
    }
    
    public void setAddres(String addres)
    {
        this.addres = addres;
    }
    public String getAddres()
    {
        return addres;
    }
    
    public void setDOB(String DOB)
    {
        this.DOB = DOB;
    }
    public String getDOB()
    {
        return DOB;
    }
    
    public void setQualification(String qualification)
    {
        this.qualification = qualification;
    }
    public String getQualification()
    {
        return qualification;
    }
    
    public void setDOJ(String DOJ)
    {
        this.DOJ = DOJ;
    }
    public String getDOJ()
    {
        return DOJ;
    }
    
    public boolean commitToFile()
    {
        return fManger.write(employeeFileName,emp_list);
    }
    
    public void loadFromFile()
    {
       emp_list = (ArrayList<Employee>) fManger.read(employeeFileName);
    }
    
    public boolean addEmployee()
    {
        loadFromFile();
        emp_list.add(this);
        return commitToFile();
    }
    
     private int getEmployeeIndex(int id) {
        for (int i = 0; i <emp_list.size(); i++) {
            if (emp_list.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }
     
     public Employee searchEmployee(int id)
    {
        Employee temp = new Employee();
        loadFromFile();
        int index = getEmployeeIndex(id);
        if(index != -1){
       return emp_list.get(index);
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
        emp_list.remove(index);
       return commitToFile();
    }
        else
        {
            return false;
        }
        
    }
     
      public ArrayList<Employee> list_employee() {
        loadFromFile();
        return emp_list;
    }
     
     public boolean update_employee(Employee e)
     {
        loadFromFile();
        int index = getEmployeeIndex(this.getId());
        if (index != -1) 
        {
            emp_list.set(index, e);
            return commitToFile();
        }
        return false;
         
     }
     
     public boolean login(String username,String password)
     {
         return username.equals("Employee") && password.equals("12345");
     }
     
     @Override
     public String toString() //override 
    {
        return "Username: "+username+"\t Password: "+password+"\t Id: "+id+"\t Phonenumber: "+phonenumber+
                "\n Salary:"+salary+"\t Email"+email+"\t Gender: "+gender+
                "\n Address"+addres+"\t DOB: "+DOB+
                "\t qualifications: "+qualification+"\t DOJ: "+DOJ+"\n"+"=====================";
    }

    
     
      /* public String list_employee()
    {
        String data ="";
        
        loadFromFile();
        for(int i =0;i<emp_list.size();i++)
        {
            data +="Username:"+emp_list.get(i).getUserName()+"  "+"Password:"+emp_list.get(i).getPassWord()+"Id:"+emp_list.get(i).getId()+"  "+"Phonenumber:"+emp_list.get(i).getPhoneNumber()+" "+"Salary:"+emp_list.get(i).getSalary()+" "+"Email:"+emp_list.get(i).getEmail()+" "+"Dender:"+emp_list.get(i).getGender()+" "+"Address:"+emp_list.get(i).getAddres()+"DOB:"+emp_list.get(i).getDOB()+" "+"Qualification:"+emp_list.get(i).getQualification()+" "+"DOJ:"+emp_list.get(i).getDOJ()+"\n";
        }
        return data;
    }
     */
}
