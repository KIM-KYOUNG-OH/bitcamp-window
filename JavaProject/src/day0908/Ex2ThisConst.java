package day0908;

class Apple
{
	String msg;
	int num;
	double num2;
	
	Apple()
	{
		this("test",5,2.7);//인자가 같은 생성자가 호출,반드시 첫줄
//		msg="test";
//		num=5;
//		num2=2.7;
	}

	Apple(String msg)
	{
		this(msg,10,4.5);
//		this.msg=msg;
//		num=10;
//		num2=4.5;
	}
	
	Apple(String msg,int num,double num2)
	{
		this.msg=msg;
		this.num=num;
		this.num2=num2;
	}
	
	@Override
	public String toString() {
		return "Apple [msg=" + msg + ", num=" + num + ", num2=" + num2 + "]";
	}	
}

public class Ex2ThisConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1=new Apple();
		Apple a2=new Apple("happy");
		Apple a3=new Apple("java", 90, 3.9);
		
		System.out.println(a1);//자동으로 toString 메서드 호출
		System.out.println(a2);
		System.out.println(a3);
		//System.out.println(a1.toString());//위의 코드와 같은 결과
	}

}









