package day0907;

import java.util.Scanner;

public class Ex7Object {

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
		
		//����Ÿ �Է�
		for(int i=0;i<cnt;i++)
		{
			//����
			shop[i]=new Shop();
			System.out.println("��ǰ��");
			//������ ���� ó��
			sc.nextLine();
			String sang=sc.nextLine();
			shop[i].setSang(sang);
			
			System.out.println("������ �ܰ��� �Է��ϼ���");
			int su=sc.nextInt();
			int dan=sc.nextInt();
			
			shop[i].setSu(su);
			shop[i].setDan(dan);
			System.out.println();
		}
				
		//���
		System.out.println("��ȣ\t��ǰ��\t����\t�ܰ�\t�ѱݾ�");
		for(int i=0;i<shop.length;i++)
		{
			System.out.println(i+1+"\t"+shop[i].getSang()+"\t"+shop[i].getSu()
					+"\t"+shop[i].getDan()+"\t"+shop[i].getTotal());
		}
	}

}















