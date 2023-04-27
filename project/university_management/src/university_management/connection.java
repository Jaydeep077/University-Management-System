package university_management;
import java.sql.*;
public class connection {
	Connection c;
	Statement s;
connection()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver" );
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Universitymanagementsystem","root","2041013118");
        s=c.createStatement();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new connection();
	}

}
