package day0910;

import java.util.Scanner;

//����� �̼���
//throw �� �̿��ؼ� ������ �̼����� �߻���Ų��.
class UserException extends Exception
{
	public UserException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
//�̸��� ���̸� �Է¹޴µ�
//�̸��� "������" �� �Է��ϸ� �̼��� �߻�
//���̴� 50���� ������ �̼��� �߻�

public class Ex6UserException {
	public static void dataInput() throws UserException
	{
		Scanner sc=new Scanner(System.in);
		String name;
		int age;
		System.out.println("�̸��� �Է��ϼ���");
		name=sc.nextLine();
		if(name.equals("������"))
			throw new UserException("��Ȯ�� �̸��� �Է��ϼ���");
		System.out.println("���� �Է�");
		age=sc.nextInt();
		if(age>=50)
			throw new UserException("���̰� �ʹ� ���ƿ�!!");
		System.out.println(name+" ���� ���̴� "+age+"���Դϴ�");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dataInput();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println("�����޼���:"+e.getMessage());
		}
		System.out.println("** ���� ���� **");
	}

}











