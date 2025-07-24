package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;

public class Apartments implements IApartments{
	Apartment aList[] = new Apartment[100];
	public static int aCount = 0;
	
	public Apartments(){
		
		try{
			File file = new File("Files/ApartmentList.txt"); 
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine();  //name
					String line2 = sc.nextLine();  //room
					String line3 = sc.nextLine();  //floor
					String line4 = sc.nextLine();  //location
					String line5 = sc.nextLine();  //price
					String line6 = sc.nextLine();  //extra newline for space between two objects
					
					
					Apartment a = new Apartment(line1,line2,line3,line4,line5);
					aList[aCount] = a; 
					aCount++;
					
				}
			sc.close();    		
		}catch(Exception ex){
			System.out.println("File not found.");
			return;
		}
		
	}
	
	public int apartmentExists(String name){
		int index = -1; 
		for(int i=0;i<aCount;i++){
			if(aList[i].getName().equals(name)){
				index = i; 
				break;
			}
		}
		return index; 
	}
	
	
	
	public Apartment getApartment(int index){
		return aList[index];
	}
	
	public void addApartment(Apartment a){
		
		aList[aCount] = a;
		aCount++;
		
		
		String apartmentDetails=a.getName() + "\n" + a.getRoom() + "\n"+
						   a.getFloor() + "\n"+ a.getLocation() + "\n" +
						   a.getPrice() + "\n" + "\n";
		try{
			FileWriter fw = new FileWriter("Files/ApartmentList.txt",true);
			fw.write(apartmentDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void deleteApartment(String name){
		
		Apartment a = null;
		for(int i = 0; i<aCount; i++){
			if(aList[i].getName().equals(name)){
				a = aList[i];
				for(int j = i; j< aCount; j++){
					aList[j] = aList[j+1];
				}
				aCount--;
				aList[aCount] = null;
				break;
			}
		}
		
		
		String apartmentDetails=a.getName() + "\n" + a.getRoom() + "\n"+
						   a.getFloor() + "\n"+ a.getLocation() + "\n" +
						   a.getPrice() + "\n";
		
		try{
			String filepath = "Files/ApartmentList.txt";
			File originalFile = new File(filepath);
				
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readApartment = sc.nextLine() + "\n";
					   readApartment += sc.nextLine() + "\n";
				       readApartment += sc.nextLine() + "\n";
				       readApartment += sc.nextLine() + "\n";
				       readApartment += sc.nextLine() +"\n";
				       readApartment += sc.nextLine();
				
				
				if(readApartment.equals(apartmentDetails)){
					
					continue;
				}
			
				newDetails += readApartment + "\n";
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	

}