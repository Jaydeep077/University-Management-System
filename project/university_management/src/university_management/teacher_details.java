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

public class teacher_details extends JFrame implements ActionListener{
	
	
	JTextField tfname,tfempid, tfaddress,tfphoneno,tfemail,tfqualification;

	JLabel lbempid;
	JDateChooser dob;
	JButton submit,cancel;
	
	Random number=new Random();
	Long n1=Math.abs((number.nextLong(100000,999999)));
	teacher_details()
	{
		setSize(900,700);
		setLocation(280,50);
		setLayout(null);
		
		
		JLabel heading=new JLabel("New Faculty Information");
		heading.setBounds(250,30,500,50);
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
		
		
		
		JLabel  lblempid=new JLabel("Employee Id.:"); 
	    lblempid.setBounds(90, 200, 130, 30);
	    lblempid.setFont(new Font("serif",Font.BOLD,15));
		add(lblempid);
			
		lbempid=new JLabel ("23"+n1);
		lbempid.setBounds(190, 200, 160, 28);
		lbempid.setFont(new Font("serif",Font.BOLD,16));
		add(lbempid);
		
		
		
		
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
			String empid=lbempid.getText();
			String address=tfaddress.getText();
			
			String phone=tfphoneno.getText();
			String email=tfemail.getText();
			
		try {
			String query="insert into Faculty_info value('"+name+"','"+empid+"','"+dob1+"','"+email+"','"+phone+"','"+address+"')";
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
		new teacher_details();

	}

}
