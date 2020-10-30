package day0910;

import java.util.Date;

public class Ex1Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=null;
		try {
			System.out.println("현재 년도는 "+(date.getYear()+1900)+"년입니다");
		}catch(NullPointerException e)
		{
			System.out.println("객체 생성을 해주세요:"+e.getMessage());
		}
		
		System.out.println("** 정상 종료 **");
	}

}
