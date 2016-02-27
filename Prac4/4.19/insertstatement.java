import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class insertstatement extends HttpServlet{
  public void doGet(HttpServletRequest request, 
  HttpServletResponse response)throws 
  ServletException, IOException{  
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String url = 
   "jdbc:postgresql://127.0.0.1:5433/s2a130050131538";
  Connection conn;
  try{
  Class.forName("org.postgresql.Driver");
  out.println("enroll no. 130050131538");
  conn = DriverManager.getConnection(url,"postgres","krutika");
  Statement statement = conn.createStatement();
  String query = "insert into student values(4,'riya','computer');";
  int i = statement.executeUpdate(query);
  if(i!=0){
  out.println("The record has been inserted");
  }
  else{
  out.println("Sorry! Failure");
  }
  statement.close();
  }
  catch (Exception e){
  System.out.println(e);
  }
  }
}