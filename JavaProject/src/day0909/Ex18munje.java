package day0909;

import java.text.NumberFormat;
import java.util.Scanner;

class PayOuter
{
	private String sawonName;
	private int gibonPay,timeSu,familySu;
	
	class InputInner
	{
		public void inputData()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("�����");
			sawonName=sc.nextLine();
			System.out.println("�⺻��");
			gibonPay=sc.nextInt();
			System.out.println("�ʰ��ð���");
			timeSu=sc.nextInt();
			System.out.println("������");
			familySu=sc.nextInt();
		}
	}
	
	class SudangInner
	{
		public int getTimeSudang()
		{
			return timeSu*10000;
		}
		
		public int getFamilySudang()
		{
			if(familySu<=3)
				return 200000;
			else
				return 300000;
		}
		public int getTax()
		{
			return (int)(gibonPay*0.03);
		}
		
		public void writeData()
		{
			System.out.println("--------------------------------------------------------------------");
			System.out.println("�����\t�⺻��\t�ʰ��ð���\t�ð�����\t������\t��������\t����\t�Ǽ��ɾ�");
			System.out.println("--------------------------------------------------------------------");
			NumberFormat nf=NumberFormat.getCurrencyInstance();
			System.out.println(sawonName+"\t"+nf.format(gibonPay)+"\t"
			   +timeSu+"\t"+nf.format(getTimeSudang())+"\t"+familySu+"\t"+
				nf.format(getFamilySudang())+"\t"+getTax()+"\t"+
			   nf.format(gibonPay+getTimeSudang()+getFamilySudang()-getTax()));
		}
	}
}
public class Ex18munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayOuter pay=new PayOuter();//�ܺ� Ŭ���� ����
		PayOuter.InputInner input=pay.new InputInner();
		input.inputData();
		
		PayOuter.SudangInner out=pay.new SudangInner();
		out.writeData();		
	}

}










