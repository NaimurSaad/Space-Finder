package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel userLabel,passLabel,title1,title2,imgLabel,title3,cdetails,cnumber,expire,cvc,cowner,amount,amountnumber;
	ImageIcon img,img2,img3;
	JTextField cnumberTF,expireTF,cvcTF,cownerTF;
	JButton cancel,confirm;
	Font myFont,myFont2;
		Apartments as;
		Offices os;
		Customers cs;
		Apartment selectedApartment;
		Office selectedOffice;
	public Payment(Customers cs,Apartments as,Offices os,Apartment selectedApartment){
	
	super("Payment");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	panel = new JPanel();
	panel.setLayout(null);
	this.as=as;
	this.cs=cs;
	this.os=os;
	this.selectedApartment = selectedApartment;
	
	myFont = new Font("Arial",Font.PLAIN,25);
	myFont2 = new Font("Arial",Font.PLAIN,16);	
	title1 = new JLabel("Complete payment");
	title1.setFont(myFont);
	title1.setBounds(470,50,220,40);

	panel.add(title1);
	
		title2 = new JLabel("We accept");

	title2.setBounds(510,160,80,20);

	panel.add(title2);
						img3 = new ImageIcon("Images/vmlogo.png");
		imgLabel = new JLabel(img3);
		imgLabel.setBounds(580,160,80,20);
		panel.add(imgLabel);
	
	cdetails = new JLabel("Card Details:");
		cdetails.setFont(myFont2);
	cdetails.setBounds(430,210,120,30);
	panel.add(cdetails);

	cnumber = new JLabel("Card Number");
		cnumber.setFont(myFont2);
	cnumber.setBounds(430,260,120,30);
	panel.add(cnumber);

	cnumberTF = new JTextField();
		cnumberTF.setFont(myFont2);
	cnumberTF.setBounds(540,260,240,30);
	panel.add(cnumberTF);

	expire = new JLabel("Expire on");
		expire.setFont(myFont2);
	expire.setBounds(430,300,120,30);
	panel.add(expire);
	
		expireTF = new JTextField();
			expireTF.setFont(myFont2);
	expireTF.setBounds(540,300,90,30);
	panel.add(expireTF);

	cvc = new JLabel("CVC");
		cvc.setFont(myFont2);
	cvc.setBounds(650,300,90,30);
	panel.add(cvc);
	
		cvcTF = new JTextField();
			cvcTF.setFont(myFont2);
	cvcTF.setBounds(700,300,80,30);
	panel.add(cvcTF);
	
	cowner = new JLabel("Card Owner");
		cowner.setFont(myFont2);
	cowner.setBounds(430,340,120,30);
	panel.add(cowner);
	
	cownerTF = new JTextField();
		cownerTF.setFont(myFont2);
	cownerTF.setBounds(540,340,240,30);
	panel.add(cownerTF);
	
		amount = new JLabel("Total Amount:");
			amount.setFont(myFont2);
	amount.setBounds(510,390,120,30);
	panel.add(amount);
	
	amountnumber = new JLabel(selectedApartment.getPrice());
		amountnumber.setFont(myFont2);
	amountnumber.setBounds(610,390,120,30);
	panel.add(amountnumber);
	
	confirm = new JButton("Confirm");
			confirm.setFont(myFont2);
	confirm.setBounds(725,490,120,40);
	confirm.addActionListener(this);
	panel.add(confirm);
	
		cancel = new JButton("Cancel");
				cancel.setFont(myFont2);
		cancel.setBounds(50,490,120,40);
		cancel.addActionListener(this);
		panel.add(cancel);
	
		img2 = new ImageIcon("Images/card.png");
		imgLabel = new JLabel(img2);
		imgLabel.setBounds(50,200,300,180);
		panel.add(imgLabel);
		
		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);
		

		this.add(panel);
	
}
	public Payment(Customers cs,Apartments as,Offices os,Office selectedOffice){
	
	super("Payment");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	panel = new JPanel();
	panel.setLayout(null);
	this.as=as;
	this.cs=cs;
	this.os=os;
	this.selectedOffice = selectedOffice;
	
	myFont = new Font("Arial",Font.PLAIN,25);
	myFont2 = new Font("Arial",Font.PLAIN,16);	
	title1 = new JLabel("Complete payment");
	title1.setFont(myFont);
	title1.setBounds(470,50,220,40);

	panel.add(title1);
	
		title2 = new JLabel("We accept");

	title2.setBounds(510,160,80,20);

	panel.add(title2);
						img3 = new ImageIcon("Images/vmlogo.png");
		imgLabel = new JLabel(img3);
		imgLabel.setBounds(580,160,80,20);
		panel.add(imgLabel);
	
	cdetails = new JLabel("Card Details:");
		cdetails.setFont(myFont2);
	cdetails.setBounds(430,210,120,30);
	panel.add(cdetails);

	cnumber = new JLabel("Card Number");
		cnumber.setFont(myFont2);
	cnumber.setBounds(430,260,120,30);
	panel.add(cnumber);

	cnumberTF = new JTextField();
		cnumberTF.setFont(myFont2);
	cnumberTF.setBounds(540,260,240,30);
	panel.add(cnumberTF);

	expire = new JLabel("Expire on");
		expire.setFont(myFont2);
	expire.setBounds(430,300,120,30);
	panel.add(expire);
	
		expireTF = new JTextField();
			expireTF.setFont(myFont2);
	expireTF.setBounds(540,300,90,30);
	panel.add(expireTF);

	cvc = new JLabel("CVC");
		cvc.setFont(myFont2);
	cvc.setBounds(650,300,90,30);
	panel.add(cvc);
	
		cvcTF = new JTextField();
			cvcTF.setFont(myFont2);
	cvcTF.setBounds(700,300,80,30);
	panel.add(cvcTF);
	
	cowner = new JLabel("Card Owner");
		cowner.setFont(myFont2);
	cowner.setBounds(430,340,120,30);
	panel.add(cowner);
	
	cownerTF = new JTextField();
		cownerTF.setFont(myFont2);
	cownerTF.setBounds(540,340,240,30);
	panel.add(cownerTF);
	
		amount = new JLabel("Total Amount:");
			amount.setFont(myFont2);
	amount.setBounds(510,390,120,30);
	panel.add(amount);
	
	amountnumber = new JLabel(selectedOffice.getPrice());
		amountnumber.setFont(myFont2);
	amountnumber.setBounds(610,390,120,30);
	panel.add(amountnumber);
	
	confirm = new JButton("Confirm");
			confirm.setFont(myFont2);
	confirm.setBounds(725,490,120,40);
	confirm.addActionListener(this);
	panel.add(confirm);
	
		cancel = new JButton("Cancel");
				cancel.setFont(myFont2);
		cancel.setBounds(50,490,120,40);
		cancel.addActionListener(this);
		panel.add(cancel);
		
				img2 = new ImageIcon("Images/card.png");
		imgLabel = new JLabel(img2);
		imgLabel.setBounds(50,200,300,180);
		panel.add(imgLabel);
		
		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);
		

		this.add(panel);
	
}
		public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(cancel.getText().equals(command)){
			SpaceList sl = new SpaceList(cs,as,os);
			sl.setVisible(true);
			this.setVisible(false);
		}else if(confirm.getText().equals(command)){
			String cnum = "",exp = "", cvc = "",cowner = "";
			
			cnum = cnumberTF.getText();
			exp = expireTF.getText();
			cvc = cvcTF.getText();
			cowner = cownerTF.getText();
			
			if(!cnum.isEmpty() && !exp.isEmpty() && !cvc.isEmpty() && !cowner.isEmpty()){
					JOptionPane.showMessageDialog(this, "Congratulations");
								SpaceList sl = new SpaceList(cs,as,os);
			sl.setVisible(true);
			this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this,"Information missing");
			}
		}
}
}