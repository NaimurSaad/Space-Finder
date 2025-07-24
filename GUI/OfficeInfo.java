package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OfficeInfo extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel name,room,floor,location,price,name1,room1,floor1,location1,price1,title,imgLabel;
	JButton back,payment;
	Font myFont,myFont2;
	ImageIcon img;
	Apartments as;
	Customers cs;
	Offices os;
	Office selectedOffice;
	public OfficeInfo(Customers cs,Apartments as,Offices os,Office selectedOffice){
		
		super("Office Info");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.as=as;
	this.cs=cs;
	this.os=os;
	this.selectedOffice = selectedOffice;
	
	panel = new JPanel();
	panel.setLayout(null);
		myFont = new Font("Arial",Font.PLAIN,22);
	myFont2 = new Font("Arial",Font.PLAIN,16);
		title = new JLabel("Office Informations");
		title.setBounds(340,50,240,40);
		title.setFont(myFont);
		panel.add(title);
		name = new JLabel("Name: ");
		name.setBounds(350,150,100,25);
		name.setFont(myFont2);
		panel.add(name);
		
		
		room = new JLabel("Room: ");
		room.setBounds(350,200,100,25);
		room.setFont(myFont2);
		panel.add(room);
		floor = new JLabel("Floor: ");
		floor.setBounds(350,250,100,25);
		floor.setFont(myFont2);
		panel.add(floor);

		location = new JLabel("Location: ");
		location.setBounds(350,300,100,25);
		location.setFont(myFont2);
		panel.add(location);
		
		price = new JLabel("Price: ");
		price.setBounds(350,350,100,25);
		price.setFont(myFont2);
		panel.add(price);
		
		
		
		name1 = new JLabel(selectedOffice.getName());
		name1.setBounds(500,150,250,25);
		name1.setFont(myFont2);
		panel.add(name1);
		
		
		room1 = new JLabel(selectedOffice.getRoom());
		room1.setBounds(500,200,250,25);
		room1.setFont(myFont2);
		panel.add(room1);
		
		floor1 = new JLabel(selectedOffice.getFloor());
		floor1.setBounds(500,250,250,25);
		floor1.setFont(myFont2);
		panel.add(floor1);
		
		location1 = new JLabel(selectedOffice.getLocation());
		location1.setBounds(500,300,250,25);
		location1.setFont(myFont2);
		panel.add(location1);
		
		price1 = new JLabel(selectedOffice.getPrice());
		price1.setBounds(500,350,250,25);
		price1.setFont(myFont2);
		panel.add(price1);
		

		

		back = new JButton("Back");
			back.setFont(myFont2);
		back.setBounds(50,490,120,40);
		back.addActionListener(this);
		panel.add(back);

		payment = new JButton("Payment");
			payment.setFont(myFont2);
		payment.setBounds(725,490,120,40);
		payment.addActionListener(this);
		panel.add(payment);

		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);
		
		
		this.add(panel);
	
}	

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(back.getText().equals(command)){
			SpaceList sl = new SpaceList(cs,as,os);
			sl.setVisible(true);
			this.setVisible(false);
		}else if(payment.getText().equals(command)){
			Payment p = new Payment(cs,as,os,selectedOffice);
			p.setVisible(true);
			this.setVisible(false);
			}
		}
	}

		
	
