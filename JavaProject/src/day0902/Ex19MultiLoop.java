package day0902;

public class Ex19MultiLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� for��
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
					break;//j�� 2�� ���� for���� �������´�
			}
			System.out.println("-------");
		}
		
		System.out.println();
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(j==2)
					continue;//�Ʒ� ����� �������� �ʰ� j++ �� �̵�
				System.out.println("i="+i+",j="+j);				
			}
			System.out.println("-------");
		}
	}

}

















