package day0903;

import java.util.Scanner;

public class Ex14Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String msg;
		int []alpha=new int[26];//0������ a�ǰ��� 
		//�������� ������ �Է��� �ϸ� �м��� �ؼ� �� ���ĺ��� �ش��ϴ�
		//���ڼ��� ���
		//��¿�
		//Goooood HAve Nice Day!!!!
		//A:2  B:0  c:1......
		//O:5....Z:0
		//���ٿ� 5������ ���
		System.out.println("���� ������ �Է����ּ���");
		msg=sc.nextLine();
		for(int i=0;i<msg.length();i++)
		{
			char ch=msg.charAt(i);
			//�빮���ϰ��
			if(ch>='A' && ch<='Z')
			{
				alpha[ch-'A']++;
			}else if(ch>='a' && ch<='z')
			{
				alpha[ch-'a']++;
			}
		}

		//���
		for(int i=0;i<alpha.length;i++)
		{
			//System.out.print((char)(i+'A')+":"+alpha[i]+"\t");
			System.out.printf("%c : %d\t",(i+'A'),alpha[i]);
			if((i+1)%5==0)
				System.out.println();
		}
	}

}











