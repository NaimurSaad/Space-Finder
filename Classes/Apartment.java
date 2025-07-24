package Classes;
import java.lang.*;

public  class Apartment extends Space{

public Apartment(String Name, String Room, String Floor,String Location, String Price){

	super(Name,Room,Floor,Location,Price);
	this.Name = Name;
	this.Room = Room;
	this.Floor = Floor;
	this.Location = Location;
	this.Price = Price;
}	
	public void setName(String Name){
	this.Name = Name;
	}
	public void setRoom(String Room){
		this.Room = Room;
	}
	public void setFloor(String Floor){
		this.Floor = Floor;
	}
	public void setPrice(String Price){
		this.Price = Price;
	}
	public void setLocation(String Location){
		this.Location = Location;
	}
	public  String getName(){
		return Name;
	}
	public  String getRoom(){
	return Room;
	}
	public  String getFloor(){
		return Floor;
	}
	public  String getPrice(){
		return Price;
	}
	public  String getLocation(){
		return Location;
	}
}
