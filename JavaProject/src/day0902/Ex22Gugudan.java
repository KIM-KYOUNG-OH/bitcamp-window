package day0902;

public class Ex22Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int dan=2;dan<=9;dan++)
		{
			System.out.printf("%9d´Ü",dan);
		}
		System.out.println();
		for(int i=1;i<=9;i++)		
		{
			for(int dan=2;dan<=9;dan++)
			{
				System.out.printf("%6dx%d=%2d",dan,i,dan*i);
			}
			System.out.println();
		}
	}

}
