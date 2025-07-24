package Interfaces;
import Classes.*;
public interface IApartments{
	void addApartment(Apartment a);
	Apartment getApartment(int index);
	void deleteApartment(String name);
}