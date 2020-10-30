package day0908;

import java.util.StringTokenizer;

public class Ex8Token {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//특정 기호로 문자열을 분리하는 방법
		//2가지
		//1. split 메서드
		//2. StringTokenizer
		
		String msg="red,green,blue,gray,white,yellow";
		//문자열 msg 를 , 기호로 분리
		StringTokenizer st=new StringTokenizer(msg, ",");
		int count=st.countTokens();//분리할수 있는 토큰 갯수 반환
		System.out.println(count);
		while(st.hasMoreTokens())//남은 토큰이 있을경우 true
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





