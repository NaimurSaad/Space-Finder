package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;

public class Offices implements IOffices{
	Office oList[] = new Office[100];
	public static int oCount = 0;
	
	public Offices(){
		
		try{
			File file = new File("Files/OfficeList.txt"); 
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();  
					String line2 = sc.nextLine();  
					String line3 = sc.nextLine();  
					String line4 = sc.nextLine();  
					String line5 = sc.nextLine();  
					String line6 = sc.nextLine();  
					

					Office o = new Office(line1,line2,line3,line4,line5);
					oList[oCount] = o; 
					oCount++;
				
				}
			sc.close();   		
		}catch(Exception ex){
			
			System.out.println("File not found.");
			return;
		}
		
	}
	
	public int OfficeExists(String name){
		int index = -1; 
		for(int i=0;i<oCount;i++){
			if(oList[i].getName().equals(name)){
				index = i; 
				break;
			}
		}
		return index; 
		              
	}
	

	
	public Office getOffice(int index){
		return oList[index];
	}
	
	public void addOffice(Office o){
		
		oList[oCount] = o;
		oCount++;
		
		
		String OfficeDetails=o.getName() + "\n" + o.getRoom() + "\n"+
						   o.getFloor() + "\n"+ o.getLocation() + "\n" +
						   o.getPrice() + "\n" + "\n";
		try{
			FileWriter fw = new FileWriter("Files/OfficeList.txt",true);
			fw.write(OfficeDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void deleteOffice(String name){
		
		Office o = null;
		for(int i = 0; i<oCount; i++){
			if(oList[i].getName().equals(name)){
				o = oList[i];
				for(int j = i; j< oCount; j++){
					oList[j] = oList[j+1];
				}
				oCount--;
				oList[oCount] = null;
				break;
			}
		}
		
		
		String OfficeDetails=o.getName() + "\n" + o.getRoom() + "\n"+
						   o.getFloor() + "\n"+ o.getLocation() + "\n" +
						   o.getPrice() + "\n";
		
		try{
			String filepath = "Files/OfficeList.txt";
			File originalFile = new File(filepath);
				
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readOffice = sc.nextLine() + "\n";
					   readOffice += sc.nextLine() + "\n";
				       readOffice += sc.nextLine() + "\n";
				       readOffice += sc.nextLine() + "\n";
				       readOffice += sc.nextLine() +"\n";
				       readOffice += sc.nextLine();
				

				
				if(readOffice.equals(OfficeDetails)){
					
					continue;
				}
				
				newDetails += readOffice + "\n";
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	

}