package day0903;

import java.util.Random;

public class Ex2Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();

		//0~9 ������ ����
		for(int i=1;i<=5;i++)
		{
			System.out.println(r.nextInt(10));
		}
		System.out.println();

		//0~99 ������ ����
		for(int i=1;i<=5;i++)
		{
			System.out.println(r.nextInt(100));
		}
		System.out.println();

		//1~10 ������ ����
		for(int i=1;i<=5;i++)
		{
			System.out.println(r.nextInt(10)+1);
		}
		System.out.println();
		//A~Z ������ ����
		for(int i=1;i<=5;i++)
		{
			//System.out.printf("%3c",r.nextInt(26)+65);
			System.out.println((char)(r.nextInt(26)+65));
		}
		
	}

}
