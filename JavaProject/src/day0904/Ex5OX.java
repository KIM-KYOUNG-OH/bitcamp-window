package day0904;

import java.util.Scanner;

public class Ex5OX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String jungdap="12134";
		String dap;
		char []ox=new char[5];
		int count=0;

		System.out.println("����5���� �Է����ּ���");
		dap=sc.nextLine();

		//���� �ϳ� �� �߰�(������ ������� "������ �ȵſ�" �޼����� ����
		//��Ʈ : indexOf, ������ �ƽ�Ű�ڵ尪�� 32(���ڷ� �ص��ǰ� 32 �������� �ᵵ ��)
		if(dap.indexOf(32)>=0)
		{
			System.out.println("������ �ȵſ�");
			return;
		}
		if(dap.length()!=5)
		{
			System.out.println("����5���� �Է��ϼ���");
			return; //main �Լ� ����			
		}
		
		//��
		for(int i=0;i<dap.length();i++)
		{
			char d=dap.charAt(i);
			char jd=jungdap.charAt(i);
			if(d==jd)
			{
				ox[i]='O';
				count++;
			}else {
				ox[i]='X';
			}
		}

		//���
		System.out.println("���� : "+jungdap);
		System.out.println("  �� : "+dap);
		//char[] �� String ��ȯ
		//String strox=String.valueOf(ox);
		//System.out.println("ä�� : "+strox);
		
		//char �迭 ���·� ����Ϸ���
		System.out.print("ä�� : ");
		for(char a:ox)
			System.out.print(a);
		System.out.println();
		System.out.println("���� :"+count+"��");		
		
		System.out.println("** ���� ���� **");
	}

}










