package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class SpaceEdit extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel title1,imgLabel,title2,title3;
	ImageIcon img;
	JButton back,addAp,removeAp,addOf,removeOf;
	Font myFont,myFont2,myFont3;
	Apartments as;
	Offices os;
	Customers cs;
    DefaultListModel apartmentListModel,officeListModel;
	DefaultTableModel model,model2;
	JTable table,table2;
	JScrollPane apartmentScrollPane; 
	

	public SpaceEdit(Customers cs,Apartments as,Offices os){
	
	super("Space Edit");
	this.setSize(900,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	panel = new JPanel();
	panel.setLayout(null);

	this.as = as;
	this.os = os;
	this.cs=cs;
	myFont = new Font("Arial",Font.PLAIN,30);
	myFont2 = new Font("Arial",Font.PLAIN,20);	
	myFont3 = new Font("Arial",Font.PLAIN,16);
	
	title1 = new JLabel("Space List");
	title1.setFont(myFont);
	title1.setBounds(370,80,200,40);
	panel.add(title1);
	
	title2 = new JLabel("Apartments");
	title2.setFont(myFont2);
	title2.setBounds(160,140,200,40);
	panel.add(title2);
	title3 = new JLabel("Offices");
	title3.setFont(myFont2);
	title3.setBounds(660,140,200,40);
	panel.add(title3);
	
		
		back = new JButton("Back");
		back.setFont(myFont3);
		back.setBounds(50,490,120,40);
		back.addActionListener(this);
		panel.add(back);	
		
		addAp = new JButton("Add Apartment");
		addAp.setBounds(40,420,150,30);
		addAp.addActionListener(this);
		panel.add(addAp);
		
		removeAp = new JButton("Remove Apartment");
		removeAp.setBounds(200,420,150,30);
		removeAp.addActionListener(this);
		panel.add(removeAp);
		
		addOf = new JButton("Add Office");
		addOf.setBounds(520,420,150,30);
		addOf.addActionListener(this);
		panel.add(addOf);
		
		removeOf = new JButton("Remove Office");
		removeOf.setBounds(680,420,150,30);
		removeOf.addActionListener(this);
		panel.add(removeOf);
		
		
		model = new DefaultTableModel();
		
		table = new JTable(model);
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBackground(new Color(255, 234, 10));
		//table.setShowGrid(true);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.setBounds(20, 190, 360, 200);
		
		model.addColumn("Name");
		model.addColumn("Room");
		model.addColumn("Floor");
		model.addColumn("Location");
		model.addColumn("Price");
		
    
    
    for (int i = 0; i < as.aCount; i++) {
        Apartment apartment = as.getApartment(i);
        model.addRow(new Object[]{apartment.getName(), apartment.getRoom(), apartment.getFloor(), apartment.getLocation(), apartment.getPrice()});
       
        apartmentListModel.addElement(apartment.getName());
    }

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 190, 360, 200);
		panel.add(scrollPane);
		
		model2 = new DefaultTableModel();
		
				table2 = new JTable(model2);
		
		table2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table2.setBackground(new Color(255, 234, 10));
		
		table2.setSelectionBackground(new Color(255, 153, 51));
		table2.setBounds(510, 190, 360, 200);
		
		model2.addColumn("Name");
		model2.addColumn("Room");
		model2.addColumn("Floor");
		model2.addColumn("Location");
		model2.addColumn("Price");
		
	
    

    for (int i = 0; i < os.oCount; i++) {
        Office office = os.getOffice(i);
        model2.addRow(new Object[]{office.getName(), office.getRoom(), office.getFloor(), office.getLocation(), office.getPrice()});
        officeListModel.addElement(office.getName());
    }

		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(510, 190, 360, 200);
		panel.add(scrollPane2);

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
    } else if (removeAp.getText().equals(command)) {
        
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex != -1) { 
            String apartmentName = (String) model.getValueAt(selectedRowIndex, 0);
            
            as.deleteApartment(apartmentName); 
            model.removeRow(selectedRowIndex);
            apartmentListModel.removeElement(apartmentName);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an apartment to remove.");
	}
	} else if (removeOf.getText().equals(command)) {
        
        int selectedRowIndex = table2.getSelectedRow();
        if (selectedRowIndex != -1) { 
            String officeName = (String) model2.getValueAt(selectedRowIndex, 0);
            
            os.deleteOffice(officeName); 
            model2.removeRow(selectedRowIndex);
            officeListModel.removeElement(officeName);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an office to remove.");
        }
    }else if(addAp.getText().equals(command)) {
        
		AddApartment aa = new AddApartment(cs,as,os);
		aa.setVisible(true);
		this.setVisible(false);
	}else if(addOf.getText().equals(command)) {
        AddOffice ao = new AddOffice(cs,as,os);
		ao.setVisible(true);
			this.setVisible(false);
        
	}
}
}

