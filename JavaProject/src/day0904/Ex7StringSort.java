package day0904;

public class Ex7StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []datas= {"������","��ȣ��","Candy","Milk","hello","������","������"};
		
		//�������� ����
		for(int i=0;i<datas.length-1;i++)
		{
			for(int j=i+1;j<datas.length;j++)
			{
				//���������϶� ����,�Ųٷ� ���������϶� ���
				int diff=datas[i].compareTo(datas[j]);
				if(diff>0)
				{
					String temp=datas[i];
					datas[i]=datas[j];
					datas[j]=temp;
				}
			}
		}
		
		//���
		for(int i=0;i<datas.length;i++)
		{
			System.out.println(i+"=>"+datas[i]);
		}
	}

}
