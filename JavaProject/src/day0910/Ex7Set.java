package day0910;

import java.util.HashSet;
import java.util.Set;

public class Ex7Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set<String> set1=new HashSet<String>();
		//Set �� Ư¡
		//1. �������� ����(�������)
		//2. �ߺ��� ����Ÿ�� �ѹ��� ����
		Set<String> set1=new HashSet<>();//�����κ��� ���׸� Ÿ���� ��������
		
		//�ߺ��� ����Ÿ�� ��� ����� true��ȯ
		//�ߺ�����Ÿ�� �վ �ȵ���� false��ȯ
		System.out.println(set1.add("apple"));
		System.out.println(set1.add("orange"));
		System.out.println(set1.add("apple"));
		System.out.println(set1.add("Orange"));
		System.out.println(set1.add("melon"));
		System.out.println(set1.add("kiwi"));
		
		System.out.println("size="+set1.size());
		
		for(String s:set1)
			System.out.println(s);
		System.out.println(set1);//����Ÿ Ȯ��
		set1.clear();//��ü ����
		System.out.println(set1);
		
	}

}








