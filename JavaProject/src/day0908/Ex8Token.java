package day0908;

import java.util.StringTokenizer;

public class Ex8Token {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ư�� ��ȣ�� ���ڿ��� �и��ϴ� ���
		//2����
		//1. split �޼���
		//2. StringTokenizer
		
		String msg="red,green,blue,gray,white,yellow";
		//���ڿ� msg �� , ��ȣ�� �и�
		StringTokenizer st=new StringTokenizer(msg, ",");
		int count=st.countTokens();//�и��Ҽ� �ִ� ��ū ���� ��ȯ
		System.out.println(count);
		while(st.hasMoreTokens())//���� ��ū�� ������� true
		{
			String token=st.nextToken();
			System.out.println(token);
		}
		
		System.out.println();
		String []data=msg.split(",");
		System.out.println(data.length);
		for(String d:data)
			System.out.println(d);
	}

}





