package day0907;

//���� Ŭ����
//public �� ���ϼ� ����
//���� ��Ű���������� ������ ����(������ �޶� �������)
class Apple
{
	int score=100;
	final static String MESSAGE="Have a Nice Day!!!";
}

//public ���������ڴ� ���ϸ�� ���� Ŭ���� �տ��� ���ϼ� �ִ�
//public �� ���� Ŭ������ �ٸ� ��Ű�������� ������ �����ϴ�
public class Ex3Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Apple ũ������ score�� MESSAGE ����� ����غ�����
		Apple app=new Apple();
		System.out.println(app.score);
		System.out.println(Apple.MESSAGE);
		
		Apple app2=new Apple();
		app2.score=90;
		System.out.println(app2.score);
		System.out.println(Apple.MESSAGE);
	}

}
