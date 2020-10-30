package day0908;

public class Ex5StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문자열에 편집기능이 추가된 클래스
		StringBuffer sb=new StringBuffer();
		sb.append("Happy");
		sb.append(123);
		sb.append("& Nice");
		System.out.println(sb);
		
		String str="Happy Day";
		StringBuffer sb2=new StringBuffer(str);
		System.out.println(sb2);
		sb2.insert(6, "Good");//6번 인덱스에 Good 삽입
		System.out.println(sb2);
		sb2.delete(1, 4);//1~3번 인덱스부분 삭제
		System.out.println(sb2);
		
		str=sb2.toString();//StringBuffer->String
		System.out.println(str);
	}

}
