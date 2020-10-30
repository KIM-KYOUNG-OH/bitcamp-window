package day0903;

public class Ex10Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {4,6,-1,-12,99,123,-100,900,5,11};
		System.out.println("총갯수:"+data.length);
		//배열에서 양수와 음수가 각각 몇개인지 출력하시오
		int pcnt=0,mcnt=0;
//		for(int d:data)
//		{
//			if(d>0)
//				pcnt++;
//			else if(d<0)
//				mcnt++;
//		}
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i]>0)
				pcnt++;
			else
				mcnt++;
		}
		
		System.out.println("양수의 갯수="+pcnt);
		System.out.println("음수의 갯수="+mcnt);
		
	}

}
