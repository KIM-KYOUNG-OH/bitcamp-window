package day0909;

//interface �� final����� abstract �߻�޼ҵ�θ� ����
//�������� �޴��ǰ� ����(��ü�� ����)
interface InterA
{
	String MSG="Happy";//final ����
	public void showMessage();//abstract ����
}

class WorkA implements InterA
{
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println(MSG);
		//MSG="Hello";//����,����̹Ƿ� ���� �Ұ�
	}
}

class WorkB implements InterA
{
	String msg=MSG;
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("�ʱⰪ:"+msg);
		msg="Nice";
		System.out.println("����:"+msg);
	}
}


public class Ex6Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA a=new WorkA();
		a.showMessage();
		
		a=new WorkB();
		a.showMessage();
	}

}
