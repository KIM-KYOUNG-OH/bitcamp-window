package day0904;

public class Ex8StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []name= {"������","��ȣ��","������","������","������"};
		int []age= {29,34,22,19,55};
		int []score= {89,90,78,100,90};

		System.out.println("** ������ ��� **");
		System.out.println("��ȣ\t�̸�\t����\t����");
		for(int i=0;i<name.length;i++)
		{
			System.out.println(i+1+"\t"+name[i]+"\t"+age[i]+"\t"+score[i]);
		}
		System.out.println();
		//����
		//�������� ����
		for(int i=0;i<name.length-1;i++)
		{
			for(int j=i+1;j<name.length;j++)
			{
				//���������϶� ����,�Ųٷ� ���������϶� ���
				int diff=name[i].compareTo(name[j]);
				if(diff>0)
				{
					//�̸��ٲٱ�
					String temp=name[i];
					name[i]=name[j];
					name[j]=temp;
					
					//���̹ٲٱ�
					int temp2=age[i];
					age[i]=age[j];
					age[j]=temp2;
					
					//�����ٲٱ�
					int temp3=score[i];
					score[i]=score[j];
					score[j]=temp3;
				}
			}
		}
		
		System.out.println("** ������ ��� **");
		System.out.println("��ȣ\t�̸�\t����\t����");
		for(int i=0;i<name.length;i++)
		{
			System.out.println(i+1+"\t"+name[i]+"\t"+age[i]+"\t"+score[i]);
		}
	}

}
