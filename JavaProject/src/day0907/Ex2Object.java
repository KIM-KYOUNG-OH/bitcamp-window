package day0907;

public class Ex2Object {
	//��� ����, ���
	int x=10;//�ν��Ͻ� ��� ����
	static int y=20;//Ŭ��������, ��������
	final String MSG1="Happy";//��� ����
	static final String MSG2="Nice";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static ��� �޼���� this��� �ν��Ͻ��� ������ ���� �ʴ�
		//�Ϲ� ��� �޼���� this��� �ν��Ͻ��� ������ �ֱ⶧����
		//this.x �̷������� ������ �����Ѱ��̴�(���� �̶� this�� ������ ����)
		
		//System.out.println(x);//���� �ȵ�
		System.out.println(Ex2Object.y);//static ���� ������ Ŭ������.����
		System.out.println(y);//Ŭ�������� ���� Ŭ������������ ���� ����
		
		//�ν��Ͻ� ��� ������ static �޼ҵ峻���� ȣ���ϰ� �ʹٸ�
		Ex2Object ob=new Ex2Object();
		System.out.println(ob.x);//�ν��Ͻ�����.������
		
		//������
		System.out.println(ob.MSG1);
		System.out.println(Ex2Object.MSG2);
		System.out.println(MSG2);
		
		//�� ���� �ȵ�
		//MSG2="Hello";//����
	}

}
