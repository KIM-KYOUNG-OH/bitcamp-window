package day0907;

public class Ex6Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1���� ��ǰ�� ����� ����ϱ�");
		Shop shop1=new Shop();
		shop1.setSang("���");
		shop1.setSu(3);
		shop1.setDan(1200);
		
		System.out.println("��ǰ:"+shop1.getSang());
		System.out.println("����:"+shop1.getSu());
		System.out.println("�ܰ�:"+shop1.getDan());
		System.out.println("�ѱݾ�:"+shop1.getTotal());
		
		System.out.println("�������� ��ǰ�� �迭�� �����ϱ�");
		Shop []shopData=new Shop[2];//��ü �迭-�޸� �Ҵ�
		//3���� �迭�� ������ �� ����
		shopData[0]=new Shop();//����
		shopData[1]=new Shop();
		
		shopData[0].setSang("������");
		shopData[0].setSu(5);
		shopData[0].setDan(3000);
		
		shopData[1].setSang("����");
		shopData[1].setSu(2);
		shopData[1].setDan(15000);
		
		//���
		for(int i=0;i<shopData.length;i++)
		{
			Shop s=shopData[i];
			System.out.println(s.getSang()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+s.getTotal());
		}
		System.out.println();
		for(Shop s:shopData)
		{
			System.out.println(s.getSang()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+s.getTotal());
		}
	}

}









