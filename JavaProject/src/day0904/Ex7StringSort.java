package day0904;

public class Ex7StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []datas= {"한은정","강호동","Candy","Milk","hello","남보라","강부자"};
		
		//오름차순 정렬
		for(int i=0;i<datas.length-1;i++)
		{
			for(int j=i+1;j<datas.length;j++)
			{
				//오름차순일땐 음수,거꾸로 내림차순일땐 양수
				int diff=datas[i].compareTo(datas[j]);
				if(diff>0)
				{
					String temp=datas[i];
					datas[i]=datas[j];
					datas[j]=temp;
				}
			}
		}
		
		//출력
		for(int i=0;i<datas.length;i++)
		{
			System.out.println(i+"=>"+datas[i]);
		}
	}

}
