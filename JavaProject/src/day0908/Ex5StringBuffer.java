package day0908;

public class Ex5StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ڿ��� ��������� �߰��� Ŭ����
		StringBuffer sb=new StringBuffer();
		sb.append("Happy");
		sb.append(123);
		sb.append("& Nice");
		System.out.println(sb);
		
		String str="Happy Day";
		StringBuffer sb2=new StringBuffer(str);
		System.out.println(sb2);
		sb2.insert(6, "Good");//6�� �ε����� Good ����
		System.out.println(sb2);
		sb2.delete(1, 4);//1~3�� �ε����κ� ����
		System.out.println(sb2);
		
		str=sb2.toString();//StringBuffer->String
		System.out.println(str);
	}

}
