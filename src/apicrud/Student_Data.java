package apicrud;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")
public class Student_Data
{
	Student_Repository repo=new Student_Repository();
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Student> getStudent()
		{
			System.out.println("CRUD Success.....");
			return repo.getStudent1();
			
		}
	
	/*
	//these method can accept the any number on postman screen and sent entered no data using GET method
	@GET
	@Path("stud/{no}")
	
	//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	// above line code has been accept the xml or json formate request	
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent(@PathParam("no") int no)
	{
		
		return repo.getStudent(no);
		
	}*/
	
	
	//these method can accept the any number on postman screen and sent data using POST method

	
	@POST
	@Path("studentpost")
	//@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student createStudent(Student s)
	{
		System.out.println(s);
		repo.create(s);
		return s;
		
	}
	
	
	@PUT
	@Path("studentupdate")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student updateStudent(Student s)
	{
		System.out.println(s);
		System.out.println("record updated successfully");

		repo.update(s);
		return s;
		
		/*if(repo.getStudent1(s.getId()).getId())
		{
			repo.create(s);
		}
		else
		{
			repo.update(s);
		}*/
	}
	
	@DELETE
	@Path("studentdelete/{id}")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Student deleteStudent(@PathParam("id") int id)
	{
		Student sd=repo.getStudent(id);
		
		System.out.println("record deleted successfully where ID=	"+id);
			repo.delete(id);
		return sd;
	}
}
