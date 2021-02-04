package apicrud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

public class Student_Repository 
{
	
			Connection conn=null;
			public Student_Repository() 
			{
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaapi", "root", "");

				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			public List<Student>getStudent1()
			{
				List<Student> students=new ArrayList<>();
				String select="select * from studentapi";
				try 
				{
					Statement st=conn.createStatement();
					ResultSet rs=st.executeQuery(select);
					while (rs.next()) 
					{
						Student s=new Student();
						s.setId(rs.getInt(1));
						s.setNo(rs.getInt(2));
						s.setName(rs.getString(3));
						s.setMarks(rs.getFloat(4));
						s.setAddress(rs.getString(5));
						s.setAge(rs.getInt(6));
						
						students.add(s);
					}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				return students;
			}
			
		
			public void create(Student std) {
				String insert="insert into studentapi values(?,?,?,?,?,?)";
				try 
				{
					PreparedStatement ps=conn.prepareStatement(insert);
					ps.setInt(1, std.getId());
					ps.setInt(2, std.getNo());
					ps.setString(3, std.getName());
					ps.setFloat(4, std.getMarks());
					ps.setString(5, std.getAddress());
					ps.setInt(6, std.getAge());
					ps.executeUpdate();
				}
				catch
				(Exception e) {
					// TODO: handle exception
				}
				
			}

			public void update(Student std) 
			{
				String update="update studentapi set no=?,name=?,marks=?,address=?,age=? where id=?";
				try 
				{
					PreparedStatement ps=conn.prepareStatement(update);
					
					ps.setInt(1, std.getNo());
					ps.setString(2, std.getName());
					ps.setFloat(3, std.getMarks());
					ps.setString(4, std.getAddress());
					ps.setInt(5, std.getAge());
					ps.setInt(6, std.getId());
					ps.executeUpdate();
				}
				catch
				(Exception e) {
					// TODO: handle exception
				}
				
			}

			public void delete(int id) 
			{
				String delete="delete from studentapi where id=?";
				try 
				{
					PreparedStatement ps=conn.prepareStatement(delete);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				catch
				(Exception e) {
					// TODO: handle exception
				}
				
			}

			public Student getStudent(int id) {
				// TODO Auto-generated method stub
				return null;
			}

			
}
