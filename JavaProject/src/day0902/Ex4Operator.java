package day0902;

public class Ex4Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������� ++,--
		//�����ϰ��� �տ� �Ǵ� �ڿ� ��� �ٴ� �������
		//������ �ƴҰ��� ��ġ�ϰ��� 1����, ��ġ�ϰ��� ������
		int a=5,b=5;
		++a;//��ġ a=a+1
		b++;//��ġ b=b+1
		System.out.println(a+","+b);//6,6
		//��½� ���� ������ ���
		System.out.println(++a);//7,�����ϰ� ���
		System.out.println(b++);//6, ����ϰ� ����
		
		System.out.println(a+","+b);//7,7
		
		int m,n;
		m=n=6;
		a=b=5;
		a+=m++ - --b;//--,+=,++
		System.out.printf("%d,%d,%d\n",a,b,m);//7,4,7
		m=n=a=b=3;
		m=++a;//���� ������ ����
		n=b++;//���� ������ ����
		System.out.printf("%d,%d,%d,%d\n",a,b,m,n);//4,4,4,3
		
	}

}







