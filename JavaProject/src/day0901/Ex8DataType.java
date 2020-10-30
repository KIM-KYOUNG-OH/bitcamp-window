package day0901;

import java.util.Scanner;

public class Ex8DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sang;
		int su,dan;
		
		System.out.println("상품명 입력");
		sang=sc.nextLine();
		
		System.out.println("수량 입력");
		su=sc.nextInt();
		
		System.out.println("단가 입력");
		dan=sc.nextInt();
		
		//printf를 이용해서 전체를 출력해보자
		System.out.printf("%30s\n\n","**구입상품**");//우측정렬
		System.out.printf("%-30s\n\n","**구입상품**");//왼쪽정렬
		System.out.printf("상품명 : %s\n",sang);
		System.out.printf("수량 : %d\n",su);
		System.out.printf("단가 : %d\n",dan);
		System.out.printf("총금액 : %d\n",su*dan);		
	}

}








