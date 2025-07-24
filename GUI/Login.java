package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	JPanel panel;

	JLabel userLabel,passLabel,title1,title2,imgLabel;
	ImageIcon img,img2;
	JTextField userTF;
	JPasswordField passTF;
	JButton lgnBtn,back,reg;
	Font myFont,myFont2,myFont3;
	Customer c = null;
	Customers cs = null;
	Apartments as;
	Offices os;
	
	public Login(Customers cs,Apartments as,Offices os){
	
	super("Customer Login");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.cs = cs;
	this.as=as;
	this.os=os;
	
	panel = new JPanel();
	panel.setLayout(null);
	
	myFont = new Font("Arial",Font.PLAIN,30);
	myFont2 = new Font("Arial",Font.PLAIN,18);
			myFont3 = new Font("Arial",Font.PLAIN,16);
	title1 = new JLabel("Customer Login");
	title1.setFont(myFont);
	title1.setBounds(340,100,220,40);

	panel.add(title1);
	
	userLabel = new JLabel("Username: ");
	userLabel.setBounds(310,230,120,25);
	userLabel.setFont(myFont2);
	panel.add(userLabel);
	
	passLabel = new JLabel("Password: ");
	passLabel.setBounds(310,280,120,25);
	passLabel.setFont(myFont2);
	panel.add(passLabel);
	
	userTF = new JTextField();
	userTF.setBounds(430,230,150,25);
	userTF.setFont(myFont2);
	panel.add(userTF);
	
	passTF = new JPasswordField();
	passTF.setBounds(430,280,150,25);
	panel.add(passTF);
	
		lgnBtn = new JButton("Login");
	lgnBtn.setFont(myFont3);	
	lgnBtn.setBounds(395,380,120,40);
		lgnBtn.addActionListener(this);
		panel.add(lgnBtn);
		
		back = new JButton("Back");
		back.setFont(myFont3);
		back.setBounds(50,500,120,40);
		back.addActionListener(this);
		panel.add(back);	
		
		title2 = new JLabel("Don't have an account? Click 'Register Now'");
		title2.setBounds(320,505,255,20);
		panel.add(title2);
		
		reg = new JButton("Register Now");
			reg.setFont(myFont3);
		reg.setBounds(675,500,150,40);
		reg.addActionListener(this);
		panel.add(reg);
		
		img2 = new ImageIcon("Images/sqr.png");
		imgLabel = new JLabel(img2);
		imgLabel.setBounds(0,0,887,520);
		panel.add(imgLabel);
		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);

		this.add(panel);
		
	}
		public void actionPerformed(ActionEvent ae) {
			
		String command = ae.getActionCommand();
	if (lgnBtn.getText().equals(command)) {
        String name = userTF.getText();
        String pass = passTF.getText();

        int index = cs.customerExists(name);
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "User doesn't exist!");
        } else {
            c = cs.checkCredentials(index, pass);
            if (c == null) {
                JOptionPane.showMessageDialog(this, "Password incorrect");
            } else {

				JOptionPane.showMessageDialog(this, "Login Success");
				                SpaceList sl = new SpaceList(cs,as,os);
                sl.setVisible(true);
                this.setVisible(false);
            }
        }
    }else if  (back.getText().equals(command)) {
		        Welcome w = new Welcome(cs,as,os);
        w.setVisible(true);
        this.setVisible(false);
	}else if (reg.getText().equals(command)) {
        SignUp si = new SignUp(cs,as,os);
        si.setVisible(true);
        this.setVisible(false);
	}
}

}