package GUI;
import Classes.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class SpaceList extends JFrame implements ActionListener{
	JPanel panel;
	
	JLabel title1,imgLabel,title2,title3;
	ImageIcon img;
	JButton detailsbtn,lout;
	Font myFont,myFont2,myFont3;
	Apartments as;
	Offices os;
	Customers cs;
    DefaultListModel apartmentListModel,officeListModel;
	DefaultTableModel model,model2;
	JTable table,table2;
	JScrollPane apartmentScrollPane; 
	

	public SpaceList(Customers cs,Apartments as,Offices os){
	
	super("Space List");
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
	myFont2 = new Font("Arial",Font.PLAIN,18);
	myFont3 = new Font("Arial",Font.PLAIN,16);
	
	title1 = new JLabel("Space List");
	title1.setFont(myFont);
	title1.setBounds(370,100,200,40);
	panel.add(title1);
	
	title2 = new JLabel("Apartments");
	title2.setFont(myFont2);
	title2.setBounds(160,160,200,40);
	panel.add(title2);
	title3 = new JLabel("Offices");
	title3.setFont(myFont2);
	title3.setBounds(660,160,200,40);
	panel.add(title3);
	

		detailsbtn = new JButton("Details");
				detailsbtn.setFont(myFont2);
		detailsbtn.setBounds(725,490,120,40);
		detailsbtn.addActionListener(this);
		panel.add(detailsbtn);
		
		lout = new JButton("Log Out");
		lout.setFont(myFont3);
		lout.setBounds(50,490,120,40);
		lout.addActionListener(this);
		panel.add(lout);	
		
		
		
		model = new DefaultTableModel();
		
		table = new JTable(model);
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table.setBackground(new Color(255, 234, 10));
		//table.setShowGrid(true);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.setBounds(20, 210, 360, 200);
		
		model.addColumn("Name");
		model.addColumn("Room");
		model.addColumn("Floor");
		model.addColumn("Location");
		model.addColumn("Price");
		
	    apartmentListModel = new DefaultListModel<>();
    
    // Add existing apartments to the table
    for (int i = 0; i < as.aCount; i++) {
        Apartment apartment = as.getApartment(i);
        model.addRow(new Object[]{apartment.getName(), apartment.getRoom(), apartment.getFloor(), apartment.getLocation(), apartment.getPrice()});
        // Add apartment names to the list model
        apartmentListModel.addElement(apartment.getName());
    }

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 210, 360, 200);
		panel.add(scrollPane);
		
		model2 = new DefaultTableModel();
		
				table2 = new JTable(model2);
		
		table2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		table2.setBackground(new Color(255, 234, 10));
		//table.setShowGrid(true);
		table2.setSelectionBackground(new Color(255, 153, 51));
		table2.setBounds(510, 210, 360, 200);
		
		model2.addColumn("Name");
		model2.addColumn("Room");
		model2.addColumn("Floor");
		model2.addColumn("Location");
		model2.addColumn("Price");
		
	    officeListModel = new DefaultListModel<>();
    

    for (int i = 0; i < os.oCount; i++) {
        Office office = os.getOffice(i);
        model2.addRow(new Object[]{office.getName(), office.getRoom(), office.getFloor(), office.getLocation(), office.getPrice()});
        officeListModel.addElement(office.getName());
    }

		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(510, 210, 360, 200);
		panel.add(scrollPane2);

		img = new ImageIcon("Images/bg.png");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		panel.add(imgLabel);

		this.add(panel);
				
	
}

	
public void actionPerformed(ActionEvent ae) {
    String command = ae.getActionCommand();
    if (detailsbtn.getText().equals(command)) {
	   
        // Check if any row is selected in the apartment table
        int selectedApartmentRow = table.getSelectedRow();
        // Check if any row is selected in the office table
        int selectedOfficeRow = table2.getSelectedRow();

        if (selectedApartmentRow != -1) {
            // Get the name of the selected apartment
            String selectedApartmentName = (String) model.getValueAt(selectedApartmentRow, 0);
            // Find the apartment object corresponding to the selected name
            Apartment selectedApartment = null;
            for (int i = 0; i < as.aCount; i++) {
                if (as.getApartment(i).getName().equals(selectedApartmentName)) {
                    selectedApartment = as.getApartment(i);
                    break;
                }
            }
            // Open SpaceInfo window with selected apartment details
            ApartmentInfo ai = new ApartmentInfo(cs,as,os, selectedApartment);
            ai.setVisible(true);
            this.setVisible(false);
        } else if (selectedOfficeRow != -1) {
            // Get the name of the selected office
            String selectedOfficeName = (String) model2.getValueAt(selectedOfficeRow, 0);
            // Find the office object corresponding to the selected name
            Office selectedOffice = null;
            for (int i = 0; i < os.oCount; i++) {
                if (os.getOffice(i).getName().equals(selectedOfficeName)) {
                    selectedOffice = os.getOffice(i);
                    break;
                }
            }
            // Open SpaceInfo window with selected office details
            OfficeInfo oi = new OfficeInfo(cs,as,os, selectedOffice);
            oi.setVisible(true);
            this.setVisible(false);

    }else{JOptionPane.showMessageDialog(this,"Select an Appartment/Office.");
		
	}
		} else if (lout.getText().equals(command)) {
       Login l = new Login(cs,as,os);
	   l.setVisible(true);
	   this.setVisible(false);
    }
}
}

