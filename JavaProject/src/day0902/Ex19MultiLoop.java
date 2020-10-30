package day0902;

public class Ex19MultiLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다중 for문
		for(int i=1;i<=3;i++)
		{
			System.out.println("Hello");
			for(int j=1;j<=4;j++)
			{
				System.out.println("\tKitty");
			}
		}
		System.out.println();
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.println("i="+i+",j="+j);
				if(j==2)
					break;//j가 2면 현재 for문을 빠져나온다
			}
			System.out.println("-------");
		}
		
		System.out.println();
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(j==2)
					continue;//아래 명령을 실행하지 않고 j++ 로 이동
				System.out.println("i="+i+",j="+j);				
			}
			System.out.println("-------");
		}
	}

}

















