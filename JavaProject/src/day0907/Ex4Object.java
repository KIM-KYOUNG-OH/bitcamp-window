package day0907;

class Melon
{
	static String SCHOOLNAME="��������б�";
	String name;
	int age;
}
public class Ex4Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Melon m1=new Melon();
		Melon m2=new Melon();
		m1.name="��ȣ��";
		m2.name="�̿���";
		System.out.println(m1.name+"\t"+m2.name);
		
		m1.age=20;
		m2.age=30;
		System.out.println(m1.age+"\t"+m2.age);
		
		m1.SCHOOLNAME="���ʰ���б�";//melon ��ü���� �����Ǵ� ����
		System.out.println(m1.SCHOOLNAME+"\t"+m2.SCHOOLNAME);
		System.out.println(Melon.SCHOOLNAME);//����ÿ��� Ŭ���������� ����
	}

}







