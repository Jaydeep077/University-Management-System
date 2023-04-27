package university_management;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class check_result extends JFrame implements ActionListener{
	JTextField search;
	JButton result,cancel;
	JTable table;
check_result()
{
	getContentPane().setBackground(Color.WHITE);
	setSize(800,700);
	setLocation(300,100);
	setLayout(null);
	

	JLabel lbl=new JLabel("check result:");
	lbl.setBounds(5,30,130,50);
	lbl.setFont(new Font("serif",Font.BOLD,22));
    add(lbl);
	
    search=new JTextField();
    search.setBounds(180, 80, 150, 30);
    add(search);
    
    result=new JButton("Check Result");
	result.setFont(new Font("Ariel",Font.BOLD,15));
	result.setBackground(Color.BLACK);
	result.setForeground(Color.WHITE);
	result.setBounds(350,80,140,30);
	result.addActionListener(this);
	add(result);
	
	cancel=new JButton("cancel");
	cancel.setFont(new Font("Ariel",Font.BOLD,15));
	cancel.setBackground(Color.BLACK);
	cancel.setForeground(Color.WHITE);
	cancel.setBounds(500,80 ,140 ,30 );
	cancel.addActionListener(this);
	add(cancel);
	
	table=new JTable();

    JScrollPane sp=new JScrollPane(table);
    sp.setBounds(0,200,800,700);
    add(sp);
   
    try {
    	connection c=new connection();
    	ResultSet rs=c.s.executeQuery("select * from student");
    	table.setModel(DbUtils.resultSetToTableModel(rs));
    	
    }catch(Exception e) {
    	e.printStackTrace();
    }
    
    table.addMouseListener(new MouseAdapter()
    		{
    	public void mouseClicked(MouseEvent me)
    	{
    		int row=table.getSelectedRow();
    		search.setText(table.getModel().getValueAt(row, 0).toString());
    	}
    	
    		});
   
	setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==result)
	{
		new show_mark(search.getText());
	}
	else
		setVisible(false);
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new check_result();
	}

}
