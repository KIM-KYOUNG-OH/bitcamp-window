package day0909;

import java.util.Scanner;

public class Ex17Exception {

	//Exception �� ���� ó�������ʰ� throws �� ������ 
	//ȣ���ϴ������� ��������.
	//�̰�� ȣ���ϴ��ʿ��� ó���� �ؾ��Ѵ�(�ٽ� ������ try�� ó���� �Ѵ�)
	public static void dataAdd() throws NumberFormatException
	{
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		System.out.println("��1 �Է�");
		su1=Integer.parseInt(sc.nextLine());
		System.out.println("��2 �Է�");
		su2=Integer.parseInt(sc.nextLine());
		System.out.println(su1+"���ϱ�"+su2+"�� "+(su1+su2)+"�Դϴ�");	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dataAdd();
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
			System.out.println("���ڰ� �����ֳ׿�:"+e.getMessage());
		}
		System.out.println("** ���� ���� **");
	}

}
