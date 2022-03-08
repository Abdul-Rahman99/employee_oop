/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author nehas
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
        checkDirectoryContents(currentDir);
    
        
        Scanner input = new Scanner(System.in);
        MarktingModule p =new MarktingModule();
        Report b = new Report();
        System.out.println("Enter your number:\n1-To Add employee\n2-To delete employee\n3-To show employees \n4-To search for employee \n5-To update employee");
        int n = input.nextInt();
       switch(n)
       {
           case 1:
               System.out.println("Enter id ,description ,suggestion");
              /* d.setUserName(input.nextLine());
              // e.setDate(input.next());
              // input.nextLine();
               d.setPassWord(input.next());
               // input.nextLine();
               d.setId(input.nextInt());
               // input.nextLine();
               d.setPhoneNumber(input.next());
               // input.nextLine();
               d.setSalary(input.nextInt());
               // input.nextLine();
               d.setEmail(input.nextLine());
               // input.nextLine();
               d.setGender(input.next().charAt(0));
              // input.nextLine();
               d.setAddres(input.nextLine());
               //input.nextLine();
               d.setDOB(input.next());
              // input.nextLine();
               d.setQualification(input.nextLine());
              // input.nextLine();
               d.setDOJ(input.next());
               d.addAewemployee(input.nextLine(),input.next(),input.nextInt(),input.next(),input.nextDouble(),input.nextLine(),input.next().charAt(0),input.nextLine(),input.next(),input.nextLine(),input.next());
               */
               
               int r_id = input.nextInt();
               input.nextLine();
               String description = input.next();
               input.nextLine();
               String suggestion = input.next();
               p.creatNewReport(r_id, description, suggestion);
               break;
               
           case 2:
               System.out.println("Enter employee id");
               int id = input.nextInt();
               p.DeleteReport(id);
               break;
               
           case 3:
               System.out.println(p.ShowReport());
               break;
           case 4:
               System.out.println("Enter employee id");
               id = input.nextInt();
               p.SearchReport(id);
               break;
               
           case 5:
               System.out.println("Enter employee id");
               id = input.nextInt();
               p.UpdateReport(id, b);
               break;
               
           default:
               System.out.println("Enter a valid number");
               break;
        
       }
    }

     public static void checkDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        
        boolean billFile = true;
        boolean offersFile = true;
        boolean employeeFile = true;
        boolean reportFile = true;
        boolean productFile = true;
        //boolean emailFile = true;

        for (File file : files) {

            if (file.getName().contains("bill.bin")) {
                billFile = false;
            } else if (file.getName().contains("offers.bin")) {
                offersFile = false;
            } else if (file.getName().contains("employee.bin")) {
                employeeFile = false;
            } else if (file.getName().contains("report.bin")) {
                reportFile = false;
            } else if (file.getName().contains("product.bin")) {
                productFile = false;
            } /*else if (file.getName().contains("Email.bin")) {
                emailFile = false;
            }*/
        }
        if (billFile) {
            Bill x = new Bill();
            x.commitToFile();
        }

        if (offersFile) {
            Offers x = new Offers();
            x.commitToFile();
        }

        if (employeeFile) {
            Employee x = new Employee();
            x.commitToFile();
        }

        if (reportFile) {
            Report x = new Report();
            x.commitToFile();
        }

        if (productFile) {
            Product x = new Product();
            x.commitToFile();
        }
     }
}
        
        /*if (emailFile) {
            Email x = new Email();
            x.commitToFile();
        }*/
    
    

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   
        // TODO code application logic here
     /*   Scanner input = new Scanner(System.in);
        Admin d =new Admin();
        System.out.println("Enter your number:\n1-To Add employee\n2-To delete employee\n3-To show employees \n4-To search for employee");
       int n = input.nextInt();
       switch(n)
       {
           case 1:
               System.out.println("Enter username ,password  ,id ,phonenumber ,salary ,email ");
               d.setUserName(input.nextLine());
              // e.setDate(input.next());
              // input.nextLine();
               d.setPassWord(input.next());
               // input.nextLine();
               d.setId(input.nextInt());
               // input.nextLine();
               d.setPhoneNumber(input.next());
               // input.nextLine();
               d.setSalary(input.nextInt());
               // input.nextLine();
               d.setEmail(input.nextLine());
               // input.nextLine();
               d.setGender(input.next().charAt(0));
              // input.nextLine();
               d.setAddres(input.nextLine());
               //input.nextLine();
               d.setDOB(input.next());
              // input.nextLine();
               d.setQualification(input.nextLine());
              // input.nextLine();
               d.setDOJ(input.next());
               d.addAewemployee(input.nextLine(),input.next(),input.nextInt(),input.next(),input.nextDouble(),input.nextLine(),input.next().charAt(0),input.nextLine(),input.next(),input.nextLine(),input.next());
               
               break;
               
           case 2:
               System.out.println("Enter employee id");
               int id = input.nextInt();
               d.delete_employee(id);
               break;
               
           case 3:
               System.out.println(d.list_employee());
               break;
           case 4:
               System.out.println("Enter employee id");
               id = input.nextInt();
               //d.search_by_id(id);
               break;
               
           default:
               System.out.println("Enter a valid number");
               break;
           
       }
        
        
    }
    
}
*/