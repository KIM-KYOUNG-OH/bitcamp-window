package day0909;

public class Ex15Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {3,2,5,6};
		for(int i=0;i<=data.length;i++)
		{
			try {
				System.out.println(data[i]);
				System.out.println("--------");
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				//������ ���� ���ι�ȣ�� �����ϰ������
				e.printStackTrace();
				System.out.println("�迭���� ����:"+e.getMessage());
			}
		}
		System.out.println("** ���� **");
	}

}
