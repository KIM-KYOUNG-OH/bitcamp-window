package day0904;

public class Ex2Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []score= {56,78,34,56,90};
		int []rank=new int[5];
		//������ϱ�
		for(int i=0;i<score.length;i++)
		{
			rank[i]=1;//������ ���ѻ���� ���������� 1����(�ƹ��� ������ �ʱⰪ�� �ڱ���)
			for(int j=0;j<score.length;j++)
			{
				if(score[i]<score[j])//������ ������ �� ������
					rank[i]++;//���� ����� 1 �����Ѵ�
			}
		}
		
		System.out.println("��ȣ\t����\t���");
		for(int i=0;i<score.length;i++)
		{
			System.out.println(i+1+"\t"+score[i]+"\t"+rank[i]);
		}
	}

}
