package day0902;

import java.util.Scanner;

public class Ex13Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//jdk8���ʹ� switch ���� ���ڿ��� ����
		String msg;
		System.out.println("����,����,������ �Ѵܾ �Է����ּ���");
		msg=sc.nextLine();
		switch(msg)
		{
		case "����":
			System.out.println("���� ���� ��!!!");
			break;
		case "����":
			System.out.println("���� ��� �߰�!!");
			break;
		case "����":
			System.out.println("���� �ϰ��� �����մϴ�");
			break;
		default:
			System.out.println("������ ���Ͻó���...");
		}
	}

}
