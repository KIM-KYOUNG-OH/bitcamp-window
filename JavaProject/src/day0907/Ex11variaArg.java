package day0907;

public class Ex11variaArg {

	public static void sum(int...a)
	{
		System.out.println("���޹��� ����Ÿ�� ����:"+a.length);
		int s=0;
		for(int n:a)
		{	
			System.out.print(n+" ");
			s+=n;
		}
		System.out.println("\n�հ�:"+s);
		System.out.println();
	}
	
	public static void flower(String ...s)
	{
		String str="���� �����ϴ� ���� ";
		for(String a:s)
			str+=a+" ";
		str+="�Դϴ�";
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum(1,2);
		sum(3,5,7);
		sum(1,5,6,8,9);
		sum(33,41,23,15,67,54);
		
		//����غ�����
		//���� �����ϴ²��� .... �Դϴ�
		flower("��̲�");
		flower("�Ȱ���","����");
		flower("����","ĭ��","�پ˸���","�ĸ�����");
		
	}

}








