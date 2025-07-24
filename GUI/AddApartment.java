package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddApartment extends JFrame implements ActionListener{
	
	JPanel panel;
	JLabel name,room,floor,location,price,title,imgLabel;
	JTextField nameTF,roomTF,floorTF,locationTF,priceTF;
	JButton cancel,add;
	Font myFont,myFont2;
	ImageIcon img;
	Apartment a = null;
	Apartments as = null;
	Offices os;
	Customers cs;

	public AddApartment(Customers cs,Apartments as,Offices os){
		
		super("Add Apartment");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.as=as;
	this.os = os;
	this.cs=cs;
	panel = new JPanel();
	panel.setLayout(null);
		myFont = new Font("Arial",Font.PLAIN,22);
		myFont2 = new Font("Arial",Font.PLAIN,16);
		title = new JLabel("Input Apartment Details");
		title.setBounds(340,50,240,40);
		title.setFont(myFont);
		panel.add(title);
		name = new JLabel("Name: ");
		name.setBounds(200,150,100,25);
		name.setFont(myFont2);
		panel.add(name);
		
		room = new JLabel("Room: ");
		room.setBounds(200,200,100,25);
		room.setFont(myFont2);
		panel.add(room);
		
		floor = new JLabel("Floor: ");
		floor.setBounds(200,250,100,25);
		floor.setFont(myFont2);
		panel.add(floor);
		location = new JLabel("Location: ");
		location.setBounds(200,300,100,25);
		location.setFont(myFont2);
		panel.add(location);

		price = new JLabel("Price: ");
		price.setBounds(200,350,100,25);
		price.setFont(myFont2);
		panel.add(price);
		
		
		
		nameTF = new JTextField();
		nameTF.setBounds(350,150,250,25);
		panel.add(nameTF);
		
		roomTF = new JTextField();
		roomTF.setBounds(350,200,250,25);
		panel.add(roomTF);
		
		
		floorTF = new JTextField();
		floorTF.setBounds(350,250,250,25);
		panel.add(floorTF);
		
		locationTF = new JTextField();
		locationTF.setBounds(350,300,250,25);
		panel.add(locationTF);
		
		priceTF = new JTextField();
		priceTF.setBounds(350,350,250,25);
		panel.add(priceTF);
		
	

		cancel = new JButton("Cancel");
				cancel.setFont(myFont2);
		cancel.setBounds(50,490,120,40);
		cancel.addActionListener(this);
		panel.add(cancel);

		add = new JButton("Add");
				add.setFont(myFont2);
		add.setBounds(725,490,120,40);
		add.addActionListener(this);
		panel.add(add);

		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);
		
		
		this.add(panel);
	
}	

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(cancel.getText().equals(command)){
					SpaceEdit se = new SpaceEdit(cs,as,os);
					se.setVisible(true);
					this.setVisible(false);
		}
		else if(add.getText().equals(command)){
			String name = "",room = "", floor = "",location = "",
							price="";
			
			name = nameTF.getText();
			room = roomTF.getText();
			floor = floorTF.getText();
			location = locationTF.getText();
			price = priceTF.getText();

			

			
			if(!name.isEmpty() && !room.isEmpty() && !floor.isEmpty() && !location.isEmpty() && !price.isEmpty()){
				
					
					Apartment a = new Apartment(name,room,floor,location,price);
					as.addApartment(a);
					
					JOptionPane.showMessageDialog(this,"Added");
					SpaceEdit se = new SpaceEdit(cs,as,os);
					se.setVisible(true);
					this.setVisible(false);

			}else{
				JOptionPane.showMessageDialog(this,"Information missing");
			}
		}
	}
}
		
	
