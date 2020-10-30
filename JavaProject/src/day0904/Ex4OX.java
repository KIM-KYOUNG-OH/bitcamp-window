package day0904;

import java.util.Scanner;

public class Ex4OX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*정답과 비교하여 ox출력하기
		 *  정답  1 4 2 3 1
		 *   답   1 2 2 4 3
		 *  채점  O X O X X
		 *    정답  2개
		 */
		Scanner sc=new Scanner(System.in);
		int []jungdap= {1,4,2,3,1};
		int []dap=new int[5];
		char []ox=new char[5];
		int count=0;
		
		//답 입력
		System.out.println("답 5개를 입력해주세요(4지선다)");
		for(int i=0;i<dap.length;i++)
		{
			dap[i]=sc.nextInt();
		}
		
		//정답 출력
		System.out.print("정답 : ");
		for(int j:jungdap)
			System.out.print(j+" ");
		System.out.println();
		System.out.print("  답 : ");
		for(int d:dap)
			System.out.print(d+" ");
		System.out.println();
		
		//채점
		for(int i=0;i<ox.length;i++)
		{
			if(jungdap[i]==dap[i])
			{
				ox[i]='O';
				count++;//정답갯수 증가
			}else
				ox[i]='X';			
		}
		
		System.out.print("채점 : ");
		for(char ch:ox)
			System.out.print(ch+" ");
		System.out.println();
		System.out.println("정답 : "+count+"개");
	}

}














