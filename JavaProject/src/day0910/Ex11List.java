package day0910;

import java.util.ArrayList;
import java.util.List;

public class Ex11List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []data= {"red","green","blue","yellow","pink","green","red","gray"};
		List<String> list=new ArrayList<String>();
		//list 에 배열의 데이타를 넣어보자
		for(String d:data)
			list.add(d);
		System.out.println("list의 size:"+list.size());
		System.out.println(list);
		list.remove(2);//2번 인덱스번지 삭제
		System.out.println(list);
		list.remove("green");//첫번째 green 삭제
		System.out.println(list);
		list.clear();//전체 삭제
		System.out.println(list);
	}

}
