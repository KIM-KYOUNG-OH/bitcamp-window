package day0909;

import java.util.Scanner;

public class Ex16Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		
		try {
			System.out.println("��1 �Է�");
			su1=Integer.parseInt(sc.nextLine());
			System.out.println("��2 �Է�");
			su2=Integer.parseInt(sc.nextLine());
			System.out.println(su1+"���ϱ�"+su2+"�� "+(su1+su2)+"�Դϴ�");			
		}catch(NumberFormatException e)
		{
			System.out.println("�Է½� ���ڰ� �����ֳ׿�:"+e.getMessage());
		}
		System.out.println("** ���� ���� **");
	}

}
