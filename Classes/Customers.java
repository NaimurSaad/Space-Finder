package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;

public class Customers implements ICustomers{
	Customer customerList[] = new Customer[100];
	public static int customerCount = 0;
	
	public Customers(){
		
		try{
			File file = new File("Files/CustomerList.txt"); 
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();  
					String line2 = sc.nextLine();  
					String line3 = sc.nextLine();  
					String line4 = sc.nextLine();  
					String line5 = sc.nextLine();  
					String line6 = sc.nextLine();  
					

					
					
					Customer c = new Customer(line1,line2,line3,line4,line5);
					customerList[customerCount] = c; 
					customerCount++;
					
				}
			sc.close();   		
		}catch(Exception ex){
			
			System.out.println("File not found.");
			return;
		}
		
	}
	
	public int customerExists(String name){
		int index = -1; 
		for(int i=0;i<customerCount;i++){
			if(customerList[i].getName().equals(name)){
				index = i; 
				break;
			}
		}
		return index; 
		              
	}
	
	public Customer checkCredentials(int index, String pass){
		if((customerList[index].getPassword().equals(pass))){
			return customerList[index]; 
		}else{return null;}         
	}
	
	public Customer getCustomer(int index){
		return customerList[index];
	}
	
	public void addCustomer(Customer c){

		
		customerList[customerCount] = c;
		customerCount++;
		
		
		String customerDetails=c.getName() + "\n" + c.getEmail() + "\n"+
						   c.getPassword() + "\n"+ c.getNid() + "\n" +
						   c.getMobile() + "\n" + "\n";
		try{
			FileWriter fw = new FileWriter("Files/CustomerList.txt",true);
			fw.write(customerDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	
	public void deleteCustomer(String name){
		
		Customer c = null;
		for(int i = 0; i<customerCount; i++){
			if(customerList[i].getName().equals(name)){
				c = customerList[i];
				for(int j = i; j< customerCount; j++){
					customerList[j] = customerList[j+1];
				}
				customerCount--;
				customerList[customerCount] = null;
				break;
			}
		}
		
		
		String customerDetails=c.getName() + "\n" + c.getEmail() + "\n"+
						   c.getPassword() + "\n"+ c.getNid() + "\n" +
						   c.getMobile() + "\n";
		
		try{
			String filepath = "Files/CustomerList.txt";
			File originalFile = new File(filepath);
				
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readUser = sc.nextLine() + "\n";
					   readUser += sc.nextLine() + "\n";
				       readUser += sc.nextLine() + "\n";
				       readUser += sc.nextLine() + "\n";
				       readUser += sc.nextLine() +"\n";
				       readUser += sc.nextLine();
			
				
				if(readUser.equals(customerDetails)){
					
					continue;
				}
				
				newDetails += readUser + "\n";
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	

}