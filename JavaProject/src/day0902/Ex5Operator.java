package day0902;

public class Ex5Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� ������
		int kor=98,eng=80,mat=90;
		System.out.println(kor>eng);//true
		System.out.println(kor==mat);//false
		System.out.println(kor>eng || eng==mat);//true,��ȸ�μ���,�տ� ������ true�� �� ������ ������ü�� ���Ѵ�
		System.out.println(eng==mat && eng<mat);//false
		System.out.println(!(eng==mat));//true
		System.out.println(eng!=mat);//true
	}

}
