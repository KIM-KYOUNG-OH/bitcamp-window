package day0902;

public class Ex23Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++)//행
		{
			for(int j=1;j<=5;j++)//열
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		//반복횟수를 변수를 이용해서 조절하기
		for(int i=1;i<=5;i++)//행
		{
			for(int j=1;j<=i;j++)//열
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1;i<=5;i++)//행
		{
			//for(int j=i;j<=5;j++)//열
			for(int j=5;j>=i;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

}





