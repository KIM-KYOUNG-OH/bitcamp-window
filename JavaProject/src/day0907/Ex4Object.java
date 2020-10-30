package day0907;

class Melon
{
	static String SCHOOLNAME="강남고등학교";
	String name;
	int age;
}
public class Ex4Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Melon m1=new Melon();
		Melon m2=new Melon();
		m1.name="강호동";
		m2.name="이영자";
		System.out.println(m1.name+"\t"+m2.name);
		
		m1.age=20;
		m2.age=30;
		System.out.println(m1.age+"\t"+m2.age);
		
		m1.SCHOOLNAME="서초고등학교";//melon 객체에서 공유되는 변수
		System.out.println(m1.SCHOOLNAME+"\t"+m2.SCHOOLNAME);
		System.out.println(Melon.SCHOOLNAME);//변경시에도 클래스명으로 접근
	}

}







