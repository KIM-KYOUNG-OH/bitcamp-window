package day0902;

public class Ex14Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while:������,do~while:������
		int n=10;
		//������ �ȸ����� �����ڵ� �������
		while(n>10)
		{
			System.out.println("hello");
		}
		
		//������ �ȸ¾Ƶ� �ϴ� �ѹ��� �����Ѵ�
		do {
			System.out.println("Hello 2");
		}while(n>10);
		
		n=0;
		while(n<=5)
		{
			System.out.println(++n);//6���� ���
		}
		
		n=0;
		do {
			System.out.println(++n);//6���� ���
		}while(n<=5);
	}

}

















