package day0903;

public class Ex1Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//난수를 구하는 방법 2가지
		//5개의 난수를 발생
		for(int i=1;i<=5;i++)
		{
			System.out.println(Math.random());//실수형으로 발생(0.0xxxxx~0.9xxxxx)
		}
		System.out.println();
		//0~9까지의 난수 발생
		for(int i=1;i<=5;i++)
		{
			System.out.println((int)(Math.random()*10));
		}
		System.out.println();
		//0~99까지의 난수 발생
		for(int i=1;i<=5;i++)
		{
			System.out.println((int)(Math.random()*100));
		}
		System.out.println();
		//1~10까지의 난수 발생
		for(int i=1;i<=5;i++)
		{
			System.out.println((int)(Math.random()*10)+1);
		}
		System.out.println();
		//A~Z 까지 임의로 발생(65~90)
		for(int i=1;i<=5;i++)
		{
			System.out.println((char)((int)(Math.random()*26)+65));
		}
		
		//a~z 까지 임의로 발생(97~122)
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			System.out.println((char)((int)(Math.random()*26)+97));
		}
	}
}

















