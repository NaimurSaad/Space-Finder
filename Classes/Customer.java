package Classes;
import java.lang.*;

public class Customer{
	private String name;
	private String email;
	private String password;
	private String nid;
	private String mobile;
	
	public Customer(String name,String email, String password,String nid,String mobile){
		this.name = name;
		this.email = email;
		this.password = password;
		this.nid = nid;
		this.mobile = mobile;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setEmail(String email){
		this.email = email;
	}	
	public void setPassword(String password){
		this.password = password;
	}
	public void setNid(String nid){
		this.nid = nid;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}

	public String getNid(){
		return nid;
	}
	public String getMobile(){
		return mobile;
	}
}