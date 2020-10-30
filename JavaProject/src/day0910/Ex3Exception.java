package day0910;

import java.util.Scanner;

public class Ex3Exception {

	public static void process() throws NumberFormatException,ArithmeticException
	{
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		System.out.println("두개의 숫자를 입력하세요");
		su1=Integer.parseInt(sc.nextLine());
		su2=Integer.parseInt(sc.nextLine());
		
		int div=su1/su2;
		System.out.printf("%d / %d = %d\n",su1,su2,div);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			process();
		}catch(ArithmeticException e)
		{
			System.out.println("0으로 나누면 안돼요:"+e.getMessage());
		}catch(NumberFormatException e)
		{
			System.out.println("문자가 들어있어요:"+e.getMessage());
		}finally {
			System.out.println("무조건 실행");
		}
		
		System.out.println("** 정상 종료 **");
	}

}









