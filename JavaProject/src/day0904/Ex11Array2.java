package day0904;

public class Ex11Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]arr=new int[2][3];//2��3��,���� 0���� �ʱ�ȭ
		System.out.println("�హ��:"+arr.length);
		System.out.println("0���� ������ :"+arr[0].length);
		System.out.println("1���� ������ :"+arr[1].length);
		
		
		arr[1][1]=5;
		arr[1][2]=3;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				//System.out.print(arr[i][j]+"\t");
				System.out.printf("%d(%d,%d)\t",arr[i][j],i,j);
			}
			System.out.println();
		}
	}

}
