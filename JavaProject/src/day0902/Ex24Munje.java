package day0902;

public class Ex24Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 
		1****
		*2***
		**3**
		***4*
		****5

		     * : ����4+��1
		    ** : ����3+��2
		   *** : ����2+��3
		  **** : ����1+��4
         ***** : ����0+��5
		
		**/
		//�� �ѻ���� ĸ���ؼ� �÷��ּ���
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(i==j)
					System.out.print(i);
				else
					System.out.print("*");
					
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			//����
			for(int sp=i;sp<=4;sp++)
				System.out.print(" ");
				
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}















