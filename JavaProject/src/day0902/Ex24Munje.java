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

		     * : 공백4+별1
		    ** : 공백3+별2
		   *** : 공백2+별3
		  **** : 공백1+별4
         ***** : 공백0+별5
		
		**/
		//다 한사람은 캡쳐해서 올려주세요
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
			//공백
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















