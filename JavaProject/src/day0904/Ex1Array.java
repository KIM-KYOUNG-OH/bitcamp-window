package day0904;

import java.util.Scanner;

public class Ex1Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * �迭�� �پ��� �̸��� �������� ���� �Է��ϸ� �ش� ������ �����ϴ� ������� ����ϱ�
		 * �ش� ������ ������ "�ش� ������ �����ϴ�" ��� ���
		 * - startsWith ���ڿ� �޼��带 ����ϸ� ��
		 */
		Scanner sc=new Scanner(System.in);
		String []names= {"�̿���","��ȣ��","ȫ�浿","��ȣ��","�̿���","�ӿ���",
				"���ȣ","����Ŭ","ĳ����","ĵ��","�ȼҴ�","���̼�"};
		while(true)
		{
			int count=0;//�˻� �ο��� ���
			boolean find=false; //ã�Ѵ��� ��ã�Ҵ��� Ȯ�ο� ����
			String search;
			System.out.println("�˻��� ���� �Է����ּ���");
			search=sc.nextLine();
			
			//����
			if(search.equals("��") || search.equalsIgnoreCase("q"))
			{
				System.out.println("*** �����մϴ� ***");
				break;
			}
			
			for(int i=0;i<names.length;i++)
			{
				if(names[i].startsWith(search))//�ش� ������ �����ϸ� true
				{
					System.out.println(i+":"+names[i]);
					find=true;
					count++;
				}
			}
			
			if(find)
			{
				System.out.println("�� "+count+" ���� �˻��Ǿ����ϴ�");
			}else {
				System.out.println("�ش缺���� �����ϴ�");
			}
			System.out.println();
		}
	}

}












