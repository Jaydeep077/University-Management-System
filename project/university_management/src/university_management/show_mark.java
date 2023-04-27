package university_management;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class show_mark extends JFrame implements ActionListener  {
	String regd_no;
	JButton calculator;
	
	show_mark(String regd_no)

	{
		getContentPane().setBackground(Color.WHITE);
		this.regd_no=regd_no;	
		setLayout(null);
		setSize(700,750);
		setLocation(300,30);
		
		 calculator=new JButton("Calculator");
		 calculator.setBounds(500, 100, 110, 20);
		 calculator.setForeground(Color.BLACK);
		
		 calculator.setFont(new Font("Arial",Font.BOLD,14));
		 calculator.addActionListener(this);
		 add(calculator);
		   
		    
		
		
		 JLabel lblregd_no=new JLabel("Registration.No.: "+regd_no); 
		 lblregd_no.setBounds(60, 100, 300, 30);
		 lblregd_no.setFont(new Font("serif",Font.BOLD,16));
		 add(lblregd_no);
		
		 JLabel name=new JLabel("Name:"); 
		 name.setBounds(60, 140, 140, 30);
		 name.setFont(new Font("serif",Font.BOLD,16));
		 add(name);
		 
		 JLabel lblname=new JLabel(""); 
		 lblname.setBounds(180, 140, 140, 30);
		 lblname.setFont(new Font("serif",Font.BOLD,16));
		 add(lblname);
		 
		 JLabel Semester=new JLabel("Semester:"); 
		 Semester.setBounds(60, 180, 140, 30);
		 Semester.setFont(new Font("serif",Font.BOLD,16));
		 add(Semester);
	
		 JLabel lblsemester=new JLabel(""); 
		 lblsemester.setBounds(180, 180, 140, 30);
		 lblsemester.setFont(new Font("serif",Font.BOLD,16));
		 add(lblsemester);
	
		 
		 JLabel sub1=new JLabel(""); 
		 sub1.setBounds(100, 360, 140, 30);
		 sub1.setFont(new Font("serif",Font.PLAIN,14));
		 add(sub1);
		 
		 
		 JLabel sub2=new JLabel(""); 
		 sub2.setBounds(100, 380, 140, 30);
		 sub2.setFont(new Font("serif",Font.PLAIN,14));
		 add(sub2);
		 
		 JLabel sub3=new JLabel(""); 
		 sub3.setBounds(100, 400, 140, 30);
		 sub3.setFont(new Font("serif",Font.PLAIN,14));
		 add(sub3);
		 
		 JLabel sub4=new JLabel(""); 
		 sub4.setBounds(100, 420, 140, 30);
		 sub4.setFont(new Font("serif",Font.PLAIN,14));
		 add(sub4);
		 
		 JLabel sub5=new JLabel(""); 
		 sub5.setBounds(100, 440, 140, 30);
		 sub5.setFont(new Font("serif",Font.PLAIN,14));
		 add(sub5);
	
		 
		 try {
			 connection c=new connection();
			 ResultSet rs1=c.s.executeQuery("select * from subject where Regd_no ='"+regd_no+"'");
			 while(rs1.next())
			 {
				sub1.setText(rs1.getString("subject1"));
				sub2.setText(rs1.getString("subject2"));
				sub3.setText(rs1.getString("subject3"));
				sub4.setText(rs1.getString("subject4"));
				sub5.setText(rs1.getString("subject5"));
				lblsemester.setText(rs1.getString("semester"));
				
			 }
			 
			 ResultSet rs2=c.s.executeQuery("select * from mark where Regd_no ='"+regd_no+"'");
			 while(rs2.next())
			 {
				sub1.setText(sub1.getText()+"  ----------->  "+rs2.getString("mark1"));
				sub2.setText(sub2.getText()+"  ----------->  "+rs2.getString("mark2"));
				sub3.setText(sub3.getText()+"  ----------->  "+rs2.getString("mark3"));
				sub4.setText(sub4.getText()+"  ----------->  "+rs2.getString("mark4"));
				sub5.setText(sub5.getText()+"  ----------->  "+rs2.getString("mark5"));
				
			 }
			 
			 
			 ResultSet rs3=c.s.executeQuery("select * from student where Registration_Number='"+regd_no+"'");
		     while(rs3.next())
			 {
				 lblname.setText(rs3.getString("Name"));
			 }
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==calculator)
		{
			try {
				Runtime.getRuntime().exec("calc.exe");
				
			}catch(Exception error) {}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new show_mark("");
	}

}
