//SQL querry
CREATE OR REPLACE FUNCTION display()
  RETURNS TABLE(id integer, name character varying, branch character varying) AS
$BODY$	
BEGIN RETURN QUERY
SELECT * FROM student WHERE student.branch='cse';
END;
$BODY$
  LANGUAGE plpgsql STABLE
//
import java.sql.*;
class JDBC5{
	public static void main(String[] args){
		Connection con=null;
		PreparedStatement stmt=null;
		try{
			System.out.println("Enrollment:130050131538");
			MyData m1=new MyData();
			con=m1.SetConnection("s2a130050131538");
			stmt=con.prepareStatement("Select display()");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("display"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}