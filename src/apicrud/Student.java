package apicrud;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student 
{
	int no;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String name;
	Float marks;
	String address;
	int age;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getMarks() {
		return marks;
	}
	public void setMarks(Float marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [\n no=" + no + ", \n name=" + name + ", \n marks=" + marks + ", \n address=" + address + ", \n age=" + age
				+ "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
}
