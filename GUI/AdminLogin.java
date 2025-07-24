package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel userLabel,passLabel,title1,imgLabel;
	ImageIcon img;
	JTextField userTF;
	JPasswordField passTF;
	JButton lgnBtn,back;
	Font myFont,myFont2,myFont3;
	Customers cs;
	Apartments as;
	Offices os;
	public AdminLogin(Customers cs,Apartments as,Offices os){
	
	super("Admin Login");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	
	this.cs=cs;
	this.as=as;
	this.os=os;
	panel = new JPanel();
	panel.setLayout(null);

	
	myFont = new Font("Arial",Font.PLAIN,30);
	myFont2 = new Font("Arial",Font.PLAIN,18);
	myFont3 = new Font("Arial",Font.PLAIN,16);
	title1 = new JLabel("Admin Login");
	title1.setFont(myFont);
	title1.setBounds(370,100,200,40);

	panel.add(title1);
	

	userLabel = new JLabel("Username: ");
	userLabel.setBounds(310,225,120,25);
	userLabel.setFont(myFont2);
	panel.add(userLabel);
	
	passLabel = new JLabel("Password: ");
	passLabel.setBounds(310,275,120,25);
	passLabel.setFont(myFont2);
	panel.add(passLabel);
	
	userTF = new JTextField();
	userTF.setBounds(430,225,150,25);
	userTF.setFont(myFont2);
	panel.add(userTF);
	
	passTF = new JPasswordField();
	passTF.setBounds(430,275,150,25);
	panel.add(passTF);
	
		lgnBtn = new JButton("Login");
			lgnBtn.setFont(myFont3);
		lgnBtn.setBounds(725,490,120,40);
		lgnBtn.addActionListener(this);
		panel.add(lgnBtn);
		
		back = new JButton("Back");
			back.setFont(myFont3);
		back.setBounds(50,490,120,40);
		back.addActionListener(this);
		panel.add(back);	
		
		
		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);

		this.add(panel);
	
}
		public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(lgnBtn.getText().equals(command)){
			
			 String username = userTF.getText();
             String password = new String(passTF.getPassword());
			 
              if (username.equals("admin") && password.equals("admin")) {
                 AdminPanel ap = new AdminPanel(cs,as,os);
				ap.setVisible(true);
				this.setVisible(false);
                } else {
				JOptionPane.showMessageDialog(this, "Wrong Username or Password");       
                }

		}else if(back.getText().equals(command)){
			Welcome w = new Welcome(cs,as,os);
			w.setVisible(true);
			this.setVisible(false);
		}
}
}