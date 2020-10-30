package day0902;

public class Ex18Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		for(;a<=10;a++)
			System.out.print(a+" ");
		System.out.println();
		for(int i=1;i<=10;i+=2)
			System.out.print(i+" ");
		System.out.println();
		for(int i=10;i>=1;i--)
			System.out.print(i+" ");
		System.out.println();
		//3의배수만 출력
		for(int i=1;i<=50;i++)
		{
			if(i%3==0)
				System.out.print(i+" ");
		}
		System.out.println();
		//3의배수와 5의 배수만 출력
		for(int i=1;i<=50;i++)
		{
			if(i%3==0 || i%5==0)
				System.out.print(i+" ");
		}
		System.out.println();
	}
}






