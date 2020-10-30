package day0903;

public class Ex7Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str= {"apple","orange","banana"};
		double []num= {1.2,4.5,7.1,9.0};
		System.out.println(str.length);
		System.out.println(num.length);
		
		for(String s:str)
			System.out.println(s);
		System.out.println();
		for(double n:num)
			System.out.println(n);
	}
}
