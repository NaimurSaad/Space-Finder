package Interfaces;
import Classes.*;
public interface IOffices{
	void addOffice(Office o);
	Office getOffice(int index);
	void deleteOffice(String name);
}