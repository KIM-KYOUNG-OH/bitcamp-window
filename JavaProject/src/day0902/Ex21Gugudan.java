package day0902;

public class Ex21Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int dan=2;dan<=9;dan++)
		{
			System.out.println("** "+dan+"´Ü **");
			for(int i=1;i<=9;i++)
			{
				System.out.printf("%3d x %d = %2d\n",dan,i,dan*i);
			}
			System.out.println();
		}
	}

}
