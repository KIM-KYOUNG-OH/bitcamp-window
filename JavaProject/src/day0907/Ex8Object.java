package day0907;

import java.util.Scanner;

public class Ex8Object {
	//데이타 입력
	public static void shopInput(Shop []shop)
	{
		Scanner sc=new Scanner(System.in);
		//데이타 입력
		for(int i=0;i<shop.length;i++)
		{
			//생성
			shop[i]=new Shop();
			System.out.println("상품명");
			String sang=sc.nextLine();
			shop[i].setSang(sang);

			System.out.println("수량과 단가를 입력하세요");
			int su=Integer.parseInt(sc.nextLine());
			int dan=Integer.parseInt(sc.nextLine());
			
			shop[i].setSu(su);
			shop[i].setDan(dan);
			System.out.println();
		}
	}

	//데이타 출력
	public static void shopOutput(Shop []shop)
	{
		//출력
		System.out.println("번호\t상품명\t수량\t단가\t총금액");
		for(int i=0;i<shop.length;i++)
		{
			System.out.println(i+1+"\t"+shop[i].getSang()+"\t"+shop[i].getSu()
					+"\t"+shop[i].getDan()+"\t"+shop[i].getTotal());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shop 에 저장할 갯수를 입력후 할당
		//상품정보를 키보드로 입력하여 출력하기
		Scanner sc=new Scanner(System.in);
		Shop []shop;
		int cnt;

		System.out.println("저장할 상품의 갯수를 입력하세요");
		cnt=sc.nextInt();
		//메모리할당
		shop=new Shop[cnt];
		
		shopInput(shop);
		shopOutput(shop);
	}

}
