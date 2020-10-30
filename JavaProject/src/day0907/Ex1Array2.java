package day0907;

import java.util.Scanner;

public class Ex1Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 3행3열로 2차원 배열을 생성후에 1~3 사이의 난수를 임의로 저장후
		 * 가로,세로,대각선으로 같은 숫자가 있으면 그 갯수를 출력, 없으면 꽝 출력		 * 
		 */
		int [][]arr=new int[3][3];
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			//1~3 사이의 난수 발생
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					arr[i][j]=(int)(Math.random()*3)+1;//1~3사이 난수 발생
				}
			}
			
			//출력
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					System.out.print(arr[i][j]+"\t");
				}
				System.out.println();
			}
			
			//가로방향,새로방향, 대각선을 비교하여 같은 값이 나오면 binggo 변수 1증가
			int binggo=0;
			//가로,세로방향
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2])//가로방행
					binggo++;
				if(arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i])//세로방행
					binggo++;
			}
			//   / 대각선
			if(arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0])
				binggo++;
			//   \ 대각선
			if(arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2])
				binggo++;
			
			if(binggo>0)
				System.out.println("빙고 "+binggo+"개");
			else
				System.out.println("꽝!!!!!!");
			
			//q를 누르면 종료
			System.out.println("종료하려면 q 또는 Q 를 눌러주세요");
			String ans=sc.nextLine();
			if(ans.equalsIgnoreCase("q"))
			{
				System.out.println("종료합니다");
				break;
			}
		}
	}

}
