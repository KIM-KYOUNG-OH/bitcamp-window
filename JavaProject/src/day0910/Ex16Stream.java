package day0910;

import java.io.IOException;
import java.io.InputStream;

public class Ex16Stream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in=System.in;
		System.out.println("���ڿ� �Է��� ctrl+z");
		while(true)
		{
			int n=in.read();//1����Ʈ�� �б�,�ѱ��ϰ�� ������ ���´�
			if(n==-1)
				break;
			System.out.print((char)n);
		}
		System.out.println();
		System.out.println("** ���� **");
	}

}
