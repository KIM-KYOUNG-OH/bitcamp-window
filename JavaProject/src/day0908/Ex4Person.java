package day0908;

public class Ex4Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person []per= {
			new Person(),new Person("��ȣ��", 2015, 187, 89.6),
			new Person("ȫ�浿", 1968, 168.9, 60.4)
		};
		
		for(Person p:per)
			System.out.println(p);//toString
		
		//System.out.println("0���� ��:"+per[0].getPungga());
		System.out.println();
		for(Person p:per)
		{
			System.out.println(p.getName()+"\t"+p.getddi()+"\t"+p.getPungga());
		}
	}
}
