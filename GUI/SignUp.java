package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel userName,mobile,email,password,cPassword,nid,title,imgLabel;
	JTextField userNameTF,mobileTF,emailTF,nidTF;
	JPasswordField passTF,cPassTF;
	JButton home,reg;
	Font myFont,myFont2;
	ImageIcon img;
	Customer c = null;
	Customers cs = null;
	Apartments as ;
	Offices os;
	public SignUp(Customers cs,Apartments as,Offices os){
		
		super("Signup");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.cs=cs;
	this.as=as;
	this.os=os;
	panel = new JPanel();
	panel.setLayout(null);
		myFont = new Font("Arial",Font.PLAIN,22);
		myFont2 = new Font("Arial",Font.PLAIN,16);
		title = new JLabel("Enter Your Informations");
		title.setBounds(340,50,240,40);
		title.setFont(myFont);
		panel.add(title);
		userName = new JLabel("User Name: ");
		userName.setBounds(200,150,100,25);
		userName.setFont(myFont2);
		panel.add(userName);
		
		
		email = new JLabel("Email: ");
		email.setBounds(200,200,100,25);
		email.setFont(myFont2);
		panel.add(email);
		password = new JLabel("Password: ");
		password.setBounds(200,250,100,25);
		password.setFont(myFont2);
		panel.add(password);

		cPassword = new JLabel("Confirm Password: ");
		cPassword.setBounds(200,300,150,25);
		cPassword.setFont(myFont2);
		panel.add(cPassword);
		
		nid = new JLabel("NID: ");
		nid.setBounds(200,350,100,25);
		nid.setFont(myFont2);
		panel.add(nid);
		
		mobile = new JLabel("Contact No. : ");
		mobile.setBounds(200,400,100,25);
		mobile.setFont(myFont2);
		panel.add(mobile);
		
		
		userNameTF = new JTextField();
		userNameTF.setBounds(400,150,250,25);
		panel.add(userNameTF);
		
		
		emailTF = new JTextField();
		emailTF.setBounds(400,200,250,25);
		panel.add(emailTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(400,250,250,25);
		panel.add(passTF);
		
		cPassTF = new JPasswordField();
		cPassTF.setBounds(400,300,250,25);
		panel.add(cPassTF);
		
		nidTF = new JTextField();
		nidTF.setBounds(400,350,250,25);
		panel.add(nidTF);
		
		mobileTF = new JTextField();
		mobileTF.setBounds(400,400,250,25);
		panel.add(mobileTF);
		

		home = new JButton("Home");
			home.setFont(myFont2);
		home.setBounds(50,490,120,40);
		home.addActionListener(this);
		panel.add(home);

		reg = new JButton("Register");
			reg.setFont(myFont2);
		reg.setBounds(725,490,120,40);
		reg.addActionListener(this);
		panel.add(reg);

		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);
		
		
		this.add(panel);
	
}	

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(home.getText().equals(command)){
		Welcome w = new Welcome(cs,as,os);
			w.setVisible(true);
			this.setVisible(false);
		}
		if(reg.getText().equals(command)){
			String name = "",email = "", pass = "",confirmPass = "",
							nid="",mobile="";
			
			name = userNameTF.getText();
			pass = passTF.getText();
			confirmPass = cPassTF.getText();
			email = emailTF.getText();
			nid = nidTF.getText();
			mobile = mobileTF.getText();
			
if(cs.customerExists(name) != -1) {
                // Display error message
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
                return; // Stop further execution
            }
			
			if(!name.isEmpty() && !pass.isEmpty() && !confirmPass.isEmpty() && !email.isEmpty() && !nid.isEmpty() && !mobile.isEmpty()){
				if(pass.equals(confirmPass)){
					
					Customer c = new Customer(name,email,pass,nid,mobile);
					cs.addCustomer(c);
					
					JOptionPane.showMessageDialog(this,"Sign up successful. Please login to continue.");
				
					Login lg = new Login(cs,as,os);
					lg.setVisible(true);
					this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(this,"Password does not match");
				}
			}else{
				JOptionPane.showMessageDialog(this,"Information missing");
			}
		}
	}
}
		
	
