package day0907;

public class Ex9CallBy {

	public static void changeInt(int n)//call by value
	{
		System.out.println("전달받은 n값:"+n);
		n=200;
	}
	
	public static void changeString(String str)//call by value
	{
		System.out.println("전달받은 s값:"+str);
		str="java";
	}
	
	public static void changeArray(int []arr)//call by reference(모든 배열은 주소가 전달)
	{
		arr[1]=7;
	}
	
	public static void changeShop(Shop shop)//call by reference
	{
		System.out.println(shop.getSang()+"\t"+shop.getSu()+"\t"+shop.getDan());
		System.out.println("shop 정보 변경");
		shop.setSang("딸기");
		shop.setDan(3300);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=100;
		changeInt(n);//int 기본형은 값만 전달
		System.out.println("n="+n);
		
		String s="happy";
		changeString(s);
		System.out.println("s="+s);
		
		int []arr= {3,5,1,2};
		changeArray(arr);//주소(reference) 가 전달됨
		for(int a:arr)
			System.out.println(a);
		
		Shop shop=new Shop();
		shop.setSang("오렌지");
		shop.setSu(2);
		shop.setDan(1500);
		
		changeShop(shop);//주소(reference) 가 전달됨
		System.out.println(shop.getSang()+"\t"+shop.getSu()+"\t"+shop.getDan());
	}
}









