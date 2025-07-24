package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel title1,imgLabel;
	ImageIcon img;
	JTextField userTF;
	JPasswordField passTF;
	JButton back,cData,spaceList;
	Font myFont,myFont2,myFont3;
		Customers cs;
	Apartments as;
	Offices os;

	public AdminPanel(Customers cs,Apartments as,Offices os){
	
	super("Admin Panel");
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
	title1 = new JLabel("Admin Panel");
	title1.setFont(myFont);
	title1.setBounds(370,100,200,40);
		
	panel.add(title1);
	

	cData = new JButton("Customer Data");
	cData.setBounds(245,290,180,40);
	cData.addActionListener(this);
	cData.setFont(myFont2);
	panel.add(cData);
	
	spaceList = new JButton("Space Edit");
	spaceList.setBounds(455,290,180,40);
	spaceList.addActionListener(this);
	spaceList.setFont(myFont2);
	panel.add(spaceList);
	

	
		
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
		if(back.getText().equals(command)){
			AdminLogin al = new AdminLogin(cs,as,os);
			al.setVisible(true);
			this.setVisible(false);
		}else if(spaceList.getText().equals(command)){
			SpaceEdit se = new SpaceEdit(cs,as,os);
			se.setVisible(true);
			this.setVisible(false);

		}else if(cData.getText().equals(command)){
			CustomerData cd = new CustomerData(cs,as,os);
			cd.setVisible(true);
			this.setVisible(false);

		}
}
}