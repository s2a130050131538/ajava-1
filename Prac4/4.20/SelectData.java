import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.sql.*;
  
 public class SelectData extends HttpServlet {
  
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
         PrintWriter out = res.getWriter();
         res.setContentType("text/html");
         out.println("<html><body>");
         try {
             Class.forName("org.postgresql.Driver");
			 out.println("enroll no. 130050131538");
             Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5433/s2a130050131538", "postgres", "krutika");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from student");
             out.println("<table border=1>");
             out.println("<tr><th>id</th><th>name</th><th>branch</th><tr>");
             while (rs.next()) {
                 int n = rs.getInt("id");
                 String nm = rs.getString("name");
                 String s = rs.getString("branch"); 
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>"); 
             }
             out.println("</table>");
             out.println("</html></body>");
             con.close();
            }
             catch (Exception e) {
             out.println("error");
         }
     }
 }