package Interfaces;
import Classes.*;
public interface ICustomers{
	void addCustomer(Customer c);
	Customer getCustomer(int index);
	void deleteCustomer(String name);
}