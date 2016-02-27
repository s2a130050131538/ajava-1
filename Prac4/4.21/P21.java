import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletConfig;
public class P21 extends HttpServlet {
	public void init(ServletConfig c){
	}
	public void doGet(HttpServletRequest rq,HttpServletResponse re) throws ServletException{
		re.setContentType("text/html");
		Connection c=null;
		Statement s=null;
		try{
			PrintWriter out=re.getWriter();
			out.println("enroll no. 130050131538");
			String name=rq.getParameter("name");
			int id=Integer.parseInt(rq.getParameter("id"));
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5433/s2a130050131538","postgres","krutika");
			s=c.createStatement();
			String query="insert into student values("+id+",'"+name+"','cse');";
			int i=s.executeUpdate(query);
			if(i!=0){
				out.println("<h2>Record has been inserted</h2>");
			}
			else{
				out.println("<h2>sorry! Failure</h2>");
			}
		}
		catch(IOException i){
			System.out.println("IOException");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	public void destroy(){
	}
}