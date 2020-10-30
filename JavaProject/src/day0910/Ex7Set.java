package day0910;

import java.util.HashSet;
import java.util.Set;

public class Ex7Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set<String> set1=new HashSet<String>();
		//Set 의 특징
		//1. 순서없이 들어간다(비순차적)
		//2. 중복된 데이타는 한번만 들어간다
		Set<String> set1=new HashSet<>();//생성부분의 제네릭 타입은 생략가능
		
		//중복된 데이타가 없어서 들어갈경우 true반환
		//중복데이타가 잇어서 안들어갈경우 false반환
		System.out.println(set1.add("apple"));
		System.out.println(set1.add("orange"));
		System.out.println(set1.add("apple"));
		System.out.println(set1.add("Orange"));
		System.out.println(set1.add("melon"));
		System.out.println(set1.add("kiwi"));
		
		System.out.println("size="+set1.size());
		
		for(String s:set1)
			System.out.println(s);
		System.out.println(set1);//데이타 확인
		set1.clear();//전체 삭제
		System.out.println(set1);
		
	}

}








