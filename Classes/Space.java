package Classes;
import Classes.*;
import java.lang.*;

public abstract class Space{
	protected String Name;
	protected String Room;
	protected String Floor;
	protected String Location;
	protected String Price;

public Space(String Name, String Room, String Floor,String Location, String Price){

	this.Name = Name;
	this.Room = Room;
	this.Floor = Floor;
	this.Price = Price;
	this.Location = Location;
}	

	public abstract String getName();
	public abstract String getRoom();
	public abstract String getFloor();
	public abstract String getPrice();
	public abstract String getLocation();
}
