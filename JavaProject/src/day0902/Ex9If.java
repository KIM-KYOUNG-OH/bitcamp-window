package day0902;

import java.util.Scanner;

public class Ex9If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//������ �Է��� ������ ���Ͻÿ�
		//90�̻��̸� 'A',80�̻��̸� 'b',...60 �̸��� 'F'
		//����� (��) 78 ���� C�����Դϴ�
		int score;
		char grade;
		System.out.println("������ �Է����ּ���");
		score=sc.nextInt();
		//if
		if(score>=90) 
			grade='A';
		else if(score>=80) grade='B';
		else if(score>=70) grade='C';
		else if(score>=60) grade='D';
		else grade='F';
		System.out.println(score+"���� "+grade+" �����Դϴ�");			
		
		//switch
		switch(score/10)
		{
		case 10:
		case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
		default:
			grade='F';
		}
		System.out.println(score+"���� "+grade+" �����Դϴ�");	
	}

}













