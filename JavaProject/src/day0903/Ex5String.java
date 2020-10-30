package day0903;

public class Ex5String {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String 객체 생성
		String s1=new String("apple");
		String s2="Apple";
		String msg="Have a Nice Day!!";
		String msg2="   Happy day   ";
		System.out.println("length="+msg.length());
		System.out.println("length="+msg2.length());
		System.out.println("length="+msg2.trim().length());//양쪽 공백 제거후 길이
		System.out.println(msg.charAt(7));//N,0부터계산
		System.out.println(msg.indexOf('a'));//a 의 위치
		System.out.println(msg.indexOf('a',4));//4번지부터 검색시 a 의 위치
		System.out.println(s1.toUpperCase());//모두 대문자로 변환
		System.out.println(s1.toLowerCase());//모두 소문자로 변환
		System.out.println(s1.concat("Orange"));//기존 문자열에 Orange 추가해서 반환
		System.out.println(msg.endsWith("Day!!"));//해당문자열로 끝나면 true
		System.out.println(msg.endsWith("Day!!!"));//false
		System.out.println(msg.startsWith("Have"));//해당 문자열로 시작하면 true
		System.out.println(msg.startsWith("Haha"));//false
		System.out.println(msg.replace("a", "*"));//모든 a가*로 변경되서 반환 
		System.out.println(msg.substring(7));//7번 인덱스부터 끝까지 추출
		System.out.println(msg.substring(7,10));//7~9번까지 추출
		
		//비교
		System.out.println(s1==s2);//객체에서의 == 는 주소 비교를 의미
		System.out.println(s1.equals(s2));//값을 비교-대소문자까지 같아야 true
		System.out.println(s1.equalsIgnoreCase(s2));//대소문자 상관없이 비교
		System.out.println(s1.equals("apple"));//true
		
		//같을경우 0
		//a가 b보다 크면 양수값
		System.out.println(s1.compareTo("apple"));//0
		System.out.println(s1.compareTo("Apple"));//32..apple(a가 97)-Apple(A가 65)
		System.out.println(s1.compareTo("Banana"));//31
		System.out.println(s1.compareTo("application"));//-4  (apple-application)-e(101)-i(105) 로 비교
		System.out.println("Orange".compareTo("Purple"));//-1	
		
		//split - 특정 문자로 분리(배열형태)
		String s="red,green,blue,yellow";
		//, 로 분리
		String []arr=s.split(",");
		for(String a:arr)
		{
			System.out.println(a);
		}
		
		//valueOf : 어떤 데이타든 문자열로 변환해서 반환
		String a1=String.valueOf('A');
		String a2=String.valueOf(1234);		
	}

}









