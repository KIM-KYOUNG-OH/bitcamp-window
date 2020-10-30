package day0903;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Ex8Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열에 정수값을 초기값으로 넣은후 합게와 평균을 구해보자
		int []data= {5,8,12,23,9,19,67};
		int sum=0,sum2=0;
		double avg1,avg2;
		for(int i=0;i<data.length;i++)
		{
			sum+=data[i];
		}
		
		for(int n:data)
		{
			sum2+=n;
		}
		
		//평균
		avg1=(double)sum/data.length;
		avg2=(double)sum2/data.length;
		
		DecimalFormat df=new DecimalFormat("0.0");//소숫점이하 한자리 출력 양식 지정
		
		System.out.println("sum="+sum+",avg1="+avg1);
		System.out.println("sum2="+sum2+",avg2="+avg2);		
		System.out.println(df.format(avg1));
		System.out.println(df.format(avg2));		
	}
}





