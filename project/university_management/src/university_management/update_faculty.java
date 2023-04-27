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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class update_faculty extends JFrame implements ActionListener {
	JTextField tfaddress,tfphoneno,tfemail;
	
	 connection c=new connection();
	
	
	JLabel empid;
	
	JButton update,cancel;
	Choice emp_id;
	update_faculty()
	{

		Random number=new Random();
		Long n1=Math.abs((number.nextLong(90000000)));
		
		
			setSize(900,700);
			setLocation(280,50);
			setLayout(null);

			JLabel heading1 =new JLabel("search emp. id.-:");
			heading1.setBounds(20,80,140,15);
			add(heading1);
			
			emp_id=new Choice();
			emp_id.setBounds(170,80,130,15);
			add(emp_id);
			
			
			JLabel heading=new JLabel("update Faculty Details");
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
			
			
			
			JLabel  lblempid=new JLabel("Emp.id:"); 
		    lblempid.setBounds(90, 200, 80, 30);
		    lblempid.setFont(new Font("serif",Font.BOLD,15));
			add(lblempid);
				
			empid=new JLabel ();
			empid.setBounds(190, 200, 160, 28);
			empid.setFont(new Font("serif",Font.BOLD,16));
			add(empid);
			
			
			
			
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
				
				
				
				
				 try {
					ResultSet s= c.s.executeQuery("select * from  Faculty_info");
					while(s.next()) 
					{
						emp_id.add(s.getString("Emp_id"));
					}
				}catch(Exception e) 
				{
					e.printStackTrace();
				
				}
				 
				 
				 try {
					 connection c=new connection();
					 String query="select * from  Faculty_info where Emp_id='"+emp_id.getSelectedItem()+"'";
					 ResultSet rs=c.s.executeQuery(query);
					 while(rs.next())
					 {
						 lbl1name.setText(rs.getString("Name"));
						 empid.setText(rs.getString("Emp_id"));
						 dob.setText(rs.getString("DOB"));
						 tfemail.setText(rs.getString("Email"));
						
						
						 tfphoneno.setText(rs.getString("Phone_no"));
						 
						 tfaddress.setText(rs.getString("Address"));
					
					 }
					 
				 }
				 catch(Exception ex)
				 {
					 ex.printStackTrace();
				 }
				
				 emp_id.addItemListener(new ItemListener()
				 {
					 public void itemStateChanged(ItemEvent ie) {
						 try 
				   {
						 connection c=new connection();
						 String query="select * from  Faculty_info where Emp_id='"+emp_id.getSelectedItem()+"'";
						 ResultSet rs=c.s.executeQuery(query);
						 while(rs.next())
						 {
							 lbl1name.setText(rs.getString("Name"));
							 dob.setText(rs.getString("DOB"));
							 empid.setText(rs.getString("Emp_id"));
							
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
				String emp_id=empid.getText();
				String address=tfaddress.getText();
				
				String email=tfemail.getText();
				String phno=tfphoneno.getText();
				
				
				try {
					String query="update Faculty_info set Address='"+address+"',Phone_no='"+phno+"',Email='"+email+"' where Emp_id='"+emp_id+"'";
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
new update_faculty();
	}

}
