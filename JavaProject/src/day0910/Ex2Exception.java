package day0910;

import java.util.Scanner;

public class Ex2Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		try {
			System.out.println("�ΰ��� ���ڸ� �Է��ϼ���");
			su1=Integer.parseInt(sc.nextLine());
			su2=Integer.parseInt(sc.nextLine());
			
			int div=su1/su2;
			System.out.printf("%d / %d = %d\n",su1,su2,div);
		}catch(NumberFormatException e)
		{
			System.out.println("�Է½� ���ڰ� �����־��:"+e.getMessage());
		}catch(ArithmeticException e)
		{
			System.out.println("�ι�° ���ڴ� 0�� �ƴѼ��� �Է��㼼��:"+e.getMessage());
		}finally {
			System.out.println("�̰��� ������ �����ϴ� �����Դϴ�");
		}
		System.out.println("** ���� ���� **");
	}

}








