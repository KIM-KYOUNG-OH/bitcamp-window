package day0910;

import java.util.Scanner;

public class Ex3Exception {

	public static void process() throws NumberFormatException,ArithmeticException
	{
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		System.out.println("�ΰ��� ���ڸ� �Է��ϼ���");
		su1=Integer.parseInt(sc.nextLine());
		su2=Integer.parseInt(sc.nextLine());
		
		int div=su1/su2;
		System.out.printf("%d / %d = %d\n",su1,su2,div);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			process();
		}catch(ArithmeticException e)
		{
			System.out.println("0���� ������ �ȵſ�:"+e.getMessage());
		}catch(NumberFormatException e)
		{
			System.out.println("���ڰ� ����־��:"+e.getMessage());
		}finally {
			System.out.println("������ ����");
		}
		
		System.out.println("** ���� ���� **");
	}

}









