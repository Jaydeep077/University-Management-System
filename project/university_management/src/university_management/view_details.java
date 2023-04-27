package university_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proteanit.sql.DbUtils;

public class view_details extends JFrame implements ActionListener {
	Choice regdno;
	JTable tbl;
	JButton search,print,update,add,cancel;
	
	view_details()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300,70,900,700);
		
		
		JLabel heading =new JLabel("search regd.no.-:");
		heading.setBounds(20,50,140,15);
		add(heading);
		
		regdno=new Choice();
		regdno.setBounds(170,50,130,15);
		add(regdno);
		
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
		
		tbl=new JTable();
		JScrollPane jsp=new JScrollPane(tbl);
		jsp.setBounds(5,120,880,570);
		add(jsp);
		
		
		try 
		{
			connection c=new connection();
			ResultSet s= c.s.executeQuery("select * from student");
			tbl.setModel(DbUtils.resultSetToTableModel(s)); 
		}catch(Exception e) 
		{
			e.printStackTrace();
		
		}
		
		
		search=new JButton("search");
		search.setBounds(70, 90, 80, 20);
		add(search);
		search.addActionListener(this);
		
		print=new JButton("print");
		print.setBounds(160, 90, 80, 20);
		add(print);
		print.addActionListener(this);
		
		update=new JButton("update");
		update.setBounds(250, 90, 80, 20);
		add(update);
		update.addActionListener(this);
		
		add=new JButton("add ");
		add.setBounds(340, 90, 80, 20);
		add(add);
		add.addActionListener(this);
		
		cancel=new JButton("cancel");
		cancel.setBounds(430, 90, 80, 20);
		add(cancel);
		cancel.addActionListener(this);
		
		
		
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==search)
		{
			String query ="select * from student where Registration_Number='"+regdno.getSelectedItem()+"'";
		
		try {
			connection c= new connection();
			ResultSet rs=c.s.executeQuery(query);
			tbl.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		}
		else if(e.getSource()==print)
		{
			try {
				tbl.print();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		else if(e.getSource()==add) {
			//setVisible(false);
			new student_data();
		}
		else if(e.getSource()==update)
		{
			new update_student();
		}
		else {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new	view_details();

	}
	
	

}
