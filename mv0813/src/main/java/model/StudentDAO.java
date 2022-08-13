package model;
import java.io.PrintWriter;
import java.sql.*;

public class StudentDAO {
      public boolean addArray(Student[ ]  arry ) {
    	  Connection conn=null;	     
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1234");
	            PreparedStatement  st=conn.prepareStatement("insert into classicmodels.student(username,age)values(?,?)");
	            st.setString(1,arry[0].getName());
	            st.setInt(2, arry[0].getAge());
	            int r=st.executeUpdate();
	            conn.close();
	            if(r>0)
	            	return true;
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex.getMessage());
	        }
	        return false;
      }
}
