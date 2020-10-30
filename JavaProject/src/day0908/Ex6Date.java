package day0908;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex6Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("현재 날짜와 시간 출력하기");
		Date date=new Date();
		int y=date.getYear()+1900;
		int m=date.getMonth()+1;
		int d=date.getDate();
		
		int hh=date.getHours();
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		
		System.out.printf("오늘은 %d년 %d월 %d 일입니다\n",y,m,d);
		System.out.printf("현재 시간  %d : %d : %d\n",hh,mm,ss);
		
		//요일 출력
		int day=date.getDay();
		System.out.println("오늘은"+(day==0?"일":day==1?"월":day==2?"화":
			day==3?"수":day==4?"목":day==5?"금":"토")
				+"요일입니다");
		
		System.out.println("Format 클래스를 이용하여 날짜 출력하기");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd HH:mm EEE");
		SimpleDateFormat sdf5=new SimpleDateFormat("yyyy-MM-dd EEEE");
		SimpleDateFormat sdf6=new SimpleDateFormat("yyyy년 MM월 dd일 HH시mm분");
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		System.out.println(sdf5.format(date));	
		System.out.println(sdf6.format(date));
		System.out.println(date);
	}

}















