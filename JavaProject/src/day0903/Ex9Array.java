package day0903;

public class Ex9Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {4,6,1,12,99,123,-100,900,5,11};
		//�ִ밪�� �ּҰ��� ���غ���
		//�ϴ� �ִ밪�� �ּҰ����� ù��° ����Ÿ�� �־����
		int max=data[0];
		int min=data[0];
		
		//�ι�°���� �ݺ����� ������ ��ū���� �����ų�
		//�� �������� ������ �ִ밪�̳� �ּҰ��� ����
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i])
				max=data[i];
			if(min>data[i])
				min=data[i];
		}
		System.out.println("max="+max);
		System.out.println("min="+min);
	}

}
