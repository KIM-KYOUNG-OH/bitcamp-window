package day0903;

import java.util.Scanner;

public class Ex12Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []colors= {"Red","Green","Blue","Yellow","Pink","Gray",
				"Black"};
		//로직은 아까하고 같은 방식
		//색상을 입력하면 2번째 있어요!!
		//또는 yellow 는 없어요 ..등등...
		//q 또는 Q 또는 끝 인경우 종료 
		//단,대소문자 상관없이 찾아야함
		Scanner sc=new Scanner(System.in);
		String str;
		
		while(true)
		{
			System.out.println("색상 입력");
			str=sc.nextLine();
			if(str.equalsIgnoreCase("q") || str.equals("끝"))
			{
				System.out.println("** 종료 **");
				break;
			}
			 
			boolean find=false;
			for(int i=0;i<colors.length;i++)
			{
				if(str.equalsIgnoreCase(colors[i]))
				{
					find=true;
					System.out.println(str+" 색상은 "+(i+1)+"번째 있어요");
					break;
				}
			}
			
			if(!find)
				System.out.println(str+" 색상은 데이타에 없어요");			
		}
	}

}













