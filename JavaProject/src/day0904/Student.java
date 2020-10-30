package day0904;

public class Student {
	String name;
	int age;
	
	public Student()
	{
		name="µğÆúÆ®";
		age=10;
	}
	public Student(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	public void write()
	{
		System.out.println("name:"+this.name+"\nage:"+this.age);
	}
}
