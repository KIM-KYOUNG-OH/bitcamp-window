package day0903;

public class Ex6Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열은 할당을 하면 자동 초기화가 된다(int 는 0,String 은 null 로)
		int []arr1;
		int []arr2=new int[3];
		int []arr3= {4,6,8,9};
		arr1=new int[5];
		System.out.println("배열 크기 알아보기");
		System.out.println("arr1="+arr1.length);
		System.out.println("arr2="+arr2.length);
		System.out.println("arr3="+arr3.length);
		
		//출력
		System.out.println("arr1");
		arr1[2]=8;
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println("arr1["+i+"]="+arr1[i]);
		}
		System.out.println();
		
		System.out.println("arr2");
		arr2[0]=7;
		for(int i=0;i<arr2.length;i++)
		{
			System.out.println("arr2["+i+"]="+arr2[i]);
		}
		System.out.println();
		System.out.println("arr3");
		for(int i=0;i<arr3.length;i++)
		{
			System.out.println("arr3["+i+"]="+arr3[i]);
		}
		System.out.println();
	}

}







