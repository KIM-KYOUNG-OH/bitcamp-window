package day0902;

public class Ex15Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		while(true)
		{
			System.out.println(++n);
			if(n==5)
				break;//while���� ����������
		}
		System.out.println("** ���� **");
		//A~Z������ ����غ���
		int a=65;
		while(true)
		{
			System.out.print((char)a++);
			//if(a>'Z')
			if(a>90)//���� ���� ����
				break;			
		}
	}

}
