package day0901;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ΰ��� ���ڸ� args���ڷ� �޾Ƽ� ��Ģ������ ����غ���
		double su1=Double.parseDouble(args[0]);
		double su2=Double.parseDouble(args[1]);
		
		//3.5 2.1 �� ���ڿ� �־��ּ���
		System.out.println("���ϱ�:"+(su1+su2));
		System.out.println("����:"+(su1-su2));
		System.out.println("���ϱ�:"+(su1*su2));
		System.out.println("������:"+(su1/su2));		
	}

}
