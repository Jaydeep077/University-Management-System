 package university_management;

import java.awt.*;
import javax.swing.*;


public class frame_1 extends JFrame implements Runnable {
	Thread t;
    frame_1()
    {
    	
   
           JPanel panel = new JPanel();
    	   JLabel label1 = new JLabel("Welcom to abc");
           label1.setForeground(Color.BLACK);
           label1.setFont(new Font("SansSerif", Font.BOLD, 18));
           label1.setAlignmentX(123);
           label1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
           panel.add(label1);
        	
       	ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("iter.jpg"));
       	Image i2=i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
       	JLabel img= new JLabel(i1);  
        panel.add(img);
          
        add(panel);
      
//    	int x=0;
    	//for(int i=0;i<1200;i++,x++)
    	//{
    	setLocation(80,20);
    	setSize(1200,800);
    	t=new Thread(this);
    	t.start();
	 setVisible(true);
//    	try {
//    		Thread.sleep(1);
//    	}
//    	catch(Exception e) {}
     	//}

    }
    public void run()
    {
    	try {
			Thread.sleep(3000);
			setVisible(false);
			login l=new login();
		} catch(Exception e) {
			
			
		}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        frame_1 f=new frame_1();
	}

}
