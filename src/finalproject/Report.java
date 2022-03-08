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
public class Report implements Serializable{
    
   // java.util.Date dt = new java.util.Date();
    FileManagerBinary fManger = new FileManagerBinary();
    private final String employeeFileName = "report.bin";
    public ArrayList<Report> rep_list = new ArrayList<>();
    private int id;
   // private String date;
    private String description;
    private String suggestion;
    
    public Report()
    {
                
    }
    
    public Report(int id,String description,String suggestion)
    {
        this.id = id;
        this.description = description;
        this.suggestion = suggestion;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setDescription(String description)
    {
        this.description = description;

    }
    
    public void setSuggestion(String suggestion)
    {
        this.suggestion = suggestion;
    }
   
    public int getId()
    {
        return id;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getSuggestion()
    {
        return suggestion;
    }
    
    public boolean commitToFile()
    {
        return fManger.write(employeeFileName,rep_list);
    }
    
    public void loadFromFile()
    {
       rep_list = (ArrayList<Report>) fManger.read(employeeFileName);
    }
    
      public boolean make_report()
    {
        
        loadFromFile();
        rep_list.add(this);
        return commitToFile(); 
    }
      
    /*private int getReportIndex(int id) {
        for (int i = 0; i <rep_list.size(); i++) {
            if (rep_list.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }*/
      
   
    public int searchReport(int id)
    {
        loadFromFile();
        for(int i=0;i<rep_list.size();i++)
        {
        if(rep_list.get(i).getId() == id){
            return i;
        }
        }
            return -1;
    }
      
     
     public boolean delete_report(int id)
    {
        loadFromFile();
        int index = searchReport(id);
        if(index != -1)
        {
        rep_list.remove(index);
       return commitToFile();
        }
            return false;
    }
    
     public boolean updateReport(int oldID ,Report e)
     {
         loadFromFile();
        int index=searchReport(oldID);
        if (searchReport(oldID)!=-1)
        {
         rep_list.set(index, e);
         return commitToFile();
        }
        return false;
     }
     
     
      public ArrayList<Report> show_report() {
        loadFromFile();
        return rep_list;
    }
      
    /* public String listReport()
     {
         loadFromFile();
         String s = null;
         for (Report x : rep_list)
        {
            s = s + x.toString();
               
        }
        return s;
     }
     */
      public String toString()
    {
        return "\n id "+ id + "\n description "+ description  + "\n suggestion "+ suggestion +"\n";     
    }       
     
     
    
     
      
  /* public String show_report()
    {
        String data ="";
        
        loadFromFile();
        for(int i =0;i<rep_list.size();i++)
        {
            data +="Id:"+rep_list.get(i).getId()+"  "+dt+" "+"Description:"+rep_list.get(i).getDescription()+"  "+"Suggestion:"+rep_list.get(i).getSuggestion()+"\n";
        }
        return data;
    }
     */
    
    
}

