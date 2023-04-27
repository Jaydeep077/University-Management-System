package university_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class view_teacher_details extends JFrame implements ActionListener{

	public static void main(String[] args) {
	new	view_teacher_details();
	}
		
		Choice empid;
		JTable tbl;
		JButton search,print,update,add,cancel;
		
		view_teacher_details()
		{
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			setBounds(300,70,900,700);
			
			
			JLabel heading =new JLabel("search Emp_id-:");
			heading.setBounds(20,50,140,15);
			add(heading);
			
			empid=new Choice();
			empid.setBounds(170,50,130,15);
			add(empid);
			
			try 
			{
				connection c=new connection();
				ResultSet s= c.s.executeQuery("select * from faculty_info");
				while(s.next()) 
				{
					empid.add(s.getString("Emp_id"));
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
				ResultSet s= c.s.executeQuery("select * from faculty_info");
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
				String query ="select * from faculty_info where Emp_id='"+empid.getSelectedItem()+"'";
			
			try {
				connection c= new connection();
				ResultSet rs=c.s.executeQuery(query);
				tbl.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (SQLException e1) {
				
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
				
				new teacher_details();
			}
			else if(e.getSource()==update)
			{
				new update_faculty();
				
			}
			else {
				setVisible(false);
			}
			
		}


	}

