package university_management;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;


import javax.swing.*;

public class main_page extends JFrame implements ActionListener{
	   JMenuItem faculty,viewfaculty;
	   JMenuItem student, viewstudent,result,updatemark;
	main_page()
	{
        setBackground(Color.BLACK);
       	setSize(1920,1080);
       	
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("iter.jpg"));
       	Image i2=i1.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
       	JLabel img= new JLabel(i1);
		add(img);
		
		
		
		JMenuBar mb=new JMenuBar();
		setJMenuBar(mb);
		mb.setBackground(Color.BLACK);
		//Information
		 
		
		 JMenu details=new JMenu("new information");
		 details.setForeground(Color.white);
	     details.setFont(new Font("Arial",Font.BOLD,14));
		 mb.add(details);
		   
		    faculty=new JMenuItem("new Faculty Information");
		    details.add(faculty);
		    faculty.addActionListener(this);
		   
		    
		    student=new JMenuItem("new Student Information");
		    details.add(student);
		    student.addActionListener(this);
		
		//users details
		 
		 JMenu viewdetails=new JMenu("view details");
		 viewdetails.setForeground(Color.WHITE);
		 viewdetails.setFont(new Font("Arial",Font.BOLD,14));
		 mb.add(viewdetails);
		 
		    viewfaculty=new JMenuItem("Faculty Info.");
		    viewdetails.add(viewfaculty);
		    viewfaculty.addActionListener(this);
	   
		    
		    viewstudent=new JMenuItem("Student Info.");
		    viewdetails.add(viewstudent);
		    viewstudent.addActionListener(this);
		 
		 
		 //examination
		
		 JMenu exam=new JMenu("Examination");
		 exam.setForeground(Color.WHITE);
		
		 exam.setFont(new Font("Arial",Font.BOLD,14));
		 mb.add(exam);
		   
		   
      	    updatemark=new JMenuItem("Update Mark");
      	    updatemark.addActionListener(this);
		    exam.add(updatemark);
		    result=new JMenuItem("check result");
		    result.addActionListener(this);
		    exam.add(result);
		
		   		    
                //exit
			    JMenu exit=new JMenu("Exit");
				 exit.setForeground(Color.WHITE);
				 exit.setBackground(Color.white);
				 exit.setFont(new Font("Arial",Font.BOLD,14));
				 mb.add(exit);    
				 JMenuItem ext=new JMenuItem("Exit");
				 ext.setForeground(Color.red);
				 exit.add(ext);
				 ext.addActionListener(this);
			
		    
		    
		    mb.setBounds(0, 10, WIDTH,30);
		   
		    setVisible(true);
       
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();	
		if (s.equals("Exit"))
		{
			setVisible(false);
		}
				
		if(e.getSource()==student)
		{
			new student_data();
		}
		else if(e.getSource()==faculty)
		{
			new teacher_details();
		}
		
		else if(e.getSource()==viewfaculty)
		{
			new view_teacher_details();
		}
		else if(e.getSource()==viewstudent)
		{
			new view_details();
		}
		else if(e.getSource()==updatemark)
		{
			new exam();
		}
		else if(e.getSource()==result)
		{
			new check_result();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new main_page();
	}

}
