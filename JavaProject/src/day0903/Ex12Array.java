package day0903;

import java.util.Scanner;

public class Ex12Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []colors= {"Red","Green","Blue","Yellow","Pink","Gray",
				"Black"};
		//������ �Ʊ��ϰ� ���� ���
		//������ �Է��ϸ� 2��° �־��!!
		//�Ǵ� yellow �� ����� ..���...
		//q �Ǵ� Q �Ǵ� �� �ΰ�� ���� 
		//��,��ҹ��� ������� ã�ƾ���
		Scanner sc=new Scanner(System.in);
		String str;
		
		while(true)
		{
			System.out.println("���� �Է�");
			str=sc.nextLine();
			if(str.equalsIgnoreCase("q") || str.equals("��"))
			{
				System.out.println("** ���� **");
				break;
			}
			 
			boolean find=false;
			for(int i=0;i<colors.length;i++)
			{
				if(str.equalsIgnoreCase(colors[i]))
				{
					find=true;
					System.out.println(str+" ������ "+(i+1)+"��° �־��");
					break;
				}
			}
			
			if(!find)
				System.out.println(str+" ������ ����Ÿ�� �����");			
		}
	}

}













