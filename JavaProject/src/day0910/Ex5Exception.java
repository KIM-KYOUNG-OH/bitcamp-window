package day0910;

public class Ex5Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�ȳ��ϼ���..3���Ŀ� ����");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�߰�����");
	}

}
