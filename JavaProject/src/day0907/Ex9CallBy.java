package day0907;

public class Ex9CallBy {

	public static void changeInt(int n)//call by value
	{
		System.out.println("���޹��� n��:"+n);
		n=200;
	}
	
	public static void changeString(String str)//call by value
	{
		System.out.println("���޹��� s��:"+str);
		str="java";
	}
	
	public static void changeArray(int []arr)//call by reference(��� �迭�� �ּҰ� ����)
	{
		arr[1]=7;
	}
	
	public static void changeShop(Shop shop)//call by reference
	{
		System.out.println(shop.getSang()+"\t"+shop.getSu()+"\t"+shop.getDan());
		System.out.println("shop ���� ����");
		shop.setSang("����");
		shop.setDan(3300);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=100;
		changeInt(n);//int �⺻���� ���� ����
		System.out.println("n="+n);
		
		String s="happy";
		changeString(s);
		System.out.println("s="+s);
		
		int []arr= {3,5,1,2};
		changeArray(arr);//�ּ�(reference) �� ���޵�
		for(int a:arr)
			System.out.println(a);
		
		Shop shop=new Shop();
		shop.setSang("������");
		shop.setSu(2);
		shop.setDan(1500);
		
		changeShop(shop);//�ּ�(reference) �� ���޵�
		System.out.println(shop.getSang()+"\t"+shop.getSu()+"\t"+shop.getDan());
	}
}









