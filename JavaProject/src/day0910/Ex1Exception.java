package day0910;

import java.util.Date;

public class Ex1Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=null;
		try {
			System.out.println("���� �⵵�� "+(date.getYear()+1900)+"���Դϴ�");
		}catch(NullPointerException e)
		{
			System.out.println("��ü ������ ���ּ���:"+e.getMessage());
		}
		
		System.out.println("** ���� ���� **");
	}

}
