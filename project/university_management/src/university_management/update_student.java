package university_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class update_student extends JFrame implements ActionListener {
	JTextField tfaddress,tfphoneno,tfemail,
	 tfcourse,tfbranch;
	 connection c=new connection();
	
	
	JLabel lbregdno;
	
	JButton update,cancel;
	Choice regdno;
	update_student(){
	
	
		
			setSize(900,700);
			setLocation(280,50);
			setLayout(null);

			JLabel heading1 =new JLabel("search regd.no.-:");
			heading1.setBounds(20,80,140,15);
			add(heading1);
			
			regdno=new Choice();
			regdno.setBounds(170,80,130,15);
			add(regdno);
			
			
			JLabel heading=new JLabel("update Student Details");
			heading.setBounds(300,0,500,50);
			heading.setFont(new Font("serif",Font.BOLD,32));
		    add(heading);
			
		    
		    
		    JLabel lblname=new JLabel("Name:"); 
			lblname.setBounds(90, 130, 80, 30);
			lblname.setFont(new Font("serif",Font.BOLD,16));
			add(lblname);
			
			JLabel lbl1name=new JLabel();
			lbl1name.setBounds(190, 130, 160, 28);
			lbl1name.setFont(new Font("serif",Font.BOLD,16));
			add(lbl1name);
			
			
			JLabel  lbldob=new JLabel("Date of Birth:"); 
		    lbldob.setBounds(450, 130, 95, 30);
		    lbldob.setFont(new Font("serif",Font.BOLD,15));
			add(lbldob);
			
	    	JLabel dob=new JLabel();
			dob.setBounds(550, 130, 160, 28);
			dob.setFont(new Font("serif",Font.BOLD,16));
			add(dob);
			
			
			
			JLabel  lblregdno=new JLabel("Regd.No.:"); 
		    lblregdno.setBounds(90, 200, 80, 30);
		    lblregdno.setFont(new Font("serif",Font.BOLD,15));
			add(lblregdno);
				
			lbregdno=new JLabel ();
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
				lbl10.setBounds(90, 340, 130, 30);
				lbl10.setFont(new Font("serif",Font.BOLD,16));
				add(lbl10);
				
				JLabel lbl1_10=new JLabel();
				lbl1_10.setBounds(200, 340, 28, 30);
				lbl1_10.setFont(new Font("serif",Font.BOLD,19));
				add(lbl1_10);
				
				

			    JLabel lbl12=new JLabel("12th mark(%):"); 
				lbl12.setBounds(450, 340, 130, 30);
				lbl12.setFont(new Font("serif",Font.BOLD,16));
				add(lbl12);
				
				JLabel lbl1_12=new JLabel("");
				lbl1_12.setBounds(560, 340, 28, 30);
				lbl1_12.setFont(new Font("serif",Font.BOLD,19));
				add(lbl1_12);
				
				
				
				

				JLabel lblcourse=new JLabel("Course:"); 
				lblcourse.setBounds(90, 410, 110, 30);
	     		lblcourse.setFont(new Font("serif",Font.BOLD,16));
				add(lblcourse);
			
				 tfcourse=new JTextField();
				tfcourse.setBounds(190, 410, 160, 28);
				tfcourse.setFont(new Font("serif",Font.BOLD,16));
				tfcourse.setBackground(Color.white);
				add(tfcourse);
				
				
				 JLabel lblbranch=new JLabel("Branch:"); 
				 lblbranch.setBounds(450, 410, 110, 30);
				 lblbranch.setFont(new Font("serif",Font.BOLD,16));
				 add(lblbranch);

			     tfbranch=new JTextField();
				 tfbranch.setBounds(550, 410, 160, 28);
				 tfbranch.setFont(new Font("serif",Font.BOLD,16));
				 add(tfbranch);
				
				 try {
					ResultSet s= c.s.executeQuery("select * from student");
					while(s.next()) 
					{
						regdno.add(s.getString("registration_number"));
					}
				}catch(Exception e) 
				{
					e.printStackTrace();
				
				}
				 
				 
				 try {
					 connection c=new connection();
					 String query="select * from student where Registration_Number='"+regdno.getSelectedItem()+"'";
					 ResultSet rs=c.s.executeQuery(query);
					 while(rs.next())
					 {
						 lbl1name.setText(rs.getString("Name"));
						 dob.setText(rs.getString("Date_of_Birth"));
						 lbregdno.setText(rs.getString("Registration_Number"));
						 tfcourse.setText(rs.getString("Course"));
						 tfbranch.setText(rs.getString("Branch"));
						 lbl1_10.setText(rs.getString("class_10th_mark_in_percentage"));
						 lbl1_12.setText(rs.getString("class_12th_mark_in_percentage"));
						 tfphoneno.setText(rs.getString("Phone_no"));
						 tfemail.setText(rs.getString("Email"));
						 tfaddress.setText(rs.getString("Address"));
					
					 }
					 
				 }
				 catch(Exception ex)
				 {
					 ex.printStackTrace();
				 }
				
				 regdno.addItemListener(new ItemListener()
				 {
					 public void itemStateChanged(ItemEvent ie) {
						 try 
				   {
						 connection c=new connection();
						 String query="select * from student where Registration_Number='"+regdno.getSelectedItem()+"'";
						 ResultSet rs=c.s.executeQuery(query);
						 while(rs.next())
						 {
							 lbl1name.setText(rs.getString("Name"));
							 dob.setText(rs.getString("Date_of_Birth"));
							 lbregdno.setText(rs.getString("Registration_Number"));
							 tfcourse.setText(rs.getString("Course"));
							 tfbranch.setText(rs.getString("Branch"));
							 lbl1_10.setText(rs.getString("class_10th_mark_in_percentage"));
							 lbl1_12.setText(rs.getString("class_12th_mark_in_percentage"));
							 tfphoneno.setText(rs.getString("Phone_no"));
							 tfemail.setText(rs.getString("Email"));
							 tfaddress.setText(rs.getString("Address"));
						
						 }
					}
					 catch(Exception e) {
						 e.printStackTrace();
					 }
					
					 }
					 
					 
	 });
				
				update=new JButton("update");
				update.setFont(new Font("Ariel",Font.BOLD,15));
				update.setBackground(Color.BLACK);
				update.setForeground(Color.WHITE);
				update.setBounds(310,500 ,100 ,30 );
				update.addActionListener(this);
				add(update);
				
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
			if(e.getSource()==update) {
				String regd_no=lbregdno.getText();
				String address=tfaddress.getText();
				String course=tfcourse.getText();
				String branch=tfbranch.getText();
				String email=tfemail.getText();
				String phno=tfphoneno.getText();
				
				
				try {
					String query="update student set Address='"+address+"',Phone_no='"+phno+"',Email='"+email+"',Branch='"+branch+"',Course='"+course+"' where Registration_Number='"+regd_no+"'";
					connection con=new connection();
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"updated successfully.");
					setVisible(false);
				}catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
				
			
			
			else
				{
					setVisible(false);
				}
		}
			

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new update_student(); 
	}

}
