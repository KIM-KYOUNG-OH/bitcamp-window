package day0910;

import java.util.HashSet;

public class Ex8Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []str= {"Java","Beans","Java","XML","XML"};
		HashSet<String> hs1=new HashSet<String>();
		HashSet<String> hs2=new HashSet<String>();
		
		for(String n:str)
		{
			//hs1�� �ߺ��Ȱ��� �־ �߰��� �ȵǴ� ��쿡��
			//hs2�� �߰��� �Ͻÿ� ��� ��
			if(!hs1.add(n))
				hs2.add(n);
		}
		
		System.out.println(hs1);
		System.out.println(hs2);
		
		System.out.println();
		hs1.removeAll(hs2);//hs1���� hs2�� ���� ����Ÿ�� �����϶�
		System.out.println(hs1);
		System.out.println(hs2);
		
	}

}
