package day0901;

public class Ex11DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ ����ȯ
		//int+int=int
		//char+int=int
		//byte+int=int
		//int+double=double
		//String+int=String
		//String+double=String
		
		char a='A';
		System.out.println(a+2);//����� �ڵ����� int
		System.out.println((char)(a+2));//(char) cast �����ڸ� ���ؼ� ����ȯ
		System.out.println("^^:"+5+3);//+�� �տ������� ����-��ü������ String
		System.out.println("^^:"+(5+3));//+ �� ���� ���ǵ��� �Ϸ��� () �� �����ش�
		
		System.out.println(7/4);//����� int 1
		System.out.println(7.0/4);//���� �ϳ��� double�̶�� ����� double�� ��Ȯ�� ���´�
		System.out.println(7/4.0);
		System.out.println((double)7/4);
	}

}
