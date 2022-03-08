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
public class User implements Serializable{
    private String username;
    private String password;
    private int id;
    private String phonenumber;
    private String email;
    
    public User()
    {
        
    }
    public User(String username,String password,int id,String phonenumber,String email)
    {
        this.username = username;
        this.password = password;
        this.id = id;
        this.phonenumber = phonenumber;
        this.email = email;
    }
    
    FileManagerBinary fManger = new FileManagerBinary();
    String FileName = "offers.bin";
    ArrayList<User> off_list = new ArrayList<>();
    
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
        return fManger.write(FileName,off_list);
    }
    
    public void loadFromFile() 
    {
        off_list = (ArrayList<User>) fManger.read(FileName);
    }
   
    private int getUserIndex(int id) 
    {
        for (int i = 0; i <off_list.size(); i++) {
            if (off_list.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }
    
    public boolean updateuser(User e)
    {
        User s =new User();
        loadFromFile();
        int index = getUserIndex(this.getId());
        if (index != -1) 
        {
            off_list.set(index, e);
            return commitToFile();
        }
        return false;
    }
}
    /*private void Super(String username, String password, int id, String phonenumber, int salary, String email) {
        throw new UnsupportedOperationException("Not supported yet.");*/ //To change body of generated methods, choose Tools | Templates.
    /*}
   /*
    
public void update (int oldid, student x)
{
loadfromfile();
int index=getstudentindex(oldid);
students.set(index,x);
committofile();
}

   */
    
/*}*/
 /*   
    public User(String username,String password,int id,String phonenumber,int salary,String email
                    )
    {
        Super(username,password,id,phonenumber,salary,email);
    }*/
    