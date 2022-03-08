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
public class Product implements Serializable{

    private int stock_id;
    private String type;
    private double price;
    private String category;
    private int quantity;
    private String lasttday;
    
    public static ArrayList<Product>pro_list  = new ArrayList<>();
    FileManagerBinary fManger = new FileManagerBinary();
    private final String employeeFileName = "product.bin";
    
    public Product()
    {
        
    }
    
    public Product(int stock_id, String type, double price,String category, int quantity)
    {
        this.stock_id = stock_id;
        this.type = type;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
    
    public void setStock_id(int stock_id)
    {
        this.stock_id=stock_id;
    }
    public int getStock_id()
    {
        return stock_id;
    }
    public void setType(String type)
    {
        this.type=type;
    }
    public String getType()
    {
        return type;
    }
    public void setPrice(double price)
    {
        this.price=price;  
    }
    public double getPrice()
    {
        return price;
    }
    public void setCategory(String category)
    {
        this.category=category;
    }
    public String getCategory()
    {
        return category;
    }
    public void setQuantity (int quantity)
    {
        this.quantity=quantity;
    }
    public int getQuantity()
    {
        return quantity;
    }
    
   /* public void setlasttday (String lasttday)
    {
        if(lasttday == 26){
            damage();
        } else {
        }
        this.lasttday = lasttday;
    }
    public String getlasttday()
    {
        return lasttday;
    }*/
    
    public boolean commitToFile()
    {
        return fManger.write(employeeFileName,pro_list);
    }
    
    public void loadFromFile()
    {
       pro_list = (ArrayList<Product>) fManger.read(employeeFileName);
    }
    
    public boolean add_product()
    {
        loadFromFile();
        pro_list.add(this);
        return commitToFile();
    }
    
    private int getProductIndex(int id) {
        for (int i = 0; i <pro_list.size(); i++) {
            if (pro_list.get(i).getStock_id() == id) {
                return i;
            }
        }

        return -1;
    }
    
    
    
     public int search_product(int id)
    {
        int index = -1;
        loadFromFile();
        for(int i=0; i<pro_list.size(); i++)
        {
            if(stock_id == pro_list.get(i).getStock_id())
            {
                index = i;
            }
        }
        return index;
        
    }
/*
    public void delete_product(int stock_id)
    {
        loadFromFile();
        int index = search_product(stock_id);
        if(index > -1){
        pro_list.remove(index);
        commitToFile();
    }
     System.out.println(list_product());
    }
    */
     
     
     public boolean delete_product(int id)
    {
        loadFromFile();
        int index = getProductIndex(id);
        if(index != -1){
        pro_list.remove(index);
       return commitToFile();
    }
        else
        {
            return false;
        }
        
    }
     
     /*
     public String list_product()
    {
        String data ="";
        
        loadFromFile();
        for(int i =0;i<pro_list.size();i++)
        {
            data +="Stock_Id:"+pro_list.get(i).getStock_id()+"  "+"Type:"+pro_list.get(i).getType()+"  "+"Price:"+pro_list.get(i).getPrice()+"  "+"Category:"+pro_list.get(i).getCategory()+" "+"Quantity:"+pro_list.get(i).getQuantity()+"\n";
        }
        return data;
    }
    */
     
     public boolean update_product(Product o)
     {
        loadFromFile();
        int index = getProductIndex(this.getStock_id());
        if (index != -1) 
        {
            pro_list.set(index, o);
            return commitToFile();
        }
        return false;
         
     }
     
     public ArrayList<Product> list_product() {
        loadFromFile();
        return pro_list;
    }
     
    /* public String damage()
    {
        // now i need to add more than one product  so now i will work on one item ;
        Product x=new Product ();
         String dareturnss=" ";
         x. loadFromFile();
        for(int i =0;i<x.pro_list.size();i++)
        {
           dareturnss +="Stock_Id:"+x.pro_list.get(i).getStock_id();
        }
         return dareturnss;
    }      */
     
     
     
     
   /*  Scanner confirmation = new Scanner(System.in);
    ArrayList<Product> cart = new ArrayList();       //array of user-picked products, that he intends to buy.

    int user_product_index = -1; //an index that is given to the user each time he adds a product to the cart, in order to control it later

    //Add Products to the cart based on it's stock_ID
    public void addToCart(int product_stock_id)
    {
        int chosen_product_id = 0;

        for (int i = 0; i < pro_list.size();i++)   //Loop through the products untill you find matching stock id and add it to the cart.
        {
            if (product_stock_id == pro_list.get(i).getStock_id())
            {
                chosen_product_id = i;
            }
        }
/*
            When the Expiration-Date Code is added to the program,
            we may want to to check if the product is expired or not firstly,
            before adding it to the Arraylist.
*//*
        cart.add(pro_list.get(chosen_product_id));
        System.out.println("Congrats! You have added this product to your cart, to remove this item later, remember it's number: " + user_product_index++);
    }
    
    //Remove product from the Arraylist based on user_product_index
    public void removeFromCart (int cart_product_index)
    {
        //prompt the user for confirmation to delete the product
        System.out.println("You're about to remove this Product " + cart.get(cart_product_index) + " from your cart, are you sure?");
        System.out.print("Enter 0 to ignore, or Enter any number to confirm your Removal: ");

        int sure = 0;   //a varible to take action based on it's value
        sure = confirmation.nextInt();  //taking input from the user to confirm the removal of the product

        switch (sure)
        {
            case 0:
                System.out.println("Ok, Delete has been ignored");  //Remove Ignored
                return;
            default:
                cart.remove(cart_product_index);
                System.out.println("Done!, The Item has been Removed.");    //Remove Confirmed
                return;
        }
    }
*/
  
     
     @Override
     public String toString() //override 
    {
        return "Stock_id: "+stock_id+"\t :Type "+type+"\t Price: "+price+"\t Category: "+category+
                "\n Quantity:"+quantity+"\n"+"=====================";
    }
}

