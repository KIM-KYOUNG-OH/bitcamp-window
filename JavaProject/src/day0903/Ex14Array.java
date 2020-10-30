package day0903;

import java.util.Scanner;

public class Ex14Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String msg;
		int []alpha=new int[26];//0번지에 a의갯수 
		//영문으로 문장을 입력을 하면 분석을 해서 각 알파벳에 해당하는
		//글자수를 출력
		//출력예
		//Goooood HAve Nice Day!!!!
		//A:2  B:0  c:1......
		//O:5....Z:0
		//한줄에 5개씩만 출력
		System.out.println("영문 문장을 입력해주세요");
		msg=sc.nextLine();
		for(int i=0;i<msg.length();i++)
		{
			char ch=msg.charAt(i);
			//대문자일경우
			if(ch>='A' && ch<='Z')
			{
				alpha[ch-'A']++;
			}else if(ch>='a' && ch<='z')
			{
				alpha[ch-'a']++;
			}
		}

		//출력
		for(int i=0;i<alpha.length;i++)
		{
			//System.out.print((char)(i+'A')+":"+alpha[i]+"\t");
			System.out.printf("%c : %d\t",(i+'A'),alpha[i]);
			if((i+1)%5==0)
				System.out.println();
		}
	}

}











