package comp421;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Register extends JFrame{
	JTextField name = new JTextField("Name");
	JTextField phonenum = new JTextField("Phone Number");
	JTextField cardnum = new JTextField("Card Number");
	JTextField expirydate = new JTextField("Expiry Date");
	JTextField bank = new JTextField("Bank");
	JTextField organization = new JTextField("Organization");
	JButton submit = new JButton("submit");
	
	SQL adduser;
	ResultSet rs;
	int userid;
	String sqlcode;
	
	public Register(SQL sqlo){
		adduser=sqlo;
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(6,2));
		jpanel.add(new JLabel("name:"));jpanel.add(name);
		jpanel.add(new JLabel("Phone Number:"));	jpanel.add(phonenum);
		jpanel.add(new JLabel("Card Number:")); 	jpanel.add(cardnum);
		jpanel.add(new JLabel("Expiry Date:")); 	jpanel.add(expirydate);
		jpanel.add(new JLabel("Bank:"));			jpanel.add(bank);
		jpanel.add(new JLabel("Card Issue Organzation")); jpanel.add(organization);
		this.add(jpanel,BorderLayout.CENTER);
		submit.addActionListener(new registerlistener());
		submit.setPreferredSize(new Dimension(20,40));
		this.add(submit, BorderLayout.SOUTH);
	}
	public static void invoke (SQL sqlo){
		JFrame register = new Register(sqlo);
		register.setVisible(true);
		register.setSize(400, 200);
		register.setDefaultCloseOperation(EXIT_ON_CLOSE);
		register.setLocationRelativeTo(null);
		register.setTitle("Register a new User");
	}
	class registerlistener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sqlcode ="";// get the max userid from user table
			rs = adduser.QueryExchte(sqlcode);
			userid = Integer.parseInt(rs.toString()) + 1;
			
			String Name = name.getText();
			String Pnum = phonenum.getText();
			String Cardnum = cardnum.getText();
			String Expirydate = expirydate.getText();
			String Bank = bank.getText();
			String Org = organization.getText();
			sqlcode = ""; // Insert a new buyer to table user and buyer.
			if(Name.isEmpty()||Pnum.isEmpty()||Cardnum.isEmpty()||Expirydate.isEmpty()||Bank.isEmpty()||Org.isEmpty())
				JOptionPane.showMessageDialog(null, "It is required to fill in every blank","Error",JOptionPane.ERROR_MESSAGE);
			else{
				adduser.WriteExcute(sqlcode);
				//Return back the current user id
			}
		}
		
	}
}
