import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;

public class Library {
	
	int Max=0;
	String UNAME,UPASS,PASS,sql;
	
	JFrame Library;
	JTextField tfUName;
	JPasswordField pfUPass;

	Library(){
		
		Library = new JFrame();
		Library.setBounds(100, 100, 800, 500);
		Library.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Library.setLayout(null);
		Library.setVisible(true);		
		
		//Lables
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lbLMS.setBounds(10, 11, 764, 62);
		Library.add(lbLMS);
		
		JLabel lbLogin = new JLabel("Login");
		lbLogin.setBounds(75, 120, 279, 41);
		lbLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Library.add(lbLogin);
		
		JLabel lbUN = new JLabel("User Name :");
		lbUN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbUN.setBounds(96, 172, 100, 28);
		Library.add(lbUN);
		
		JLabel lbPass = new JLabel("Password :");
		lbPass.setBounds(96, 211, 100, 28);
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Library.add(lbPass);
		
		JLabel lbNewUser = new JLabel("New user ? ");
		lbNewUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNewUser.setBounds(282, 372, 100, 28);
		Library.add(lbNewUser);		
		
		//Input Field USERNAME
		tfUName = new JTextField();
		tfUName.setBounds(206, 172, 220, 28);
		Library.add(tfUName);
		//tfUName.setColumns(10);
				
		//Input Field PASSWORD
		pfUPass = new JPasswordField();
		pfUPass.setBounds(206, 211, 220, 28);
		Library.add(pfUPass);
		
		//User Login Button
				JButton btnUserLogin = new JButton("User Login");
				btnUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnUserLogin.setBounds(146, 250, 135, 41);
				btnUserLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UNAME = tfUName.getText();
						UPASS = pfUPass.getText();
						sql = "SELECT Upass FROM Users WHERE Uusername like '" + UNAME + "'";
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library","root","root");
							PreparedStatement stmt = conn.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							rs.next();						
							PASS = rs.getString("Upass");
							if(UPASS.equals(PASS)){
								JOptionPane.showMessageDialog(null,"Login Successful","Success Message",JOptionPane.PLAIN_MESSAGE);
								new User(UNAME);
								Library.dispose();
							}
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null,"Login Failed","Failure Message",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				Library.add(btnUserLogin);
				
				//Staff Login Button
				JButton btnStaffLogin = new JButton("Staff Login");
				btnStaffLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnStaffLogin.setBounds(291, 250, 135, 41);
				btnStaffLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						UNAME = tfUName.getText();
						UPASS = pfUPass.getText();
						sql = "SELECT Spass FROM Staff WHERE Susername like '" + UNAME + "'";
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library","root","root");
							PreparedStatement stmt = conn.prepareStatement(sql);
							ResultSet rs = stmt.executeQuery();
							rs.next();						
							PASS = rs.getString("Spass");
							if(UPASS.equals(PASS)){
								JOptionPane.showMessageDialog(null,"Login Successful","Success Message",JOptionPane.PLAIN_MESSAGE);
								new Staff(UNAME);
								Library.dispose();
							}
						}catch(Exception e1){
							JOptionPane.showMessageDialog(null,"Login Failed","Failure Message",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				Library.add(btnStaffLogin);
		
		//New user registration button
		JButton btnRegister = new JButton("Register Now");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(392, 366, 135, 41);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new URegi();
				//Library.dispose();
			}
		});
		Library.add(btnRegister);		
		
		//Searching Books Button
		JButton btnSearchLib = new JButton("Search Books");
		btnSearchLib.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchLib.setBounds(557, 142, 135, 41);
		btnSearchLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBooks();
			}
		});
		Library.add(btnSearchLib);

		//About Button
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAbout.setBounds(557, 194, 135, 41);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This is to Show the Details of the Library.","Message Box",JOptionPane.PLAIN_MESSAGE);
			}
		});
		Library.add(btnAbout);
		
		
		//Quit Button
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuit.setBounds(557, 246, 135, 41);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		Library.add(btnQuit);
		
	}
	
	public static void main(String[] args) {
		new Library();
	}
	
}

class User{	
	JFrame User;
	String username;
	
	User(String un){
		
		this.username = un;
		
		User = new JFrame();
		User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		User.setBounds(100, 100, 800, 500);
		User.setLayout(null);
		User.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		User.add(lbLMS);
		
		JLabel lbWelcome = new JLabel("Welcome...!!!");
		lbWelcome.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lbWelcome.setBounds(42, 91, 548, 50);
		User.add(lbWelcome);
		
		JLabel lbBL = new JLabel("Books you have lended.");
		lbBL.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lbBL.setBounds(42, 142, 245, 41);
		User.add(lbBL);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 184, 693, 160);
		User.add(scrollPane);
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
					
			String str = "select B.bid as Book_ID, B.ISBN, B.title as Title, B.edition as Edition, B.author as Author, B.publisher as Publisher, L.LendDate as Lend_Date from Books B, Lending L where L.bid = B.bid and L.Luser = '"+ username +"';"; 
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
			PreparedStatement ps = conn.prepareStatement(str);
			ResultSet rs = ps.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			 
		}catch(Exception e1) {
			//JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE);
		}

		JButton btnSearchLib = new JButton("Search Books");
		btnSearchLib.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchLib.setBounds(455, 382, 135, 41);
		btnSearchLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBooks();
			}
		});
		User.add(btnSearchLib);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(600, 382, 135, 41);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Library();
				User.dispose();
			}
		});
		User.add(btnLogOut);		

	}
}


class Staff{
	JFrame Staff;
	String SName;
	
	Staff(String SN){

		SName = SN;
		
		Staff = new JFrame();
		Staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Staff.setBounds(100, 100, 800, 500);
		Staff.setLayout(null);
		Staff.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		Staff.add(lbLMS);
		
		//Lend Books Button
		JButton btnLendBooks = new JButton("Lend Books");
		btnLendBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLendBooks.setBounds(310, 95, 135, 41);
		btnLendBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Lending(SName);
				Staff.dispose();
			}
		});
		Staff.add(btnLendBooks);
		
		//Add Staff Button
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SRegi();
			}
		});
		btnAddStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStaff.setBounds(310, 149, 135, 41);
		Staff.add(btnAddStaff);
		
		//AddBooks Button
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBooks();
			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddBooks.setBounds(310, 201, 135, 41);
		Staff.add(btnAddBooks);
		
		//Look at Books Button
		JButton btnLookAtBooks = new JButton("Look At Books");
		btnLookAtBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Service not available", "Error", JOptionPane.ERROR_MESSAGE);
				new LookBooks();
			}
		});
		btnLookAtBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLookAtBooks.setBounds(310, 253, 135, 41);
		Staff.add(btnLookAtBooks);
		
		//Search Books Button
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchBooks.setBounds(310, 305, 135, 41);
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBooks();
			}
		});
		Staff.add(btnSearchBooks);
		
		//LogOut Button
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(310, 357, 135, 41);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Library();
				Staff.dispose();
			}
		});
		Staff.add(btnLogOut);
	
	}
}

class URegi{
	
	JFrame UReg;
	JTextField tfName;
	JTextField tfDOB;
	JTextField tfPhone;
	JTextField tfAddress;
	JTextField tfUN;
	JTextField tfPass;
	
	URegi(){
		UReg= new JFrame();
		UReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UReg.setBounds(100, 100, 800, 500);
		UReg.setLayout(null);
		UReg.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		UReg.add(lbLMS);

		JLabel lbUR = new JLabel("User Registration");
		lbUR.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lbUR.setBounds(20, 63, 245, 50);
		UReg.add(lbUR);
		
		JLabel lbName = new JLabel("Name :");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbName.setBounds(30, 124, 100, 28);
		UReg.add(lbName);
		
		tfName = new JTextField();
		tfName.setBounds(140, 124, 200, 28);
		UReg.add(tfName);
		
		JLabel lbDOB = new JLabel("Date of Birth :");
		lbDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDOB.setBounds(403, 124, 100, 28);
		UReg.add(lbDOB);
		
		tfDOB = new JTextField();
		tfDOB.setBounds(513, 124, 200, 28);
		UReg.add(tfDOB);
		
		JLabel lbPhone = new JLabel("Phone :");
 		lbPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPhone.setBounds(30, 163, 100, 28);
		UReg.add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(140, 163, 200, 28);
		UReg.add(tfPhone);
		
		JLabel lbAdd = new JLabel("Address :");
		lbAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAdd.setBounds(30, 202, 100, 28);
		UReg.add(lbAdd);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(140, 202, 573, 28);
		UReg.add(tfAddress);
		
		JLabel lbUName = new JLabel("username :");
		lbUName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbUName.setBounds(30, 241, 100, 28);
		UReg.add(lbUName);
		
		tfUN = new JTextField();
		tfUN.setBounds(140, 241, 200, 28);
		UReg.add(tfUN);
		
		JLabel lbPass = new JLabel("password :");
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPass.setBounds(403, 241, 100, 28);
		UReg.add(lbPass);
		
		tfPass = new JTextField();
		tfPass.setBounds(513, 241, 200, 28);
		UReg.add(tfPass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					PreparedStatement ps = conn.prepareStatement("insert into Users(Uusername, Upass, UName, DOB, address, phone) values(?,?,?,?,?,?);");
					ps.setString(1,tfUN.getText());
					ps.setString(2,tfPass.getText());
					ps.setString(3,tfName.getText());
					ps.setString(4,tfDOB.getText());
					ps.setString(5,tfAddress.getText()); 
					ps.setString(6,tfPhone.getText());
					
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null,"Registration Success","Success Message",JOptionPane.PLAIN_MESSAGE);
						UReg.dispose();
						new Library();
					}
					else {
						JOptionPane.showMessageDialog(null,"Registration Failed","Failed Message",JOptionPane.ERROR_MESSAGE);
						UReg.dispose();
						new Library();
					}
					ps.close();
					conn.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Registration Failed","Failed Message",JOptionPane.ERROR_MESSAGE);
					UReg.dispose();
					new Library();
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(337, 304, 135, 41);
		UReg.add(btnRegister);
		
	}
}

class SRegi{
	JFrame SReg;
	JTextField tfName;
	JTextField tfDOB;
	JTextField tfPhone;
	JTextField tfAddress;
	JTextField tfUN;
	JTextField tfPass;
	
	SRegi(){
		
		SReg= new JFrame();
		SReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SReg.setBounds(100, 100, 800, 500);
		SReg.setLayout(null);
		SReg.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		SReg.add(lbLMS);

		JLabel lbUR = new JLabel("Staff Registration");
		lbUR.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lbUR.setBounds(20, 63, 245, 50);
		SReg.add(lbUR);
		
		JLabel lbName = new JLabel("Name :");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbName.setBounds(30, 124, 100, 28);
		SReg.add(lbName);
		
		tfName = new JTextField();
		tfName.setBounds(140, 124, 200, 28);
		SReg.add(tfName);
		
		JLabel lbDOB = new JLabel("Date of Birth :");
		lbDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDOB.setBounds(403, 124, 100, 28);
		SReg.add(lbDOB);
		
		tfDOB = new JTextField();
		tfDOB.setBounds(513, 124, 200, 28);
		SReg.add(tfDOB);
		
		JLabel lbPhone = new JLabel("Phone :");
		lbPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPhone.setBounds(30, 163, 100, 28);
		SReg.add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(140, 163, 200, 28);
		SReg.add(tfPhone);
		
		JLabel lbAdd = new JLabel("Address :");
		lbAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAdd.setBounds(30, 202, 100, 28);
		SReg.add(lbAdd);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(140, 202, 573, 28);
		SReg.add(tfAddress);
		
		JLabel lbUName = new JLabel("username :");
		lbUName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbUName.setBounds(30, 241, 100, 28);
		SReg.add(lbUName);
		
		tfUN = new JTextField();
		tfUN.setBounds(140, 241, 200, 28);
		SReg.add(tfUN);
		
		JLabel lbPass = new JLabel("password :");
		lbPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPass.setBounds(403, 241, 100, 28);
		SReg.add(lbPass);
		
		tfPass = new JTextField();
		tfPass.setBounds(513, 241, 200, 28);
		SReg.add(tfPass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(337, 304, 135, 41);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					PreparedStatement ps = conn.prepareStatement("insert into Users(Uusername, Upass, UName, DOB, address, phone) values(?,?,?,?,?,?);");
					ps.setString(1,tfUN.getText());
					ps.setString(2,tfPass.getText());
					ps.setString(3,tfName.getText());
					ps.setString(4,tfDOB.getText());
					ps.setString(5,tfAddress.getText());
					ps.setString(6,tfPhone.getText());
					
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null,"Registration Success","Success Message",JOptionPane.PLAIN_MESSAGE);
						SReg.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Registration Failed","Failed Message",JOptionPane.ERROR_MESSAGE);
						SReg.dispose();
					}
					ps.close();
					conn.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Registration Failed","Failed Message",JOptionPane.ERROR_MESSAGE);
					SReg.dispose();
				}
			}
		});
		SReg.add(btnRegister);
	}
}

class SearchBooks{
	JFrame SBooks;
	JTextField tfSearch;
	JTable table;
	
	SearchBooks(){	
		SBooks = new JFrame();
		SBooks.setBounds(100, 100, 800, 500);
		SBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SBooks.setLayout(null);
		SBooks.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		SBooks.add(lbLMS);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(74, 63, 422, 37);
		SBooks.add(tfSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 111, 640, 339);
		SBooks.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	
					String str = "select ISBN, title as Title, edition as Ed, author as Author, publisher as Publisher from Books where title like '%" + tfSearch.getText() + "%' group by ISBN"; 
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					PreparedStatement ps = conn.prepareStatement(str);
					ResultSet rs = ps.executeQuery();
					
					table.setAutoCreateColumnsFromModel(true);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(501, 63, 102, 37);
		SBooks.add(btnSearch);
		
		JButton btnBack = new JButton("Go Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(613, 63, 102, 37);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SBooks.dispose();
			}
		});
		SBooks.add(btnBack);
		
	}
}
 
class Lending{
	String SName;
	JFrame Lending;
	JTextField tfLUser, tfBID;
	int bid;
	String UName;
	JTable table;
	
	Lending(String SN) {
		SName = SN; 
		Lending = new JFrame();
		Lending.setBounds(100, 100, 800, 500);
		Lending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lending.setLayout(null);
		Lending.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(0, 0, 784, 80);
		Lending.add(lbLMS);
		
		JLabel lbUN = new JLabel("username :");
		lbUN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbUN.setBounds(52, 91, 100, 28);
		Lending.add(lbUN);
		
		tfLUser = new JTextField();
		tfLUser.setColumns(10);
		tfLUser.setBounds(153, 91, 287, 28);
		Lending.add(tfLUser);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(52, 130, 100, 28);
		Lending.add(lblName);
		
		JLabel lblPName = new JLabel("Name");
		lblPName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPName.setBounds(153, 130, 100, 28);
		Lending.add(lblPName);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(52, 156, 100, 28);
		Lending.add(lblPhone);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNumber.setBounds(153, 156, 100, 28);
		Lending.add(lblMobileNumber);
		
		JLabel lblBooksYouHave = new JLabel("Books you have lent...");
		lblBooksYouHave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBooksYouHave.setBounds(52, 195, 301, 28);
		Lending.add(lblBooksYouHave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 230, 533, 125);
		Lending.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearchUser = new JButton("Search");
		btnSearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					
					UName = tfLUser.getText();
					
					PreparedStatement ps1 = conn.prepareStatement("select count(Uusername),UName,phone from Users where Uusername ='"+ UName +"';");
					ResultSet rs1 = ps1.executeQuery();
					rs1.next();
					int Count = Integer.parseInt(rs1.getString("count(Uusername)"));
					
					if(Count == 1) {
						lblPName.setText(rs1.getString("UName"));
						lblMobileNumber.setText(rs1.getString("phone"));
						
						String str = "select B.bid as Book_ID, B.ISBN, B.title as Title, B.edition as Edition, B.author as Author, B.publisher as Publisher, L.LendDate as Lend_Date from Books B, Lending L where L.bid = B.bid and L.Luser = '"+ UName +"';"; 
						PreparedStatement ps = conn.prepareStatement(str);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid USERNAME","Failed Message",JOptionPane.ERROR_MESSAGE);
					}
					 
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearchUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchUser.setBounds(450, 91, 135, 28);
		Lending.add(btnSearchUser);
		
		JLabel lbBID = new JLabel("Book ID :");
		lbBID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbBID.setBounds(52, 364, 100, 28);
		Lending.add(lbBID);
		
		tfBID = new JTextField();
		tfBID.setColumns(10);
		tfBID.setBounds(153, 366, 200, 28);
		Lending.add(tfBID);
		
		JButton btnLend = new JButton("Lend");
		btnLend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLend.setBounds(363, 366, 110, 28);
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int bid = Integer.parseInt(tfBID.getText()); 
					int x=0,y;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					PreparedStatement ps1 = conn.prepareStatement("set SQL_SAFE_UPDATES = 0");
					ps1.executeQuery();
				
					Statement st = conn.createStatement();
					y = st.executeUpdate("UPDATE Books SET bstatus = 'Lending' where bid = " + bid + " AND bstatus = 'Available'");
					if(y>0){
						
						Date dt = new Date();
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
						String date = ft.format(dt);
						
						PreparedStatement ps = conn.prepareStatement("insert into Lending(LUser, staff, bid, LendDate) values(?,?,?,?);");
						ps.setString(1,UName);
						ps.setString(2,SName);
						ps.setLong(3,bid);
						ps.setString(4,date);
						x = ps.executeUpdate();
						
						if(x>0){
							JOptionPane.showMessageDialog(null,"Successful","Success Message",JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null,"Failed","Failed Message",JOptionPane.ERROR_MESSAGE)	;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Book was already lent.","Failed Message",JOptionPane.ERROR_MESSAGE)	;
					}
					conn.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE)	;
				}
			}
		});
		Lending.add(btnLend);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReturn.setBounds(475, 366, 110, 28);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int bid = Integer.parseInt(tfBID.getText()); 
					int x=0,y;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					
					PreparedStatement ps1 = conn.prepareStatement("set SQL_SAFE_UPDATES = 0");
					ps1.executeQuery();
					
					Statement st = conn.createStatement();
					y = st.executeUpdate("DELETE FROM Lending where bid = " + bid + " AND Luser = '" + UName +"';");
					if(y>0){
						x = st.executeUpdate("UPDATE Books SET bstatus = 'Available' where bid = " + bid + " AND bstatus = 'Lending';");												
						if(x>0) {
							JOptionPane.showMessageDialog(null,"Successful","Success Message",JOptionPane.PLAIN_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null,"Failed","Failed Message",JOptionPane.ERROR_MESSAGE)	;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Book at Library.","Failed Message",JOptionPane.ERROR_MESSAGE)	;
					}
					conn.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE)	;
				}
			}
		});
		Lending.add(btnReturn);
		

		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHome.setBounds(620, 91, 135, 41);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Staff(SName);
				Lending.dispose();
			}
		});
		Lending.add(btnHome);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStaff.setBounds(620, 143, 135, 41);
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SRegi();
			}
		});
		Lending.add(btnAddStaff);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddBooks.setBounds(620, 195, 135, 41);
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBooks();
			}
		});
		Lending.add(btnAddBooks);
		
		JButton btnLBS = new JButton("Look At Books");
		btnLBS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLBS.setBounds(620, 247, 135, 41);
		btnLBS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"Service not Available.","Error",JOptionPane.ERROR_MESSAGE)	;
				new LookBooks();
			}
		});
		Lending.add(btnLBS);
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchBooks.setBounds(620, 299, 135, 41);
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBooks();
			}
		});
		Lending.add(btnSearchBooks);
		
		//LogOut Button
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(620, 351, 135, 41);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Library();
				Lending.dispose();
			}
		});
		Lending.add(btnLogOut);

	}
}

class AddBooks{
	JFrame ABooks;
	
	JTextField tfISBN;
	JTextField tfTitle;
	JTextField tfEdition;
	JTextField tfAuthor;
	JTextField tfPublisher;
	
	AddBooks(){
		ABooks = new JFrame();
		ABooks.setBounds(100, 100, 800, 500);
		ABooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ABooks.setLayout(null);
		ABooks.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		ABooks.add(lbLMS);
		
		JLabel lbAddBooks = new JLabel("Add Books....");
		lbAddBooks.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbAddBooks.setBounds(20, 63, 310, 61);
		ABooks.add(lbAddBooks);
		
		JLabel lbISBN = new JLabel("ISBN :");
		lbISBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbISBN.setBounds(20, 135, 100, 28);
		ABooks.add(lbISBN);
		
		tfISBN = new JTextField();
		tfISBN.setBounds(119, 137, 200, 28);
		ABooks.add(tfISBN);
		
		JLabel lbTitle = new JLabel("Title :");
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTitle.setBounds(20, 176, 100, 28);
		ABooks.add(lbTitle);
		
		tfTitle = new JTextField();
		tfTitle.setBounds(119, 178, 600, 28);
		ABooks.getContentPane().add(tfTitle);
		
		JLabel lbEdition = new JLabel("Edition :");
		lbEdition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbEdition.setBounds(409, 135, 100, 28);
		ABooks.add(lbEdition);
		
		tfEdition = new JTextField();
		tfEdition.setBounds(519, 137, 200, 28);
		ABooks.add(tfEdition);
		
		JLabel lbAuthor = new JLabel("Author :");
		lbAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAuthor.setBounds(20, 217, 100, 28);
		ABooks.add(lbAuthor);
		
		tfAuthor = new JTextField();
		tfAuthor.setBounds(119, 219, 600, 28);
		ABooks.add(tfAuthor);
		
		JLabel lbPublisher = new JLabel("Publisher :");
		lbPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbPublisher.setBounds(20, 258, 100, 28);
		ABooks.add(lbPublisher);
		
		tfPublisher = new JTextField();
		tfPublisher.setBounds(119, 258, 600, 28);
		ABooks.add(tfPublisher);
		
		//ADD BOOKS button
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					
					PreparedStatement stmt = conn.prepareStatement("select max(bid) from books;");
					ResultSet rs1 = stmt.executeQuery();
					rs1.next();						
					int Max = Integer.parseInt(rs1.getString("max(bid)"));
					Max = Max+1;

					PreparedStatement ps = conn.prepareStatement("insert into Books(ISBN, bid, title, edition, publisher, author, bstatus) values(?,?,?,?,?,?,?);");
					ps.setString(1,tfISBN.getText());
					ps.setLong(2,Max);
					ps.setString(3,tfTitle.getText());
					ps.setLong(4,Integer.parseInt(tfEdition.getText()));
					ps.setString(5,tfPublisher.getText());
					ps.setString(6,tfAuthor.getText());
					ps.setString(7,"Available");
					
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null,"Book added Successfully","Success Message",JOptionPane.PLAIN_MESSAGE);
						ABooks.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Some thing went wrong","Failed Message",JOptionPane.ERROR_MESSAGE)	;
						ABooks.dispose();
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Some thing went wrong","Failed Message",JOptionPane.ERROR_MESSAGE);
					ABooks.dispose();
				}

			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddBook.setBounds(398, 297, 135, 41);
		ABooks.add(btnAddBook);
		
	}
}

class LookBooks{
	JFrame LBooks;
	JTextField tfSearch;
	JTable table;
	
	LookBooks(){	
		LBooks = new JFrame();
		LBooks.setBounds(100, 100, 800, 500);
		LBooks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LBooks.setLayout(null);
		LBooks.setVisible(true);
		
		JLabel lbLMS = new JLabel("Library Management System");
		lbLMS.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMS.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLMS.setBounds(10, 11, 764, 41);
		LBooks.add(lbLMS);
		
//		tfSearch = new JTextField();
//		tfSearch.setBounds(74, 63, 422, 37);
//		LBooks.add(tfSearch);
//		
		JLabel lbLBooks = new JLabel("Books in the Library...");
		lbLBooks.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lbLBooks.setBounds(74, 63, 422, 37);
		LBooks.add(lbLBooks);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 111, 640, 339);
		LBooks.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
//		JButton btnSearch = new JButton("Search");
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
				try {
	
					String str = "select ISBN, title as Title, edition as Ed, author as Author, publisher as Publisher from Books;"; 
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","root");
					PreparedStatement ps = conn.prepareStatement(str);
					ResultSet rs = ps.executeQuery();
					
					table.setAutoCreateColumnsFromModel(true);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1,"Failed Message",JOptionPane.ERROR_MESSAGE);
				}
//			}
//		});
//		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnSearch.setBounds(501, 63, 102, 37);
//		LBooks.add(btnSearch);
//		
		JButton btnBack = new JButton("Go Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(613, 63, 102, 37);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LBooks.dispose();
			}
		});
		LBooks.add(btnBack);
		
	}
}



/*
class Admin{
	JFrame Admin = new JFrame();
	public Admin() {
			Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Admin.setBounds(100, 100, 800, 500);
			Admin.setLayout(null);
			Admin.setVisible(true);
			
			JLabel lblNewLabel = new JLabel("Library Management System");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
			lblNewLabel.setBounds(10, 11, 764, 41);
			Admin.add(lblNewLabel);

			JLabel lblWAdmin = new JLabel("Welcome Admin...");
			lblWAdmin.setFont(new Font("Tahoma", Font.ITALIC, 15));
			lblWAdmin.setBounds(118, 87, 300, 35);
			Admin.add(lblWAdmin);
			
			JButton btnAddStaff = new JButton("Add Staff");
			btnAddStaff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SRegi();
				}
			});
			btnAddStaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAddStaff.setBounds(310, 149, 135, 41);
			Admin.add(btnAddStaff);
			
			JButton btnAddBooks = new JButton("Add Books");
			btnAddBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddBooks();
				}
			});
			btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAddBooks.setBounds(310, 201, 135, 41);
			Admin.add(btnAddBooks);
			
			JButton btnLogOut = new JButton("Log Out");
			btnLogOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Library();
					Admin.dispose();
				}
			});
			btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnLogOut.setBounds(310, 357, 135, 41);
			Admin.add(btnLogOut);
			
			JButton btnLookBooks = new JButton("Look At Books");
			btnLookBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//new LookBooks();
				}
			});
			btnLookBooks.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnLookBooks.setBounds(310, 253, 135, 41);
			Admin.add(btnLookBooks);
			
			JButton btnLookUsers = new JButton("Users");
			btnLookUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnLookUsers.setBounds(310, 305, 135, 41);
			btnLookUsers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//new LookUsers();
				}
			});
			Admin.add(btnLookUsers);
		}
	
}
*/