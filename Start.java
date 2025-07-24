import GUI.*;
import Classes.*;
public class Start{
	public static void main(String []args){
		Customers cs = new Customers();
		Apartments as = new Apartments();
		Offices os = new Offices();
			Welcome w = new Welcome(cs,as,os);
			w.setVisible(true);
		

	}
}