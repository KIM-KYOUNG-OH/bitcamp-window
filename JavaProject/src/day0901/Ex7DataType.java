package day0901;

public class Ex7DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ ���� 4����
		//ũ�⿡ ���� byte(1),short(2),int(4),long(8)
		byte a=127;
		byte b=(byte) 200;//(Ÿ��) ����������
		
		System.out.println("a="+a);
		System.out.println("b="+b);//������ ����ȯ�Ұ�쿡�� ���ս��� �߻��Ҽ� �ִ�
		
		float f1=8.123456789f;//���е� 7
		double f2=8.123456789;//���е� 15
		System.out.println(f1);
		System.out.println(f2);
		
		//��¸޼���
		//printf : jdk5 ���� �߰�, ��ȯ��ȣ�� �̿��ؼ� ���
		//����:%d,�Ǽ�:%f,1����:%c,���ڿ�%s
		System.out.printf("%d,%d,%f,%f\n",a,b,f1,f2);
		//�Ǽ���������� �Ҽ��� ���� �ڸ��� ����
		System.out.printf("%10.1f\n%10.2f\n%10.3f\n",f2,f2,f2);
	}

}








