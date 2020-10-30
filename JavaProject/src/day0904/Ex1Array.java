package day0904;

import java.util.Scanner;

public class Ex1Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 배열에 다양한 이름을 저장한후 성을 입력하면 해당 성으로 시작하는 사람들을 출력하기
		 * 해당 성씨가 없으면 "해당 성씨는 없습니다" 라고 출력
		 * - startsWith 문자열 메서드를 사용하면 됨
		 */
		Scanner sc=new Scanner(System.in);
		String []names= {"이영자","강호동","홍길동","강호남","이영미","임영웅",
				"장민호","마이클","캐서린","캔디","안소니","마이선"};
		while(true)
		{
			int count=0;//검색 인원수 계산
			boolean find=false; //찾앗는지 못찾았는지 확인용 변수
			String search;
			System.out.println("검색할 성을 입력해주세요");
			search=sc.nextLine();
			
			//종료
			if(search.equals("끝") || search.equalsIgnoreCase("q"))
			{
				System.out.println("*** 종료합니다 ***");
				break;
			}
			
			for(int i=0;i<names.length;i++)
			{
				if(names[i].startsWith(search))//해당 성으로 시작하면 true
				{
					System.out.println(i+":"+names[i]);
					find=true;
					count++;
				}
			}
			
			if(find)
			{
				System.out.println("총 "+count+" 명이 검색되었습니다");
			}else {
				System.out.println("해당성씨는 없습니다");
			}
			System.out.println();
		}
	}

}












