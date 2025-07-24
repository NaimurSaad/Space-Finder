package Classes;
import java.lang.*;

public  class Office extends Space{

public Office(String Name, String Room, String Floor,String Location, String Price){

	super(Name,Room,Floor,Location,Price);
}	
	// public void setName(String Name){
	// this.Name = Name;
	// }
	// public void setRoom(String Room){
		// this.Room = Room;
	// }
	// public void setFloor(String Floor){
		// this.Floor = Floor;
	// }
	// public void setPrice(String Price){
		// this.Price = Price;
	// }
	// public void setLocation(String Location){
		// this.Location = Location;
	// }
	public  String getName(){
		return super.Name;
	}
	public  String getRoom(){
	return super.Room;
	}
	public  String getFloor(){
		return super.Floor;
	}
	public  String getPrice(){
		return super.Price;
	}
	public  String getLocation(){
		return super.Location;
	}
}
