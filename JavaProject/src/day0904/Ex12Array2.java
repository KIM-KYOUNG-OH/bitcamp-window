package day0904;

public class Ex12Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][]arr= {
				{"red","green","blue"},
				{"white","yellow"}
		};
		
		System.out.println("�హ��:"+arr.length);
		System.out.println("0���� ������ :"+arr[0].length);
		System.out.println("1���� ������ :"+arr[1].length);
		
		System.out.println("��� 1");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("��� 2");
		for(String []a:arr)
		{
			for(String s:a)
			{
				System.out.printf("%-10s",s);
			}
			System.out.println();
		}
	}

}










