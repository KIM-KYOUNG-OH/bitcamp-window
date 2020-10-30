package day0907;

public class Ex11variaArg {

	public static void sum(int...a)
	{
		System.out.println("전달받은 데이타의 갯수:"+a.length);
		int s=0;
		for(int n:a)
		{	
			System.out.print(n+" ");
			s+=n;
		}
		System.out.println("\n합계:"+s);
		System.out.println();
	}
	
	public static void flower(String ...s)
	{
		String str="내가 좋아하는 꽃은 ";
		for(String a:s)
			str+=a+" ";
		str+="입니다";
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum(1,2);
		sum(3,5,7);
		sum(1,5,6,8,9);
		sum(33,41,23,15,67,54);
		
		//출력해보세요
		//내가 좋아하는꽃은 .... 입니다
		flower("장미꽃");
		flower("안개꽃","백합");
		flower("벚꽃","칸나","다알리아","후리지아");
		
	}

}








