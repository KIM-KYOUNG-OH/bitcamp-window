package day0901;

import java.util.Scanner;

public class Ex5Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		//����,���� ������ �Է��� �޾ƺ���		
		int age;
		String name;
		
		System.out.println("���̸� �Է��ϼ���");
		age=sc.nextInt();//���ڸ� �о��
		//Ű���� ������ ���͸� ���� �о ���ش�
		sc.nextLine();
		
		System.out.println("�̸��� �Է��ϼ���");
		name=sc.nextLine();
		
		System.out.println("name="+name);
		System.out.println("age="+age);
		
	}

}
