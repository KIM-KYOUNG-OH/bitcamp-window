package day0907;

import java.util.Scanner;

public class Ex8Object {
	//����Ÿ �Է�
	public static void shopInput(Shop []shop)
	{
		Scanner sc=new Scanner(System.in);
		//����Ÿ �Է�
		for(int i=0;i<shop.length;i++)
		{
			//����
			shop[i]=new Shop();
			System.out.println("��ǰ��");
			String sang=sc.nextLine();
			shop[i].setSang(sang);

			System.out.println("������ �ܰ��� �Է��ϼ���");
			int su=Integer.parseInt(sc.nextLine());
			int dan=Integer.parseInt(sc.nextLine());
			
			shop[i].setSu(su);
			shop[i].setDan(dan);
			System.out.println();
		}
	}

	//����Ÿ ���
	public static void shopOutput(Shop []shop)
	{
		//���
		System.out.println("��ȣ\t��ǰ��\t����\t�ܰ�\t�ѱݾ�");
		for(int i=0;i<shop.length;i++)
		{
			System.out.println(i+1+"\t"+shop[i].getSang()+"\t"+shop[i].getSu()
					+"\t"+shop[i].getDan()+"\t"+shop[i].getTotal());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shop �� ������ ������ �Է��� �Ҵ�
		//��ǰ������ Ű����� �Է��Ͽ� ����ϱ�
		Scanner sc=new Scanner(System.in);
		Shop []shop;
		int cnt;

		System.out.println("������ ��ǰ�� ������ �Է��ϼ���");
		cnt=sc.nextInt();
		//�޸��Ҵ�
		shop=new Shop[cnt];
		
		shopInput(shop);
		shopOutput(shop);
	}

}
