package university_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class exam extends JFrame implements ActionListener{
	JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmark1,tfmark2,tfmark3,tfmark4,tfmark5;
	Choice regdno;
	JButton update,cancel;
	JComboBox boxsem;
	exam()
	{
		getContentPane().setBackground(Color.WHITE);
		
		setSize(900,650);
		setLocation(280,50);
		setLayout(null);
		
		
		
		
		JLabel heading=new JLabel("update mark");
		heading.setBounds(340,0,500,50);
		heading.setFont(new Font("serif",Font.BOLD,30));
	    add(heading);
		
	    
	    
	    JLabel regd =new JLabel("search regd.no.-:");
		regd.setBounds(20,90,130,30);
		regd.setFont(new Font("serif",Font.BOLD,15));
		add(regd);
		
		
		regdno=new Choice();
		regdno.setBounds(160,95,130,30);
		add(regdno);
	    
		
		JLabel lblsem =new JLabel(" Semester:");
		lblsem.setBounds(320,90,130,30);
		lblsem.setFont(new Font("serif",Font.BOLD,15));
		add(lblsem);
		
		String arrsem[]= {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
		boxsem=new JComboBox(arrsem);
		boxsem.setBackground(Color.WHITE);
		boxsem.setBounds(460,90,130,30);
		add(boxsem);
		
	    JLabel lblsub1=new JLabel("ENTER SUBJECT NAME"); 
	    lblsub1.setBounds(140, 150, 180, 30);
	  	lblsub1.setFont(new Font("serif",Font.BOLD,15));
	  	add(lblsub1);
	  	
	  	

	    JLabel lblsub2=new JLabel("ENTER MARK"); 
		lblsub2.setBounds(500, 150, 120, 30);
		lblsub2.setFont(new Font("serif",Font.BOLD,15));
		add(lblsub2);
	   
	  	JLabel dot=new JLabel("-------------------------------------------------------------------------------------------------------------------------------"); 
	  dot.setBounds(110, 170, 600, 5);
	  add(dot);
		
	
		
		
		 tfsub1=new JTextField();
		 tfsub1.setBounds(150, 200, 150, 30);
		 add(tfsub1);
		
		 tfmark1=new JTextField();
		 tfmark1.setBounds(500, 200, 100, 30);
	   	 add(tfmark1);
	 	
	   	 tfsub2=new JTextField();
		 tfsub2.setBounds(150, 240, 150, 30);
		 add(tfsub2);
		
		 tfmark2=new JTextField();
		 tfmark2.setBounds(500, 240, 100, 30);
	   	 add(tfmark2);
	   	 
	   	 tfsub3=new JTextField();
		 tfsub3.setBounds(150, 280, 150, 30);
		 add(tfsub3);
		
		 tfmark3=new JTextField();
		 tfmark3.setBounds(500, 280, 100, 30);
	   	 add(tfmark3);
	   	 
	   	 tfsub4=new JTextField();
		 tfsub4.setBounds(150, 320, 150, 30);
		 add(tfsub4);
		
		 tfmark4=new JTextField();
		 tfmark4.setBounds(500, 320, 100, 30);
	   	 add(tfmark4);
	   	 
	   	 tfsub5=new JTextField();
		 tfsub5.setBounds(150, 360, 150, 30);
		 add(tfsub5);
		
		 tfmark5=new JTextField();
		 tfmark5.setBounds(500, 360, 100, 30);
	   	 add(tfmark5);
	 	
		
			
			
						 
				 try 
					{
						connection c=new connection();
						ResultSet s= c.s.executeQuery("select * from student");
						while(s.next()) 
						{
							regdno.add(s.getString("registration_number"));
						}
					}catch(Exception e) 
					{
						e.printStackTrace();
					
					}
				 
					
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
	
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(e.getSource()==update)
		{
			String s1=tfsub1.getText();
			String s2=tfsub2.getText();
			String s3=tfsub3.getText();
			String s4=tfsub4.getText();
			String s5=tfsub5.getText();
			try {
				connection c=new connection();
				String query1="insert into subject values ('"+regdno.getSelectedItem()+"','"+boxsem.getSelectedItem()+"','"+ s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
				String query2="insert into mark values ('"+regdno.getSelectedItem()+"','"+boxsem.getSelectedItem()+"','"+tfmark1.getText()+"','"+tfmark2.getText()+"','"+tfmark3.getText()+"','"+tfmark4.getText()+"','"+tfmark5.getText()+"')";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "updated sucessfully");
				setVisible(false);
				
			}catch(Exception e1)
			{
				e1.printStackTrace();
				
			}
	
			
		}
		else
			setVisible(false);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
new exam();
	}

	
}
