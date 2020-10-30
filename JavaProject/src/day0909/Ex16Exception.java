package day0909;

import java.util.Scanner;

public class Ex16Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		
		try {
			System.out.println("수1 입력");
			su1=Integer.parseInt(sc.nextLine());
			System.out.println("수2 입력");
			su2=Integer.parseInt(sc.nextLine());
			System.out.println(su1+"더하기"+su2+"는 "+(su1+su2)+"입니다");			
		}catch(NumberFormatException e)
		{
			System.out.println("입력시 문자가 섞여있네요:"+e.getMessage());
		}
		System.out.println("** 정상 종료 **");
	}

}
