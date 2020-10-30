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
			System.out.println("사원명");
			sawonName=sc.nextLine();
			System.out.println("기본급");
			gibonPay=sc.nextInt();
			System.out.println("초과시간수");
			timeSu=sc.nextInt();
			System.out.println("가족수");
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
			System.out.println("사원명\t기본급\t초과시간수\t시간수당\t가족수\t가족수당\t세금\t실수령액");
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
		PayOuter pay=new PayOuter();//외부 클래스 생성
		PayOuter.InputInner input=pay.new InputInner();
		input.inputData();
		
		PayOuter.SudangInner out=pay.new SudangInner();
		out.writeData();		
	}

}










