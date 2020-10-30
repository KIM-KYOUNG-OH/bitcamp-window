package day0902;

import java.util.Scanner;

public class Ex1Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//산술 연산자 +,-,*,/,%
		//두수를 입력한후에 산술연산자로 계산 결과를 출력
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		System.out.println("두수를 입력해주세요");
		su1=sc.nextInt();
		su2=sc.nextInt();
		
		System.out.printf("%20s\n\n","*계산결과*");
		System.out.printf("%d+%d=%d\n",su1,su2,su1+su2);
		System.out.printf("%d-%d=%d\n",su1,su2,su1-su2);
		System.out.printf("%d*%d=%d\n",su1,su2,su1*su2);
		System.out.printf("%d%%%d=%d\n",su1,su2,su1%su2);
		System.out.printf("%d/%d=%.1f\n",su1,su2,(double)su1/su2);		
	}

}
