package day0907;

public class Ex15Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Sawon Ŭ������ ���� ���� �����(���� ��Ű����)
		/*
		 * Sawon Ŭ����-��� ��������� private
		 * �������  �̸�(name),����(age),������(blood),�޿�(pay),����(sudang)
		 */
		Sawon []arr=new Sawon[4];
		arr[0]=new Sawon();//�ʱⰪ�� ���� �˾Ƽ� �߱�
		arr[1]=new Sawon("�̼���",23,"B",340,5);
		arr[2]=new Sawon("��ȣ��",31,"A");//pay�� �⺻ 200,������ �⺻3���� �ʱⰪ�ֱ�
		arr[3]=new Sawon("����",23,"O",460,12);
		
		//����ϴµ�
		//pay+sudeng �� ��ȯ�ϴ� getTotal() �޼��� ������ ȣ���ϱ�
		//�̸�,����,������,�޿�,����,�ѱݾ� ������ ����ϴµ�
		//��� ��°��� getter �޼��� ȣ���Ͽ� ����ϱ�		
		System.out.println("�̸�\t����\t������\t�޿�\t����\t�ѱݾ�");
		for(Sawon s:arr)
		{
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getBlood()
			+"\t"+s.getPay()+"\t"+s.getSudang()+"\t"+s.getTotal());
		}
		
		System.out.println("�� �����ϱ�");
		arr[1].setAge(30);
		arr[2].setName("������");
		arr[3].setPay(410);
		arr[3].setSudang(8);
		
		System.out.println("**�ٽ� ����ϱ�**");
		System.out.println("�̸�\t����\t������\t�޿�\t����\t�ѱݾ�");
		for(Sawon s:arr)
		{
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getBlood()
			+"\t"+s.getPay()+"\t"+s.getSudang()+"\t"+s.getTotal());
		}
	}

}
