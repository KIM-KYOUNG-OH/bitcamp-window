package day0903;

public class Ex1Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ ���ϴ� ��� 2����
		//5���� ������ �߻�
		for(int i=1;i<=5;i++)
		{
			System.out.println(Math.random());//�Ǽ������� �߻�(0.0xxxxx~0.9xxxxx)
		}
		System.out.println();
		//0~9������ ���� �߻�
		for(int i=1;i<=5;i++)
		{
			System.out.println((int)(Math.random()*10));
		}
		System.out.println();
		//0~99������ ���� �߻�
		for(int i=1;i<=5;i++)
		{
			System.out.println((int)(Math.random()*100));
		}
		System.out.println();
		//1~10������ ���� �߻�
		for(int i=1;i<=5;i++)
		{
			System.out.println((int)(Math.random()*10)+1);
		}
		System.out.println();
		//A~Z ���� ���Ƿ� �߻�(65~90)
		for(int i=1;i<=5;i++)
		{
			System.out.println((char)((int)(Math.random()*26)+65));
		}
		
		//a~z ���� ���Ƿ� �߻�(97~122)
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			System.out.println((char)((int)(Math.random()*26)+97));
		}
	}
}

















