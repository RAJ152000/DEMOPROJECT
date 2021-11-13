package in.demojava.app;
import java.sql.*;
import java.util.Scanner;
import java.io.Console;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try
     {
    	
    	 Scanner sc=new Scanner(System.in);
    	Console cns=System.console();
    	System.out.print("Enter the Department :");
    	String n=sc.nextLine();
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String dburl="jdbc:mysql://localhost:3306/studentdesw";
    	String dbuser="root";
    	String dbpassword="";
    	Connection cn=DriverManager.getConnection(dburl,dbuser,dbpassword);
    	Statement pst=cn.createStatement();
    	//PreparedStatement ct=cn.prepareStatement();
    	//String o="select * from studentsw where dept='"+n+"'";
    	String p="select count(dept) from studentsw where dept='"+n+"'";
    	
    	ResultSet rst=pst.executeQuery(p);
    	//ResultSet cot=ct.executeQuery();
    	
    	while(rst.next())
    	{

    		
    		System.out.println("Students count :"+rst.getInt("count(dept)"));
    	}
    	
    	
    	
    	cn.close();
     }
     catch(Exception e)
     {
    	 
    	e.printStackTrace(); 
     }

    }
}
