package day0902;

public class Ex16Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		//1���� 20���� ¦���� ����϶�
		while(true)
		{
			n++;
			if(n%2==1)//Ȧ���ΰ��
				continue;//�Ʒ��� ����� �������� �ʰ� �ٽ� �������� ���ư���
			System.out.printf("%3d",n);
			//���� �ڵ�
			if(n==20)
				break;
		}
		System.out.println();//���ٶ��
		System.out.println("** ���� **");
	}
}
