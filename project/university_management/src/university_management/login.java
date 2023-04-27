package university_management;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.JLabel;

public  class login extends JFrame implements ActionListener {
	JButton login,cancel;
	 JTextField un;
	 JTextField  password;
  login()
  {
	  getContentPane().setBackground(Color.GRAY);
	  setLayout(null);
	  
	 //label for user name 
	  JLabel lbl1=new JLabel("Username:");
	  lbl1.setBounds(40, 20, 100, 25);
	  lbl1.setFont(new Font("Arial",Font.BOLD,13));
	  add(lbl1);
	 
	 
	  un=new JTextField();
	  un.setBounds(145, 20, 200, 25);
	  add(un);
	 
	  //label for password
	  JLabel lb2=new JLabel("Password:");
	  lb2.setBounds(40, 55, 100, 25);
	  lb2.setFont(new Font("Arial",Font.BOLD,13));
	  add(lb2);
	 
	  password=new JPasswordField();
	  password.setBounds(145, 55, 200, 25);
	  add(password);
	  
	  login =new JButton("Login");
	  login.setBounds(40, 100, 100,30);
	  login.setBackground(Color.blue);
	  login.setForeground(Color.WHITE);
	  login.setFont(new Font("Tahoma",Font.BOLD,15));
	  login.addActionListener(this);
	  add(login);
	  
	  cancel =new JButton("cancel");
	  cancel.setBounds(150, 100, 100,30);
	  cancel.setBackground(Color.blue);
	  cancel.setForeground(Color.WHITE);
	  cancel.setFont(new Font("Tahoma",Font.BOLD,15));
	  cancel.addActionListener(this);
	  add(cancel);
	  
	  setSize(700,350);
	  setLocation(400,250);
	  setVisible(true);
	  
	  
  }
  public void actionPerformed(ActionEvent ae)
  {
	  if(ae.getSource()==cancel)
	  {
		  setVisible(false);
	  }
	  else if(ae.getSource()==login)
	  {
		  String user_name=un.getText();
		
		String pass=password.getText();
		  
		  String query="select * from login where username='"+user_name+"'and password='"+pass+"'";
		 
		  try {
			  connection c=new connection();
			 ResultSet rs= c.s.executeQuery(query);
			 
			 if(rs.next())
			 {
				 setVisible(false);
				 main_page mp=new main_page();
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "invalid user name or password");
			 }
			  
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
	  }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new login();
	}

}
