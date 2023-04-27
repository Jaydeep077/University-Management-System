package university_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class student_data extends JFrame implements ActionListener{
	JTextField tfname,tfregdno, tfaddress,tfphoneno,tfemail,tf10,tf12;
	JComboBox cbcourse,cbbranch;
	JLabel lbregdno;
	JDateChooser dob;
	JButton submit,cancel;
	
	//random number
	
	Random number=new Random();
	Long n1=Math.abs((number.nextLong(10000000,99999999)));
	
	student_data()
	{
		setSize(900,700);
		setLocation(280,50);
		setLayout(null);
		
		
		JLabel heading=new JLabel("New Student Details");
		heading.setBounds(300,30,500,50);
		heading.setFont(new Font("serif",Font.BOLD,31));
	    add(heading);
		
	    
	    
	    JLabel lblname=new JLabel("Name:"); 
		lblname.setBounds(90, 130, 80, 30);
		lblname.setFont(new Font("serif",Font.BOLD,15));
		add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(190, 130, 160, 28);
		add(tfname);
		
		
		JLabel  lbldob=new JLabel("Date of Birth:"); 
	    lbldob.setBounds(450, 130, 95, 30);
	    lbldob.setFont(new Font("serif",Font.BOLD,15));
		add(lbldob);
		
    	dob=new JDateChooser();
		dob.setBounds(550, 130, 160, 28);
		add(dob);
		
		
		
		JLabel  lblregdno=new JLabel("Regd.No.:"); 
	    lblregdno.setBounds(90, 200, 80, 30);
	    lblregdno.setFont(new Font("serif",Font.BOLD,15));
		add(lblregdno);
			
		lbregdno=new JLabel ("23"+n1);
		lbregdno.setBounds(190, 200, 160, 28);
		lbregdno.setFont(new Font("serif",Font.BOLD,16));
		add(lbregdno);
		
		
		
		
		JLabel  lbladdress=new JLabel("Address:"); 
	    lbladdress.setBounds(450, 200, 80, 30);
	    lbladdress.setFont(new Font("serif",Font.BOLD,16));
		add(lbladdress);
			
		tfaddress=new JTextField ();
		tfaddress.setBounds(550, 200, 160, 28);
		
		add(tfaddress);
		
		
		
		  
	    JLabel lblphoneno=new JLabel("Phone No.:"); 
		lblphoneno.setBounds(90, 270, 80, 30);
		lblphoneno.setFont(new Font("serif",Font.BOLD,16));
		add(lblphoneno);
		
		tfphoneno=new JTextField();
		tfphoneno.setBounds(190, 270, 160, 28);
		add(tfphoneno);
		
		
		
		    JLabel lblemail=new JLabel("Email:"); 
			lblemail.setBounds(450, 270, 80, 30);
			lblemail.setFont(new Font("serif",Font.BOLD,16));
			add(lblemail);
			
			tfemail=new JTextField();
			tfemail.setBounds(550, 270, 160, 28);
			add(tfemail);
			
			
			
			JLabel lbl10=new JLabel("10th mark(%):"); 
			lbl10.setBounds(90, 340, 110, 30);
			lbl10.setFont(new Font("serif",Font.BOLD,16));
			add(lbl10);
			
			tf10=new JTextField();
			tf10.setBounds(190, 340, 160, 28);
			add(tf10);
			
			

		    JLabel lbl12=new JLabel("12th mark(%):"); 
			lbl12.setBounds(450, 340, 110, 30);
			lbl12.setFont(new Font("serif",Font.BOLD,16));
			add(lbl12);
			
			tf12=new JTextField("");
			tf12.setBounds(550, 340, 160, 28);
			add(tf12);
			
			
			
			

			JLabel lblcourse=new JLabel("Course:"); 
			lblcourse.setBounds(90, 410, 110, 30);
     		lblcourse.setFont(new Font("serif",Font.BOLD,16));
			add(lblcourse);
			String course[]= {"B tech.","M tech.","BCA","MCA","BBA","MBA"};
			cbcourse=new JComboBox(course);
			cbcourse.setBounds(190, 410, 160, 28);
			cbcourse.setBackground(Color.white);
			add(cbcourse);
			
			
			 JLabel lblbranch=new JLabel("Branch:"); 
			 lblbranch.setBounds(450, 410, 110, 30);
			 lblbranch.setFont(new Font("serif",Font.BOLD,16));
			 add(lblbranch);
			 String branch[]= {"CSE","EEE","ECE","Mechanical Engineering","CSIT","Civil Engineering"};	
			 cbbranch=new JComboBox(branch);
			 cbbranch.setBounds(550, 410, 160, 28);
			 add(cbbranch);
			
			
			submit=new JButton("submit");
			submit.setFont(new Font("Ariel",Font.BOLD,15));
			submit.setBackground(Color.BLACK);
			submit.setForeground(Color.WHITE);
			submit.setBounds(310,500 ,100 ,30 );
			submit.addActionListener(this);
			add(submit);
			
			cancel=new JButton("cancel");
			cancel.setFont(new Font("Ariel",Font.BOLD,15));
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.WHITE);
			cancel.setBounds(440,500 ,100 ,30 );
			cancel.addActionListener(this);
			add(cancel);
			
			setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submit)
		{
			String name=tfname.getText();
			String dob1=((JTextField)dob.getDateEditor().getUiComponent()).getText();
			String regdno=lbregdno.getText();
			String address=tfaddress.getText();
			String class10=tf10.getText();
			String class12=tf12.getText();
			String phone=tfphoneno.getText();
			String email=tfemail.getText();
			String course=(String)cbcourse.getSelectedItem();
		    String branch =(String)cbbranch.getSelectedItem();
		
		try {
			String query="insert into student value('"+regdno+"','"+name+"','"+dob1+"','"+email+"','"+phone+"','"+course+"','"+branch+"','"+class10+"','"+class12+"','"+address+"')";
			connection sc=new connection();
			sc.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "successfully submitted.");
		
		setVisible(false);
		
		
		
		
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
		}
		else
			setVisible(false);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new student_data();
	} 

}
