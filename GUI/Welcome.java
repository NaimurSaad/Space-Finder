package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel title1,title2,imgLabel;
	ImageIcon img;
	JButton cLogin,aLogin,reg;
	Font myFont,myFont2;
		Customer c = null;
	Customers cs =null ;
	Apartments as = null;
	Offices os = null;

	public Welcome(Customers cs,Apartments as, Offices os){
	
	super("Space Finder");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
		this.cs = cs;
	this.as = as;
	this.os = os;

	panel = new JPanel();
	panel.setLayout(null);
	
	myFont = new Font("Century",Font.ITALIC,35);
		myFont2 = new Font("Arial",Font.PLAIN,18);
	title1 = new JLabel("Welcome to Space Finder");
	title1.setFont(myFont);
	title1.setBounds(235,80,420,40);

	panel.add(title1);
	
	title2 = new JLabel("Here you can find your home for rent at Bashundhara");
	title2.setFont(myFont2);
	title2.setBounds(230,175,430,20);
	panel.add(title2);

	

	
		cLogin = new JButton("Customer Login");
			cLogin.setFont(myFont2);
		cLogin.setBounds(245,290,180,40);
		cLogin.addActionListener(this);
		panel.add(cLogin);
		
		aLogin = new JButton("Admin Login");
		aLogin.setBounds(455,290,180,40);
			aLogin.setFont(myFont2);
		aLogin.addActionListener(this);
		panel.add(aLogin);	

		reg = new JButton("Register");
		reg.setBounds(345,360,180,40);
			reg.setFont(myFont2);
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
		if(reg.getText().equals(command)){
			SignUp si = new SignUp(cs,as,os);
			si.setVisible(true);
			this.setVisible(false);
		}else if(cLogin.getText().equals(command)){
			Login lg = new Login(cs,as,os);
			lg.setVisible(true);
			this.setVisible(false);

		}else if(aLogin.getText().equals(command)){
			AdminLogin alg = new AdminLogin(cs,as,os);
			alg.setVisible(true);
			this.setVisible(false);
		}
}
}
