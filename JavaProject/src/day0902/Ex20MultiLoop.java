package day0902;

public class Ex20MultiLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loop1:
			for(int i=1;i<=3;i++)
			{
				for(int j=1;j<=5;j++)
				{
					System.out.println("i="+i+",j="+j);
					if(j==3)
						break Loop1;//������ ������ �ٱ��� for���� �������´�
				}
			}
	  System.out.println();
	  Loop2:
		  for(int i=1;i<=3;i++)
			{
				for(int j=1;j<=5;j++)
				{
					if(j==3)
						continue Loop2;//�ϴ��۾��� �ߴ��ϰ� i++�� �̵��Ѵ�
					System.out.println("i="+i+",j="+j);					
				}
			} 
	  
	}

}
