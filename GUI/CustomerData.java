package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class CustomerData extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel title1,imgLabel;
	ImageIcon img;
	JButton remove,back;
	Font myFont,myFont2;
Customers cs;
Apartments as;
Offices os;
    DefaultListModel customerListModel,officeListModel;
	DefaultTableModel model,model2;
	JTable table,table2;
	JScrollPane apartmentScrollPane; 
	

	public CustomerData(Customers cs,Apartments as,Offices os){
	
	super("Customer Data");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	panel = new JPanel();
	panel.setLayout(null);

	this.cs = cs;
	this.as=as;
	this.os=os;
	myFont = new Font("Arial",Font.PLAIN,30);
	myFont2 = new Font("Arial",Font.PLAIN,16);
	
	title1 = new JLabel("Customer Data");
	title1.setFont(myFont);
	title1.setBounds(370,80,220,40);
	panel.add(title1);
	
	
	

		remove = new JButton("Remove");
		remove.setFont(myFont2);
		remove.setBounds(725,490,120,40);
		remove.addActionListener(this);
		panel.add(remove);
		
		back = new JButton("Back");
		back.setFont(myFont2);
		back.setBounds(50,490,120,40);
		back.addActionListener(this);
		panel.add(back);	
		
		
		
		model = new DefaultTableModel();
		
		table = new JTable(model);
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBackground(new Color(255, 234, 10));
		table.setShowGrid(true);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.setBounds(20, 150, 850, 300);
		
		model.addColumn("UserName");
		model.addColumn("Email");
		model.addColumn("Password");
		model.addColumn("NID");
		model.addColumn("Contact No");
		
	    customerListModel = new DefaultListModel();
    

    for (int i = 0; i < cs.customerCount; i++) {
        Customer customer = cs.getCustomer(i);
        model.addRow(new Object[]{customer.getName(), customer.getEmail(), customer.getPassword(), customer.getNid(), customer.getMobile()});
        
        customerListModel.addElement(customer.getName());
    }

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 150, 850, 300);
		panel.add(scrollPane);
		


		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);

		this.add(panel);
				
	
}

	
public void actionPerformed(ActionEvent ae) {
    String command = ae.getActionCommand();
  if (back.getText().equals(command)) {
       AdminPanel ap = new AdminPanel(cs,as,os);
	   ap.setVisible(true);
	   this.setVisible(false);
    } else if (remove.getText().equals(command)) {
        
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex != -1) { 
            String customerName = (String) model.getValueAt(selectedRowIndex, 0);
           
            cs.deleteCustomer(customerName); 
            model.removeRow(selectedRowIndex);
            customerListModel.removeElement(customerName);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to remove.");
	}
	} 
}
}



