package day0907;

import day0904.Student;

public class Ex14Const {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student("ĵ��",5);
		stu.write();
		
		Student stu2=new Student();
		stu2.write();
		System.out.println("-----------------");
		Student []arr=new Student[3];
		arr[0]=new Student();
		arr[1]=new Student("����", 23);
		arr[2]=new Student("��ȿ��",32);
		
		for(Student s:arr)
			s.write();		
	}
}
