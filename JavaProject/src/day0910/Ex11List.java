package day0910;

import java.util.ArrayList;
import java.util.List;

public class Ex11List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []data= {"red","green","blue","yellow","pink","green","red","gray"};
		List<String> list=new ArrayList<String>();
		//list �� �迭�� ����Ÿ�� �־��
		for(String d:data)
			list.add(d);
		System.out.println("list�� size:"+list.size());
		System.out.println(list);
		list.remove(2);//2�� �ε������� ����
		System.out.println(list);
		list.remove("green");//ù��° green ����
		System.out.println(list);
		list.clear();//��ü ����
		System.out.println(list);
	}

}
