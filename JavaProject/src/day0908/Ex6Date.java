package day0908;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex6Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���� ��¥�� �ð� ����ϱ�");
		Date date=new Date();
		int y=date.getYear()+1900;
		int m=date.getMonth()+1;
		int d=date.getDate();
		
		int hh=date.getHours();
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		
		System.out.printf("������ %d�� %d�� %d ���Դϴ�\n",y,m,d);
		System.out.printf("���� �ð�  %d : %d : %d\n",hh,mm,ss);
		
		//���� ���
		int day=date.getDay();
		System.out.println("������"+(day==0?"��":day==1?"��":day==2?"ȭ":
			day==3?"��":day==4?"��":day==5?"��":"��")
				+"�����Դϴ�");
		
		System.out.println("Format Ŭ������ �̿��Ͽ� ��¥ ����ϱ�");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		SimpleDateFormat sdf4=new SimpleDateFormat("yyyy-MM-dd HH:mm EEE");
		SimpleDateFormat sdf5=new SimpleDateFormat("yyyy-MM-dd EEEE");
		SimpleDateFormat sdf6=new SimpleDateFormat("yyyy�� MM�� dd�� HH��mm��");
		
		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		System.out.println(sdf5.format(date));	
		System.out.println(sdf6.format(date));
		System.out.println(date);
	}

}















