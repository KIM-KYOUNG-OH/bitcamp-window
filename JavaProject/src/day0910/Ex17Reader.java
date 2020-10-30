package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex17Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg=null;
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		System.out.println("문자열 입력");
		try {
			msg=br.readLine();//한줄을 읽는다
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}

}
