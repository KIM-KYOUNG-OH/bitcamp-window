package day0910;

import java.util.Scanner;

public class Ex2Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		try {
			System.out.println("두개의 숫자를 입력하세요");
			su1=Integer.parseInt(sc.nextLine());
			su2=Integer.parseInt(sc.nextLine());
			
			int div=su1/su2;
			System.out.printf("%d / %d = %d\n",su1,su2,div);
		}catch(NumberFormatException e)
		{
			System.out.println("입력시 문자가 섞여있어요:"+e.getMessage());
		}catch(ArithmeticException e)
		{
			System.out.println("두번째 숫자는 0이 아닌수를 입력허세요:"+e.getMessage());
		}finally {
			System.out.println("이곳은 무조건 실행하는 영역입니다");
		}
		System.out.println("** 정상 종료 **");
	}

}








