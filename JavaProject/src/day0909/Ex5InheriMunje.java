package day0909;

import java.util.Scanner;

abstract class Board
{
	abstract public void process(); 
}

class InsertBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 데이타를 추가한다");
	}
}

class ListBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 데이타를 출력한다");
	}
}

class UpdateBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 데이타를 수정한다");
	}
}

class DeleteBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("게시판에 데이타를 삭제한다");
	}
}

public class Ex5InheriMunje {
	public static void process(Board b)
	{
		b.process();//다형성처리
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1. 추가  2.삭제  3.수정  4.목록출력  5.종료");
			System.out.println("선택하세요");
			int num=sc.nextInt();
			if(num>4)
			{
				System.out.println("** 종료합니다 **");
				break;
			}
			
			switch(num)
			{
			case 1:
				process(new InsertBoard());
				break;
			case 2:
				process(new DeleteBoard());
				break;
			case 3:
				process(new UpdateBoard());
				break;
			case 4:
				process(new ListBoard());				
			}
		}
	}

}



























