package day0903;

public class Ex10Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {4,6,-1,-12,99,123,-100,900,5,11};
		System.out.println("�Ѱ���:"+data.length);
		//�迭���� ����� ������ ���� ����� ����Ͻÿ�
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
		
		System.out.println("����� ����="+pcnt);
		System.out.println("������ ����="+mcnt);
		
	}

}
