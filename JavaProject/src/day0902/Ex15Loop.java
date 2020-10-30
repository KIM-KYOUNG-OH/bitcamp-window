package day0902;

public class Ex15Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		while(true)
		{
			System.out.println(++n);
			if(n==5)
				break;//while문을 빠져나간다
		}
		System.out.println("** 종료 **");
		//A~Z까지를 출력해보자
		int a=65;
		while(true)
		{
			System.out.print((char)a++);
			//if(a>'Z')
			if(a>90)//위와 같은 조건
				break;			
		}
	}

}
