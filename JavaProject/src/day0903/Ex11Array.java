package day0903;

import java.util.Scanner;

public class Ex11Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {3,7,11,1,6,8,9,15,17,20};
		System.out.println(data.length);
		//while반복문 사용
		//숫자를 입력하여 몇번째 있는지 출력하기
		//없을경우 "없습니다" 출력
		//0 입력하면 "종료" 출력하고 종료
		int su;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("검색할 숫자를 입력하세요");
			su=sc.nextInt();
			if(su==0)
			{
				System.out.println("** 종료 **");
				break;
			}
			
			boolean find=false;//찾을경우 true로 변환
			for(int i=0;i<data.length;i++)
			{
				if(su==data[i])
				{
					find=true;
					System.out.println(i+1+"번째에 있어요!!!");
					break;
				}
			}
			
			//if(find==false)
			if(!find)
				System.out.println(su+" 수는 없습니다");
			System.out.println();
		}
		
	}

}

















