package day0910;

import java.io.IOException;
import java.io.InputStream;

public class Ex16Stream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in=System.in;
		System.out.println("문자열 입력후 ctrl+z");
		while(true)
		{
			int n=in.read();//1바이트씩 읽기,한글일경우 깨져서 나온다
			if(n==-1)
				break;
			System.out.print((char)n);
		}
		System.out.println();
		System.out.println("** 종료 **");
	}

}
