package day0904;

public class Ex6Jungbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10��¥�� �迭�� 1~30 ������ ������ ���ؼ� �ִµ� 
		//�ߺ��� ���ڴ� �ٽ� ���ؼ� �ߺ�ó�� �ϱ�
		int []num=new int[10];
		Loop:
		for(int i=0;i<num.length;i++)
		{
			num[i]=(int)(Math.random()*30)+1;
			for(int j=0;j<i;j++)//���� �߻��� ���� �������� ���� ���ڰ� �ִ��� ã�´�
			{
				if(num[i]==num[j])
				{
					i--;
					//break;//���� �ݺ����� �������´�
					continue Loop;//-i++ �� �̵�
				}
			}
		}
		//������������ ����-selection sort -����for��
		for(int i=0;i<num.length-1;i++)
		{
			for(int j=i+1;j<num.length;j++)
			{
				if(num[i]>num[j])//���������̹Ƿ� ���ذ��� �� Ŭ��� �ٲ۴�
				{
					int temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		
		
		//���
		for(int n:num)
			System.out.print(n+" ");
		System.out.println();
	}

}
